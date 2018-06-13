prog01:

org 0x100			; rozpoczynamy od takiego momentu pamieci
	mov ah, 9		; z jakiej instrukcji bedziemy korzystac (9) - wyswietlenie czegos na monitorze (stand. wyjscie)
	mov dx, hello_world	; stworzenie zmiennej
	int 0x21		; przerwanie nr 21 (zakonczenie programu)
	
	mov ax, 0x4C00
	int 0x21
	
hello_world db "Hello world !$"	; wywolanie etykiety