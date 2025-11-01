package game.items.consumables;

import game.items.Item;

public class HealthPotion extends Item {
    final int healingAmount;

    public HealthPotion(String name, int healingAmount, int count){
        super(name, "Potion", count);
        this.healingAmount = healingAmount;
    }

    public int getHealAmount(){
        return this.healingAmount;
    }
}

