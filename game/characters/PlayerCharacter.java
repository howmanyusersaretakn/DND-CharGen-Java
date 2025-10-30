
import java.util.*;

public class playerCharacter {
    private String name;
    private String bkgrnd; //impacts certain stats
    private String species; //impacts certain stats and languages
    private int lvl;
    private int hp;
    private int xp;
    private int armorClass;
    private characterClass charClass;

    final Inventory inv;
    final ArrayList<String> languages;
    final ArrayList<String> skills;
    final ArrayList<String> traits;

    private int strScore;
    private int intlScore;
    private int dexScore;
    private int wisdScore;
    private int conScore;
    private int chariScore;

    public playerCharacter(){
        this.name = "";
        this.bkgrnd = "";
        this.species = "";
        this.lvl = 1;
        this.hp = 0;
        this.xp = 0;
        this.armorClass = 0;
        this.charClass = null;
        this.strScore = 0;
        this.intlScore = 0;
        this.dexScore = 0;
        this.wisdScore = 0;
        this.conScore = 0;
        this.chariScore = 0;
        this.inv = new Inventory();
        this.languages = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.traits = new ArrayList<>();
    }

    public int getLvl(){
        return this.lvl;
    }

    public int getHp(){
        return this.hp;
    }

    public int getXp(){
        return this.xp;
    }

    public int getArmorClass(){
        return this.armorClass;
    }

    public int getStat(String targetStat){
        int score = 0;
        switch(targetStat.toLowerCase()){
            case "str" -> score = this.strScore;
            case "dex" -> score = this.dexScore;
            case "con" -> score = this.conScore;
            case "intl" -> score = this.intlScore;
            case "wis" -> score = this.wisdScore;
            case "charis" -> score = this.chariScore;
        }
        return score;
    }

    public String getInv(){
        return String.format("-----%s's Inventory-----\n%s", this.name, this.inv.printContents());
    }

    public characterClass getCharClass(){
        return this.charClass;
    }

    public ArrayList<String> getSkills(){
        return this.skills;
    }

    public void printAllInfo(){
        System.out.printf("-----Basic info-----\nName: %s\nClass: %s\nBackground: %s\nSpecies: %s\nLevel: %d\nCurrent XP: %d\nArmor Class: %d", this.name, this.charClass.getClassName(), this.bkgrnd, this.species, this.lvl, this.xp, this.armorClass);
    }

    public void printAllStats(){
        System.out.printf("-----Stats-----\nStrength: %d\nDexterity\nConstitution: %d\nIntelligence: %d\nWisdom: %d\nCharisma: %d", this.strScore, this.dexScore, this.conScore, this.intlScore, this.wisdScore, this.chariScore);
    }

    public void setStat(String targetStat, int points){
        switch(targetStat.toLowerCase()){
            case "str" -> this.strScore += points;
            case "dex" -> this.dexScore += points;
            case "con" -> this.conScore += points;
            case "intl" -> this.intlScore += points;
            case "wis" -> this.wisdScore += points;
            case "charis" -> this.chariScore += points;
        }
    }

    public void speciesSelect(){
        Scanner s = new Scanner(System.in);
        System.out.println("Pick a species");
    }

    public void setClass(String className){
        switch(className.toLowerCase()){
            case "barbarian" -> this.charClass = new Barbarian();
            case "bard" -> this.charClass = new Bard();
            case "cleric" -> this.charClass = new Cleric();
            case "druid" -> this.charClass = new Druid();
            case "fighter" -> this.charClass = new Fighter();
            case "monk" -> this.charClass = new Monk();
            case "paladin" -> this.charClass = new Paladin();
            case "ranger" -> this.charClass = new Ranger();
            case "rogue" -> this.charClass = new Rogue();
            case "sorceror" -> this.charClass = new Sorceror();
            case "warlock" -> this.charClass = new Warlock();
            case "wizard" -> this.charClass = new Wizard();
            default -> System.out.println("invalid class");
        }
    }

    public void setNonChangingInfo(String name, String bkgrnd, String species){
        this.name = name;
        this.bkgrnd = bkgrnd;
        this.species = species;
    }

    public void setXp(int xp){
        this.xp += xp;
    }

    public void setLevel(int lvl){
        this.lvl = lvl;
    }

    public void setHP(int hp){
        this.hp += hp;
    }

    public void setAC(int ac){
        this.armorClass = ac;
    }

    public void addLanguages(String language){
        this.languages.add(language);
    }

    public void addSkills(String skillName){
        this.skills.add(skillName);
        
    }
}
