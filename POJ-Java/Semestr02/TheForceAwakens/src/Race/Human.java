package Race;

import TheForceAwakens.*;

public class Human extends CharacterDecorator {
	
	public Human(AbstractCharacter character) {
		super(character);
	}
	
	public String getAbout() {
		String about = "You are a Human. \nYou haven't any abilities";
		return about;
	}
	
}
