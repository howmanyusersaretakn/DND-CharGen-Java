package game.characters.players.classes;

import java.util.*;

public class Ranger implements CharacterClass {
    @Override public ArrayList<String> setSkillProf(){
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> classProficiencyArrayList = new ArrayList<>(Arrays.asList(
            "Animal Handling", "Athletics", "Insight", "Investigation", "Nature", "Perception", "Stealth", "Survival"
        )); 
        
        try (Scanner s = new Scanner(System.in)) {
            int i = 0;

            while (i < 3) {
                System.out.println("\nAvailable proficiencies:");
                for (int j = 0; j < classProficiencyArrayList.size(); j++) {
                    System.out.printf("[%d] %s\n", j + 1, classProficiencyArrayList.get(j));
                }
                
                System.out.printf("Pick a proficiency (%d of 3): ", i + 1);
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
        return "Ranger";
    }
    @Override public ArrayList<String> getPrimaryAbility(){
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Dexterity", "Wisdom"));
        return res;
    }
    @Override public int getHitDieType(){
        return 10;
    }
    @Override public ArrayList<String> getSavingThrowProf(){
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Strength", "Dexterity"));
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
}
