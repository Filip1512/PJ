package TheForceAwakens;

public abstract class AbstractCharacter {
	
	protected String name;	// static?
	protected String about;

	public abstract String getAbout();
	
	public String printAbout() {
		return name + getAbout();
	}
}
