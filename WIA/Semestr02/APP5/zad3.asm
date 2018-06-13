org 0x100
	
	push word tekst
	push word [y]
	push word [x]
	call gotoxy

	mov ax, 0x4C00
	int 21h
	
tekst db "tekst1 $"		; tworzenie zmiennych typu DB
x dw 40
y dw 12

gotoxy:
	mov ah, 0h
	mov al, 02h
		int 10h 		; tryb graficzny 80x25
	
	push bp				; zczytywanie stosu
	mov bp, sp
	add bp, 4
	mov dl, [bp]		; x
	mov dh, [bp+2]		; y
	mov ah, 02h			; ustawienie kursora
		int 10h
	
	mov dx, [bp+4]
		mov ah, 09h
		int 21h
	
	mov ah, 0			; oczekiwanie klawisza
		int 16h
	
	mov ah, 3			; powrot do dosboxa
		int 10h
	
	pop bp
	ret