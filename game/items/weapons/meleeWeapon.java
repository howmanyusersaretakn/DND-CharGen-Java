package game.items.weapons;

import java.util.*;
import game.items.Item;

public class meleeWeapon extends Item {
    final String damageType;
    final int damageDice; //we're assuming that any given weapon has a singular dice roll for damage
    final String category;
    final List<String> properties;
    private boolean masteryBool;
    private String masteryEffect;
    private List<String> effects;
    private boolean equipped;

    public meleeWeapon(String name, String damageType, int damageDice, int count, String category, String masteryEffect, String[] properties, String[] effects){
        super(name, "Weapon", count);
        this.damageType = damageType;
        this.damageDice = damageDice;
        this.category = category;
        this.properties = new ArrayList<>(Arrays.asList(properties));
        this.masteryBool = false;
        this.masteryEffect = masteryEffect;
        this.effects = new ArrayList<>(Arrays.asList(effects));
        this.equipped = false;
    }

    public void addEffect(String effect){
        this.effects.add(effect);
    }
    public void addMasteryEffect(){
        if(this.masteryBool == true) this.effects.add()
    }
    public void setEquipStatus(){
        this.equipped = (this.equipped == false);
    }
    public void setMasteryStatus(){
        this.masteryBool = (this.masteryBool == false);
    }

    public String 

    @Override 
    public String toString(){
        return String.format(
            "Name: %s | Category: %s | Damage: 1d%d %s | Properties: [%s] | Mastery Properties: %s[%s] | Applied Effects: %s\n", 
            super.getName(), this.category, this.damageDice, this.damageType, String.join(",", this.properties), this.masteryEffect, (this.masteryBool == true) ? "Applied" : "Not Applied", 
            String.join(",", this.effects)
        );
    }

    //testing
    // public static void main(String[] args) {
    //     meleeWeapon m = new meleeWeapon("Shortsword", "Slashing", 6, 1, "Simple", new String[]{"Light, Finesse"}, "Nick", new String[]{"Poisoned"});
    //     System.out.printf("Weapon info block:\n%s", m.toString());
    // }
}
