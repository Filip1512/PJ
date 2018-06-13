
app3:

org 100h
mov     ax, 13h                                 ; przejscie w tryb graficzny
int 10h

                mov ax, 0A000h          ; pamiec karty graficznej (w trybie 80x$
                mov es, ax                      ; pamiec karty graficznej do re$
                mov di, 28945           ; (64000 wielkosc) ustawiamy poczatek m$

        ; prostokat 30 x 20
        mov cx, 30
        pasekPoziomy1:
        mov byte [es:di], 0Fh   ; bialy znak na bialym tle (di: 0000 znak / 0$
        add di, 1
        loop pasekPoziomy1

        mov di, 35345
        mov cx, 30
        pasekPoziomy2:
        mov byte [es:di], 0Eh   ; bialy znak na czerwonym tle (di: 0000 znak / 0$
        add di, 1
        loop pasekPoziomy2
        
        ; pionowe paski
        
        mov di, 28945
        mov cx, 20
        pasekPionowy1:
        mov byte [es:di], 0Bh   ; bialy znak na jasnoblekitnym tle (di: 0000 znak / 0$
        add di, 320
        loop pasekPionowy1
        
        mov di, 28974
        mov cx, 20
        pasekPionowy2:
        mov byte [es:di], 0Ch   ; bialy znak na czerwonym tle (di: 0000 znak / 0$
        add di, 320
        loop pasekPionowy2
        

        xor ah, ah                              ; wyzerowanie ah
                int 16h                         ; oczekiwanie nacisniecia klawi$
                mov ax, 3                       ; powrot od trybu tekstowego
                int 10h
        mov ax, 4c00h                   ; zaqkonczenie programu
int 21h

