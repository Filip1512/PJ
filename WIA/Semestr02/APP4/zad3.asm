org 0x100
%include "makro.asm"

	push word 4
	push word [c]
	push word [b]
	push word 3
	push word [a]
	push word 2
	plus
	minus
	podziel
	pop ax
	mov ax,	0x4C
	int	0x21

a dw 2
b dw 3
c dw 4