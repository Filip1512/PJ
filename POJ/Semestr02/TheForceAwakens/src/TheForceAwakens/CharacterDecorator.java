package TheForceAwakens;

public abstract class CharacterDecorator extends AbstractCharacter {
	
	protected AbstractCharacter character;
	
	public CharacterDecorator(AbstractCharacter character) {
		this.character = new Character();
	}
	
}
