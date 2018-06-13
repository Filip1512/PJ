org 0x100
	
	push word [b]
	push word a
	call funkcja

	mov ax, 0x4C00
	int 21h
	
a db "teskt1 $"		; tworzenie zmiennych typu DB
b dw 20

funkcja:
	push bp
	mov bp, sp
	add	bp, 4
	mov dx, [bp]
	mov cx, [bp+2]
	petla:
		mov ah, 09h
		int 21h
	loop petla
	pop bp
	ret
	