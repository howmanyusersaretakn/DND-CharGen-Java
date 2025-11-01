package game.characters.classes;

import java.util.*;

import game.characters.players.*;

public class Bard implements CharacterClass {
    @Override public ArrayList<String> setSkillProf() {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> classProficiencyArrayList = new ArrayList<>(Arrays.asList(
            "acrobatics", "animal handling", "arcana", "athletics",
            "deception", "history", "insight", "intimidation",
            "investigation", "medicine", "nature", "perception",
            "performance", "persuasion", "religion",
            "sleight of hand", "survival"
        ));

        try (Scanner s = new Scanner(System.in)) {
            int i = 0;
            
            while (i < 3) {
                System.out.println("\nAvailable proficiencies:");
                for (int j = 0; j < classProficiencyArrayList.size(); j++) {
                    System.out.printf("[%d] %s\n", j, classProficiencyArrayList.get(j));
                }
                
                System.out.printf("Pick a proficiency (%d of 3): ", i + 1);
                int userInput;
                
                try {
                    userInput = s.nextInt();
                } catch (Exception e) {
                    System.out.println("Please enter a valid number.");
                    s.nextLine(); // clear invalid input
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
        return "Bard";
    }
    @Override public String getPrimaryAbility(){
        return "Strength";
    }
    @Override public int getHitDieType(){
        return 12;
    }
    @Override public ArrayList<String> getSavingThrowProf(){
        ArrayList<String> res = new ArrayList<>();
        res.add("Strength");
        res.add("Constitution");
        return res;
    }
    @Override public ArrayList<String> getWeaponProf(){
        ArrayList<String> res = new ArrayList<>();
        res.add("Simple");
        res.add("Martial");
        return res;
    }
    @Override public ArrayList<String> getArmorProf(){
        ArrayList<String> res = new ArrayList<>();
        res.add("Light");
        res.add("Medium");
        res.add("Shields");
        return res;
    }
}
