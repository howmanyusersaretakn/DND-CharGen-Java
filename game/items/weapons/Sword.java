package game.items.weapons;

import game.items.Item;

public class Sword extends Item {
    private String damageType;
    private int damageDice;

    public Sword(String name, String damageType, int damageDice, int count){
        super(name, "Weapon", count);
        this.damageType = damageType;
        this.damageDice = damageDice;
    }

}
