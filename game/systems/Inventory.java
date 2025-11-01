package game.systems;

import game.items.*;

import java.util.*;

public class Inventory {

    // Store any subclass of Item
    private final ArrayList<Item> invList = new ArrayList<>();

    public Inventory() {
        // No need to add null
    }

    // Check if an Item exists; returns index or -1
    public int itemExists(String itemName) {
        for (int i = 0; i < invList.size(); i++) {
            Item invItem = invList.get(i);
            if (invItem != null && invItem.getName().equals(itemName)) {
                return i;
            }
        }
        return -1;
    }

    // Add any Item (or subclass) to inventory
    public void addItem(Item Item) {
        int targetIndex = itemExists(Item.getName());
        if (targetIndex == -1) {
            invList.add(Item);
            System.out.printf("Added %d of %s.%n", Item.getCount(), Item.getName());
        } else {
            invList.get(targetIndex).modifyCount(Item.getCount());
            System.out.printf("Increased %s count by %d. New count: %d%n",
                    Item.getName(), Item.getCount(), invList.get(targetIndex).getCount());
        }
    }

    // Remove a number of items
    public void removeItem(String itemName, int countToRemove) {
        int targetIndex = itemExists(itemName);

        if (targetIndex == -1) {
            System.out.println("Item not found: " + itemName);
            return;
        }

        Item targetItem = invList.get(targetIndex);
        int newCount = targetItem.getCount() - countToRemove;

        if (newCount > 0) {
            targetItem.modifyCount(-countToRemove);
            System.out.printf("Removed %d of %s. Remaining: %d%n", countToRemove, itemName, targetItem.getCount());
        } else {
            invList.remove(targetIndex);
            System.out.printf("Removed %s completely (count reached 0).%n", itemName);
        }
    }

    // Print inventory contents
    public String printContents() {
        if (invList.isEmpty()) {
            return "Inventory is Empty";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Inventory contents:\n");
        for (Item Item : invList) {
            sb.append(String.format("- %s x%d%n", Item.getName(), Item.getCount()));
        }   

        return sb.toString();
    }

    // Get information on a specific Item
    public void getItemInfo(String itemName) {
        int targetIndex = itemExists(itemName);
        if (targetIndex == -1) {
            System.out.println("Item not found: " + itemName);
            return;
        }

        System.out.println(invList.get(targetIndex));
    }

    // // Testing section
    // public static void main(String[] args) {
    //     Inventory inv = new Inventory();

    //     // Example items (assume constructors exist)
    //     // Weapon(String name, int damage, int count)
    //     Weapon sword = new Weapon("Sword", 10, 2);
    //     Potion potion = new Potion("Potion", 5);

    //     inv.addItem(sword);
    //     inv.addItem(potion);

    //     inv.printContents();

    //     inv.removeItem("Potion", 2);
    //     inv.removeItem("Sword", 1);

    //     inv.printContents();

    //     inv.getItemInfo("Sword");
    // }
}
