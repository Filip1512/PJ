package Race;

import TheForceAwakens.*;

public class Rogue extends CharacterDecorator {
	
	public Rogue(AbstractCharacter character) {
		super(character);
	}
	
	public String getAbout() {
		String about = "You are a Rogue. \nYour abilities: Flying, VulnerableToDamage.";
		return about;
	}
	
}
