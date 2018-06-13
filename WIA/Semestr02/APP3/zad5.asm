app3:

org 100h
mov	ax, 13h					; przejscie w tryb graficzny
int 10h

		mov ax, 0A000h		; pamiec karty graficznej (w trybie 80x25)
		mov es, ax			; pamiec karty graficznej do rejestru es
		mov di, 32000		; ustawiamy poczatek miejsca wypisywania na tablicy tekstowej

	mov cx, 320
	pasekPoziomy:
	mov byte [es:di], 0Fh	; bialy znak na zielonym tle (di: 0000 znak / 0000 kolor tlo)
	add di, 1
	loop pasekPoziomy
	
	mov di, 160
	mov cx, 200
	pasekPionowy:
	mov byte [es:di], 0Fh	; bialy znak na zielonym tle (di: 0000 znak / 0000 kolor tlo)
	add di, 320
	loop pasekPionowy
	
	xor ah,	ah				; wyzerowanie ah
		int 16h				; oczekiwanie nacisniecia klawisza
		mov ax, 3			; powrot od trybu tekstowego
		int 10h
	mov ax, 4c00h			; zaqkonczenie programu
int 21h