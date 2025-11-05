package game.characters.players.classes;

import java.util.*;

public class Barbarian implements CharacterClass {
    @Override public ArrayList<String> setSkillProf(){
        ArrayList<String> res = new ArrayList<>();
        //create list of proficiencies available to class
        ArrayList<String> classProficiencyArrayList = new ArrayList<>(Arrays.asList(
        "Animal Handling", "Athletics", "Intimidation", "Nature", "Perception", "Survival"
        )); 
        //loop to set class-based proficiencies
        try (Scanner s = new Scanner(System.in)) {
            int i = 0;
            while (i < 2) {
                System.out.println("\nAvailable proficiencies:");
                for (int j = 0; j < classProficiencyArrayList.size(); j++) {
                    System.out.printf("[%d] %s\n", j+1, classProficiencyArrayList.get(j));
                }
                
                System.out.printf("Pick a proficiency (%d of 2): ", i + 1);
                int userInput;
                //if userInput is outside range of list, throw error and scrap the current loop
                try {
                    userInput = s.nextInt() - 1;
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    s.nextLine(); //clear invalid input
                    continue;
                }
                
                //another validity check
                if (userInput < 0 || userInput >= classProficiencyArrayList.size()) {
                    System.out.println("Not a valid proficiency index.");
                    continue;
                }
                
                //create string and attach choice to result arraylist
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
        return "Barbarian";
    }
    @Override public ArrayList<String> getPrimaryAbility(){
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Strength"));
        return res;
    }
    @Override public int getHitDieType(){
        return 12;
    }
    @Override public ArrayList<String> getSavingThrowProf(){
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Strength", "Constitution"));
        return res;
    }
    @Override public ArrayList<String> getWeaponProf(){
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Simple", "Martial"));
        return res;
    }
    @Override public ArrayList<String> getArmorProf(){
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Light", "Medium", "Shields"));
        return res;
    }

    //testing
    // public static void main(String[] args) {
    //     Barbarian b = new Barbarian();
    //     ArrayList<String> prof = new ArrayList<>();
    //     prof.addAll(b.setSkillProf());
    //     System.out.printf("Proficiencies: "+prof);
    //     b.getPrimaryAbility();
    // }
}
