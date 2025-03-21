#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

void setup() {
    setvbuf(stdin, NULL, _IONBF, 0);
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);
    // __asm__("pop %rdi; ret");
}

unsigned char get_rand() {
    unsigned int seed;
    seed = time(NULL);
    srand(seed);
    return (unsigned char)(rand() % 256);
}

size_t xor_encrypt(char *input, char key) {
    size_t i;
    for (i = 0; i < strlen(input); ++i) {
        input[i] ^= key;
    }
    return i;
}

void menu(){
    puts("1. mw");
    puts("2. untuk siapa?");
    puts("3. feedback");
    puts("4. exit");
}

void mw(){
    char buffer[72];
    printf("> ");
    fgets(buffer,256,stdin);
    puts("oke");
}

void siapa(){
    int key;
    key = get_rand();
    char buf[100];
    printf("> ");
    fgets(buf,100,stdin);
    xor_encrypt(buf,key);
    printf("hai : ");
    printf(buf);
    putchar(10);
    //puts("\n");
}

int readint() {
    char buf[0x9];
    fgets(buf, 0x9, stdin);
    return atoi(buf);
}

int main() {
    setup();
    int pilih;
    puts("Mau tinggalkan pesan untuk seseorang gak????????");
    while(1){
        menu();
        printf("> ");

        pilih = readint();

        switch (pilih) {
            case 1:
                mw();  
                break;
            case 2:
                siapa();  
            case 3:
                puts("dalam perbaikan!!!");
                break; 
            case 4:
                puts("bye");
                exit(0);
            default:
                puts("pilih yg bener dong");
        }
    }
}
