package model.heroes;

public abstract class Hero {
	
	protected int avaiableStatsPoints;
	protected String name;

	protected int strength;
	protected int defence;
	protected int intelligence;
	protected int dextrity;
	protected int agility;
	protected int speed;
	
	protected abstract void modifyStrength();
	protected abstract void modifyDefence();
	protected abstract void modifyIntelligence();
	protected abstract void modifyDextrity();
	protected abstract void modifyAgility();
	protected abstract void modifySpeed();
	
	public int getStrenght(){
		return strength;
	}
	public int getDefence(){
		return defence;
	}
	public int getIntelligence(){
		return intelligence;
	}
	public int getDextrity(){
		return dextrity;
	}
	public int getAgility(){
		return agility;
	}
	public int getSpeed(){
		return speed;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public int getAvaiableStatsPoints() {
		return avaiableStatsPoints;
	}
	
	public void levelUp(){
		avaiableStatsPoints += 10;
	}
	
	
	public void raiseStr(){
		if (avaiableStatsPoints <=0) return;
		modifyStrength();
		avaiableStatsPoints--;
	}
	
	public void raiseDef(){
		if (avaiableStatsPoints <= 0) return;
		modifyDefence();
		avaiableStatsPoints--;
	}
	
	public void raiseInt(){
		if (avaiableStatsPoints <= 0) return;
		modifyIntelligence();
		avaiableStatsPoints--;
	}
	
	public void raiseDex(){
		if (avaiableStatsPoints <= 0) return;
		modifyDextrity();
		avaiableStatsPoints--;
	}
	
	public void raiseAgi(){
		if (avaiableStatsPoints <= 0) return;
		modifyAgility();
		avaiableStatsPoints--;
	}
	
	public void raiseSpd(){
		if (avaiableStatsPoints <= 0) return;
		modifySpeed();
		avaiableStatsPoints--;
	}
	
	public void printoutHero(){
		System.out.println("-----------------------------------------------------------");
		System.out.println(getName()+ "\t|"
				+ "str: "+ getStrenght() + "\t|"
				+ "def: "+getDefence() + "\t|"
				+ "int: "+getIntelligence() + "\t|"
				+ "agi: "+getAgility() + "\t|"
				+ "dex: "+getDextrity() + "\t|"
				+ "speed: "+getSpeed() + " |");
		System.out.println("-----------------------------------------------------------");
	}
	
	
}
