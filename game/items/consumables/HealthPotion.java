package game.items.consumables;

import game.items.Item;

public class HealthPotion extends Item {
    final int healingAmount; //can become a negative effect if you set this to a -tive #

    public HealthPotion(String name, int healingAmount, int count){
        super(name, "Potion", count);
        this.healingAmount = healingAmount;
    }

    public int getHealAmount(){
        return this.healingAmount;
    }
}

