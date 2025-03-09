#include <stdio.h>
#include <stdlib.h>

void vuln(void) {
    char buf[256];
    printf("Good luck!\n>> ");
    scanf("%256s", buf);
    printf("Goodbye!\n");
}

int main(void) {
    setvbuf(stdin, NULL, _IONBF, 0);
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);
    vuln();
    return 0;
}