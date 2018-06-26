package TheForceAwakens;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

import Race.*;
import Proffesion.*;

public class Main {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
			Scanner input = new Scanner(System.in);
		
			System.out.println("Hello.");
			//Thread.sleep(1500);
			System.out.println("This is character creator made by Filip Krzysztofik.");
			//Thread.sleep(3000);
			System.out.println("Enjoy!");
			System.out.println();
			//Thread.sleep(1000);
			
			ArrayList<Character> ListOfCharacters = new ArrayList<Character>();
				
			File plik = new File("characters.txt");
			PrintWriter zapisz = new PrintWriter(plik);
			
			AbstractCharacter character = null;
			
			String text;
			do {
				System.out.println("Write 'create' to create new character or 'exit' to close program and save data in file.");
				
				text = input.nextLine();
				if(text.equalsIgnoreCase("create")) {
					
					character = new Character();
					
					System.out.println("Choose your name");
					character.name = input.nextLine();
					character.name = character.name.substring(0, 1).toUpperCase() + character.name.substring(1).toLowerCase();
					
					System.out.println("Choose your race (Dwarf, Elf, Human, Rogue)");
					String race = input.nextLine();
					
					switch(race.toLowerCase()) {
					case "dwarf": character = new Dwarf(character); break;
					case "elf": character = new Elf(character); break;
					case "human": character = new Human(character); break;
					case "rogue": character = new Rogue(character); break;
					default: character = new Dwarf(character); break;
					}
					//zapisz.println(character.getAbout());
					
					System.out.println("Choose your first proffesion (Assassin, Blacksmith, Hunter, Mage, Warrior)");
					String profession = input.nextLine();
					
					switch(profession.toLowerCase()) {
					case "assassin": character = new Assassin(character); break;
					case "blacksmith": character = new Blacksmith(character); break;
					case "hunter": character = new Hunter(character); break;
					case "mage": character = new Mage(character); break;
					case "warrior": character = new Warrior(character); break;
					default: character = new Assassin(character); break;
					
					}
					//zapisz.println(character.getAbout());
					
					System.out.println("Choose your second proffesion (Assassin, Blacksmith, Hunter, Mage, Warrior)");
					String profession2 = input.nextLine();
					
					switch(profession2.toLowerCase()) {
					case "assassin": character = new Assassin(character); break;
					case "blacksmith": character = new Blacksmith(character); break;
					case "hunter": character = new Hunter(character); break;
					case "mage": character = new Mage(character); break;
					case "warrior": character = new Warrior(character); break;
					default: character = new Blacksmith(character); break;
					}
					
					for(Character arrayElement : ListOfCharacters) {
						zapisz.println(arrayElement.printAbout());
					}
				}
				else if (text.equalsIgnoreCase("exit")) break;
				else continue;
			} while (!(text.equalsIgnoreCase("exit")));
			
			zapisz.println(ListOfCharacters);
			zapisz.println();
			zapisz.close();
			input.close();
	}
}
