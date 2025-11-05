package game.characters.players.classes;

import java.util.*;

public class Fighter implements CharacterClass {
    @Override public ArrayList<String> setSkillProf(){
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> classProficiencyArrayList = new ArrayList<>(Arrays.asList(
            "Acrobatics", "Animal Handling", "Athletics", "History", "Insight", "Intimidation", "Persuasion", "Perception", "Survival"
        )); 
        
        try (Scanner s = new Scanner(System.in)) {
            int i = 0;

            while (i < 2) {
                System.out.println("\nAvailable proficiencies:");
                for (int j = 0; j < classProficiencyArrayList.size(); j++) {
                    System.out.printf("[%d] %s\n", j + 1, classProficiencyArrayList.get(j));
                }
                
                System.out.printf("Pick a proficiency (%d of 2): ", i + 1);
                int userInput;
                
                try {
                    userInput = s.nextInt() - 1;
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    s.nextLine();
                    continue;
                }
                
                if (userInput < 0 || userInput >= classProficiencyArrayList.size()) {
                    System.out.println("Not a valid proficiency index.");
                    continue;
                }
                
                String chosen = classProficiencyArrayList.get(userInput);
                res.add(chosen);
                classProficiencyArrayList.remove(userInput);
                i++;
                
                System.out.printf("Added %s to your proficiencies.\n", chosen);
            }
        }
        return res;
    }
    
    @Override public String getClassName(){
        return "Fighter";
    }
    @Override public ArrayList<String> getPrimaryAbility(){
        ArrayList<String> res = new ArrayList<>();
        int userInput;
        try(Scanner s = new Scanner(System.in)){
            while(true){
                System.out.println("Primary Ability:\n1. Strength\n2. Dexterity");
                userInput = s.nextInt();
                if(userInput < 0 || userInput > 2){
                    System.out.println("Invalid index");
                    continue;
                }
                break;
            }
            res.add((userInput == 1) ? "Strength" : "Dexterity");
        }
        return res;
    }
    @Override public int getHitDieType(){
        return 10;
    }
    @Override public ArrayList<String> getSavingThrowProf(){
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Simple", "Martial"));
        return res;
    }
    @Override public ArrayList<String> getWeaponProf(){
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Light", "Medium", "Heavy", "Shields"));
        return res;
    }
    @Override public ArrayList<String> getArmorProf(){
       ArrayList<String> res = new ArrayList<>(Arrays.asList(""));
        return res;
    }

    //testing
    // public static void main(String[] args) {
    //     Fighter f = new Fighter();
    //     f.getPrimaryAbility();
    // }
}
