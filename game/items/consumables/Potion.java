package game.items.consumables;

import game.items.Item;

public class Potion extends Item {
    private int healingAmount;

    public Potion(String name, int healingAmount, int count){
        super(name, "Potion", count);
        this.healingAmount = healingAmount;
    }
}