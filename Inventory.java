
import java.util.*;

class Item {
    private String name;
    private int count;

    public Item(){
        this.name = "";
        this.count = 0;
    }

    public Item(String itemName, int itemCount){
        this.name = itemName;
        this.count = itemCount;
    }

    public String getName(){
        return this.name;
    }
    public int getCount(){
        return this.count;
    }

    public void modifyName(String itemName){
        this.name = itemName;
    }
    public void modifyCount(int itemCount){
        this.count += itemCount;
    }

}

public class Inventory {
    final ArrayList<Item> invList = new ArrayList<>();
    
    public Inventory(){
        invList.add(null);
    }

    public int itemExists(String itemName){
        for(Item invItem : invList){
            if(invItem.getName().equals(itemName)) return invList.indexOf(invItem);
        }
        return -1;
    }

    public void removeItem(String itemName){
        int targetIndex = itemExists(itemName);
        invList.remove(targetIndex);
    }

    public void addItem(String itemName, int itemCount){
        int targetIndex = itemExists(itemName);
        if(targetIndex == -1 || invList == null) invList.add(new Item(itemName, itemCount));
        invList.get(targetIndex).modifyCount(itemCount);
    }

    public String printContents(){
        return String.format(invList.toString());
    }

    public void getItemInfo(String itemName){
        int targetIndex = itemExists(itemName);
        System.out.printf("%s", invList.get(targetIndex));
    }

}
