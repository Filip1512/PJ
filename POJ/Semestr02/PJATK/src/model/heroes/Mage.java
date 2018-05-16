package model.heroes;

public class Mage extends Hero implements ICanBeHero {
	
	protected void modifyStrength() {
		strength++;
	}
	
	protected void modifyDefence() {
		defence++;
	}
	
	protected void modifyIntelligence(){
		intelligence=(int)((intelligence+1)/1.2);
		intelligence++;
		intelligence *= 1.2;
	}
	
	protected void modifyDextrity(){
		dextrity=(int)((dextrity+1)/1.05);
		dextrity++;
		dextrity *= 1.05;
	}
	
	protected void modifyAgility(){
		agility=(int)((agility+1)/1.02);
		agility++;
		agility *= 1.02;
	}
	
	protected void modifySpeed() {
		speed++;
	}

}
