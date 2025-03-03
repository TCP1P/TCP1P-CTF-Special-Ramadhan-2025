#include <stdio.h>
#include <stdlib.h>

int setup() {
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stdin, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);
    __asm__("mov %rbp, %rdi");
}

int vuln() {
    char buf[20];
    printf("WOIII JANGAN MASUK SINIII\n");
    printf("btw, kue pie nya enak gaaakkk hihi : ");
    fgets(buf, 100, stdin);
    printf("%s\n\n", buf);
}

void menu() {
    puts("\nSemangat Berpuasa kamu :)");
    puts("bentar lagi buka kok ehe");
    puts("btw kamu mau berbuka pakai apa?");
    puts("1. mi ayam");
    puts("2. kue PIE");
    puts("3. apa ini?");
    puts("4. Exit");
}

int readint() {
    char buf[0x9];
    fgets(buf, 0x9, stdin);
    return atoi(buf);
}

int main() {
    setup();
    int pilih;
    while (1) {
        menu();
        pilih = readint();
        switch (pilih) {
            case 1:
                puts("emm enak tuuuu :)");
                puts("ak jg mw\n\n");
                break;
            case 2: {
                int p;
                puts("KUEEEEE PIEEEEEE KESUKAANKUUU");
                puts("KAMU JUGA MAU?");
                puts("BOLEH");
                puts("iniiiiiiiiii");
                puts("ketik 1 dulu kalau mau ehe");
                p = readint();
                if (p == 1) {
                    printf("oke okeeeyy ini pie nya untukmuu, %p\n", (void *)main);
                } else {
                    printf("\naku marah banget\n");
                }
                break;
            }
            case 3:
                vuln();
                break;
            case 4:
                puts("Bye bye!");
                exit(0);
            default:
                puts("Pilihan tidak valid.");
        }
    }
}
