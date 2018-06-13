app2:

org 0x100
	mov	al,	1
	int 0x21

	mov	ah,	9
	mov	dx, wynik
	int	0x21

	mov	dl,	al
	mov	ah,	6

	mov	ah,	0x4C
	int	0x21

wynik db " | $"
