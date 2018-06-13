%include "Makro.asm"
org 100h
	push word 50
	push word [y]
	push word [x]
	minus
	podziel
	push word 20
	push word [x]
	pomnoz
	plus
	pop ax

	mov ax, 2
	mov dl, al
		int 21h

	mov ax, 4c00h
		int 21h

x: dw 1
y: dw 1
z: dw 0		; z = 20*x+50/(x-y)
