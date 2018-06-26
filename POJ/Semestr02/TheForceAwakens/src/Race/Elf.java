package Race;

import TheForceAwakens.*;

public class Elf extends CharacterDecorator {
	
	public Elf(AbstractCharacter character) {
		super(character);
	}
	
	public String getAbout() {
		String about = "You are an Elf. \nYour abilities: DarkVision, SuperDextrity. ";
		return about;
	}
	
}
