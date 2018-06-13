app3:

org 100h
mov	ah, 00h					; przejscie w tryb graficzny
mov al, 03h					; tryb 3 (80x25)

int 10h
		mov ax, 0b800h		; pamiec karty graficznej (w trybie 80x25)
		mov es, ax			; pamiec karty graficznej do rejestru es
		mov di, 1971		; ustawiamy poczatek miejsca wypisywania na tablicy tekstowej

	mov cx, 30
	pasek:
	mov byte [es:di], 40h	; bialy znak na zielonym tle (di: 0000 tlo / 0000 kolor znaku)
	add di, 2
	loop pasek
	
	xor ah,	ah				; wyzerowanie ah
		int 16h				; oczekiwanie nacisniecia klawisza
		mov ax, 3			; powrot od trybu tekstowego
		int 10h
	mov ax, 4c00h			; zaqkonczenie programu
int 21h
	