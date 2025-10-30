package game.characters.classes;
import java.util.*;

public class Monk implements characterClass {
    @Override public ArrayList<String> setSkillProf(){
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> classProficiencyArrayList = new ArrayList<>();
        classProficiencyArrayList.add("animal handling");
        classProficiencyArrayList.add("athletics");
        classProficiencyArrayList.add("intimidation");
        classProficiencyArrayList.add("nature");
        classProficiencyArrayList.add("perception");
        classProficiencyArrayList.add("survival");
        
        try (Scanner s = new Scanner(System.in)) {
            int i = 0;
            while(i < 2){
                System.out.printf("Pick a proficiency (%d of 2): %s\n", i+1, classProficiencyArrayList);
                String userInput = s.nextLine().toLowerCase();
                if(!classProficiencyArrayList.contains(userInput)){
                    System.out.println("Not a valid proficiency");
                }
                i++;
            }
        }
        return res;
    }
    
    @Override public String getClassName(){
        return "Barbarian";
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
