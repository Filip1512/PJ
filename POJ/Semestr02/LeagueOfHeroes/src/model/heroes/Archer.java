package model.heroes;

public class Archer extends Hero implements ICanBeHero{
	
	protected void modifyStrength(){
		strength=(int)((strength+1)/1.05);
		strength++;
		strength *= 1.05;
	}
	
	protected void modifyDefence(){
		defence=(int)((defence+1)/1.05);
		defence++;
		defence *= 1.05;
	}
	
	protected void modifyIntelligence() {
		intelligence++;
	}
	
	protected void modifyDextrity(){
		dextrity=(int)((dextrity+1)/1.2);
		dextrity++;
		dextrity *= 1.2;
	}
	
	protected void modifyAgility(){
		agility=(int)((agility+1)/1.1);
		agility++;
		agility *= 1.1;
	}
	
	protected void modifySpeed(){
		speed=(int)((speed+1)/1.05);
		speed++;
		speed *= 1.05;
	}
	
	@Override
	public void printoutHero(){
		System.out.println("-----------------------------------------------------------");
		System.out.println(getName()+ "\t|"
				+ "str: "+getStrenght() + "\t|"
				+ "def: "+getDefence() + "\t|"
				+ "int: "+getIntelligence() + "\t|"
				+ "agi: "+getAgility() + "\t|"
				+ "dex: "+getDextrity() + "\t|"
				+ "speed: "+getSpeed() + " |");
		System.out.println("-----------------------------------------------------------");
	}
	
}
