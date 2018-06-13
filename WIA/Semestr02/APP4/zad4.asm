org 0x100
	mov ah,01
		int 21h
	
	literka:
	mov dx, nie
	mov ah, 09
		int 21h
	
	cmp AL, 48
	JL literka
	cmp AL, 57
	JG literka
	
	JMP cyfra
	
	cyfra: 
	mov dx, tak
	mov ah, 09
		int 21h
	
	
	mov ax,	0x4C
	int	0x21

tak dw " - to jest cyfra $" 
nie dw " - to jest znak $"