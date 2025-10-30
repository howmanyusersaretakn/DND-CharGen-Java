package game;

import game.characters.*;
import game.items.*;
import game.systems.*;
import java.util.*;

public class Main {
    static int diceRoll(int sides, int quantity){
        Random rand = new Random();
        int res = 0;
        for(int i = 0; i < quantity; i++){
            res = rand.nextInt(sides) + 1;
        }
        return res;
    }

    static int bestOfThree(int num1, int num2, int num3){
        int largest = num3 > (num1>num2 ? num1:num2) ? num3:((num1>num2) ? num1:num2);
        return largest;
    }

    static void createCharacterList(playerCharacter[] list, int numChar){
        String[] classList = {"Barbarian","Bard","Cleric","Druid","Fighter","Monk","Paladin","Ranger","Rogue","Sorceror","Warlock","Wizard"};
        String[] speciesList = {""};
        try (Scanner s = new Scanner(System.in)) {
            for(int i = 0; i < numChar; i++){
                list[i] = new PlayerCharacter();
                System.out.printf("-----Character %d-----", i);
                System.out.println("Set Character Name: ");
                String nameString = s.nextLine();
                System.out.println("Pick Background: ");
                String bkgdString = s.nextLine();
                System.out.println("Set Character Name: ");
                String specString = s.nextLine();
                
                list[i].setNonChangingInfo(nameString, bkgdString, specString);

                System.out.println("Pick a class from the following list:");
                
                for(String j : classList) System.out.printf("%s\n", j);
                
                String className = s.nextLine().toLowerCase();
                
                list[i].setClass(className);
                
                if(list[i].getClass() == null) continue;
                
                setCharStats(list[i]);

                break;
            }
        }
    }

    static void setCharStats(playerCharacter character){
        String[] statList = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        for(int i = 0; i < 6; i++){
            int points = bestOfThree(diceRoll(6, 1), diceRoll(6, 1), diceRoll(6, 1));
            character.setStat(statList[i].toLowerCase(), points);
        }
        character.setHP(diceRoll(character.getCharClass().getHitDieType(), character.getLvl()));

    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("How many characters are we creating?\n");
            int numCharacters = s.nextInt();
            PlayerCharacter[] playerList = new PlayerCharacter[numCharacters];
            createCharacterList(playerList, numCharacters);
        }
    }

}
