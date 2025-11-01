package game.items;

public class Item {
    private String name;
    final String type;
    private int count;

    public Item(){
        this.name = "";
        this.type = "";
        this.count = 0;
    }

    public Item(String itemName, String itemType, int itemCount){
        this.name = itemName;
        this.type = itemType;
        this.count = itemCount;
    }

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
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

    @Override
    public String toString(){
        return String.format("Name: %s, Type: %s, Count: %d", this.name, this.type, this.count);
    }

}