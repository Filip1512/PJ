org 0x100
	
	mov	ah,	8
		int 0x21
	
	mov	cx, ax
	wypisz:
		mov ah,	9
		mov	dx,	imie
			int	0x21
	loop wypisz
	
	mov ax,	0x4C00
	int	0x21
	
imie	db	"Filip $"