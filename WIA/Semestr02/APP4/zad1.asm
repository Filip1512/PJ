org 0x100
%include "makro.asm"

	push word 5
	push word 4
	push word 22
	push word 2
	plus
	minus
	podziel
	pop ax
	mov ax,	0x4C
	int	0x21
	