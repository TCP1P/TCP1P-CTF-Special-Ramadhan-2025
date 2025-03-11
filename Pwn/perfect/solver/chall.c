#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int setup() {
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stdin, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);
}

void win() {
    char buf[32];
    FILE *file = fopen("flag.txt", "r");

    if (file == NULL) {
      perror("Failed to open flag file");
      exit(EXIT_FAILURE);
    }

    fgets(buf, sizeof(buf), file);
    printf("gampanglah ya hehe : %s", buf);
    fclose(file);
    exit(EXIT_SUCCESS);
}

int perfect(){
	fflush(stdout);
	puts("sebutkan di dunia ini apa yang 'Perfect' menurut kamu?");
	char buf[0x200];
	fgets(buf, sizeof(buf), stdin);
	printf(buf);
	puts("apa alasan mengapa dia itu perfect ?");
	fgets(buf, sizeof(buf), stdin);
	printf(buf);
    printf("\nnahh. 'i dont deserve this, she look perfect tonight:)\n");
	fflush(stdout);
}

int main(){
	setup();
	perfect();
	return 0;
}