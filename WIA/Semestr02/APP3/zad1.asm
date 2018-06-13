app3:

org 0x100
	mov	cx,	100
	
	wypisz:
	mov ah,	9
	mov	dx,	imie
	int	0x21
	
	loop wypisz
	
	mov ax,	0x4C00
	int	0x21
imie	db	"Filip $"