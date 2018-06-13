app2:

org 0x100
	mov	 ah,	9
	mov	 dx,	zmienna
	int 	0x21

	mov	 ax,	0x4C00
	int 	0x21

zmienna	db	"Hello world, ","hello Assembler$"
