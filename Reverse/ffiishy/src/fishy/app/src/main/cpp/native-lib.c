#include <jni.h>
#include <android/log.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#define LOG_TAG "NativeCode"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)

char *sanitizeString(const char *input)
{
  static char sanitized[1024];
  int i, j = 0;
  for (i = 0; input[i] != '\0'; ++i)
  {
    sanitized[j++] = (input[i] >= 32 && input[i] <= 126) ? input[i] : '?';
  }
  sanitized[j] = '\0';
  return sanitized;
}

void bigint_to_bytes(const char *bigintStr, unsigned char **out, int *out_len)
{
  char *value = strdup(bigintStr);
  if (!value)
  {
    perror("strdup");
    return;
  }

  unsigned char *result = NULL;
  size_t result_len = 0;

  while (*value)
  {
    int remainder = 0;
    char nextValue[strlen(value) + 1];
    size_t nextValue_len = 0;

    for (size_t i = 0; value[i]; i++)
    {
      int current = remainder * 10 + (value[i] - '0');
      nextValue[nextValue_len++] = (current / 256) + '0';
      remainder = current % 256;
    }
    nextValue[nextValue_len] = '\0';

    result = realloc(result, result_len + 1);
    if (!result)
    {
      perror("realloc");
      free(value);
      return;
    }
    memmove(result + 1, result, result_len);
    result[0] = (unsigned char)remainder;
    result_len++;

    char *nonZeroPos = nextValue;
    while (*nonZeroPos == '0')
      nonZeroPos++;
    strcpy(value, nonZeroPos);
  }

  if (result_len == 0)
  {
    result = malloc(1);
    result[0] = 0x00;
    result_len = 1;
  }

  *out = result;
  *out_len = result_len;

  free(value);
}

JNIEXPORT jstring JNICALL Java_com_something_fishy_MainActivity_calc(
    JNIEnv *env, jobject thiz, jstring input, int pos, jobject context)
{
  char method[20];
  snprintf(method, sizeof(method), "calc%d", pos);

  jclass cls = (*env)->GetObjectClass(env, thiz);
  jmethodID methodId = (*env)->GetMethodID(env, cls, method, "(Ljava/lang/String;I)Ljava/lang/String;");

  if (methodId == NULL)
  {
    (*env)->ExceptionClear(env);

    jclass contextClass = (*env)->GetObjectClass(env, context);
    jmethodID getResourcesMethod = (*env)->GetMethodID(env, contextClass, "getResources", "()Landroid/content/res/Resources;");
    jobject resourcesObj = (*env)->CallObjectMethod(env, context, getResourcesMethod);

    jclass resourcesClass = (*env)->GetObjectClass(env, resourcesObj);
    jmethodID getIdentifierMethod = (*env)->GetMethodID(env, resourcesClass, "getIdentifier", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I");

    jint flagId = (*env)->CallIntMethod(env, resourcesObj, getIdentifierMethod, (*env)->NewStringUTF(env, "flag"), (*env)->NewStringUTF(env, "string"), (*env)->NewStringUTF(env, "com.something.fishy"));
    jmethodID getStringMethod = (*env)->GetMethodID(env, resourcesClass, "getString", "(I)Ljava/lang/String;");

    jstring fakeflag = (jstring)(*env)->CallObjectMethod(env, resourcesObj, getStringMethod, flagId);

    const char *fakeflagchars = (*env)->GetStringUTFChars(env, fakeflag, NULL);
    const char *calcresultchars = (*env)->GetStringUTFChars(env, input, NULL);

    if (strcmp(calcresultchars, "133713371337") != 0)
    {
      return (*env)->NewStringUTF(env, "wrong");
    }

    jclass clazz = (*env)->GetObjectClass(env, thiz);
    jfieldID bindingField = (*env)->GetFieldID(env, clazz, "binding", "Lcom/something/fishy/databinding/ActivityMainBinding;");
    jobject bindingObject = (*env)->GetObjectField(env, thiz, bindingField);

    jclass bindingClass = (*env)->GetObjectClass(env, bindingObject);

    jfieldID edittField = (*env)->GetFieldID(env, bindingClass, "editt", "Landroid/widget/EditText;");
    jobject editTextObject = (*env)->GetObjectField(env, bindingObject, edittField);

    jclass editTextClass = (*env)->GetObjectClass(env, editTextObject);

    jmethodID getTextMethod = (*env)->GetMethodID(env, editTextClass, "getText", "()Landroid/text/Editable;");
    jobject editableObject = (*env)->CallObjectMethod(env, editTextObject, getTextMethod);

    jclass editableClass = (*env)->GetObjectClass(env, editableObject);
    jmethodID toStringMethod = (*env)->GetMethodID(env, editableClass, "toString", "()Ljava/lang/String;");
    jstring textContent = (jstring)(*env)->CallObjectMethod(env, editableObject, toStringMethod);

    const char *textCStr = (*env)->GetStringUTFChars(env, textContent, NULL);

    unsigned char *xorKeyBytes = NULL;
    int length = 0;

    bigint_to_bytes(textCStr, &xorKeyBytes, &length);

    char result[1024];
    for (size_t i = 0; i < strlen(fakeflagchars); ++i)
    {
      result[i] = fakeflagchars[i] ^ xorKeyBytes[i];
    }
    result[strlen(fakeflagchars)] = '\0';

    return (*env)->NewStringUTF(env, sanitizeString(result));
  }

  return (jstring)(*env)->CallObjectMethod(env, thiz, methodId, input, pos);
}
