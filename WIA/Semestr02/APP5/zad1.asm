org 0x100
	
	mov bx, a
	call print
	mov bx, b
	call print
	mov bx, c
	call print
	
	mov ax, 0x4C00
	int 0x21

a db "teskt1 ", 0	; tworzenie zmiennych typu DB
b db "tekst2 ", 0
c db "tekst3 ", 0

print:
	mov ah, 02h		; wyswietla na standardowym wyjsciu znak z DL
	mov dl, [bx]	; do rejestru DL kopiujemy BX
	cmp dl, 0
	je end			; skok na koniec funkcji, jezeli w DL bedzie 0
	int 0x21		; wyswietlenie znaku
		inc bx		; inkrementacja rejestru BX
	jmp print
end:
	ret