package Race;

import TheForceAwakens.*;

public class Dwarf extends CharacterDecorator {
	
	public Dwarf(AbstractCharacter character) {
		super(character);
	}
	
	public String getAbout() {
		String about = "You are a Dwarf. \nYour abilities: DarkVision, SuperEndurance. ";
		return about;
	}
	
}
