package game.characters.players;

import game.characters.players.classes.*;
import game.systems.*;
import java.util.*;

public class PlayerCharacter {
    private String name;
    private String bkgrnd; //impacts certain stats
    private String species; //impacts certain stats and languages
    private int lvl;
    private int xp;
    private int hp;
    private String size;
    private CharacterClass charClass;

    final Inventory inv;
    final ArrayList<String> languages;
    final ArrayList<> traits;

    private int strScore;
    private int intlScore;
    private int dexScore;
    private int wisdScore;
    private int conScore;
    private int chariScore;

    public PlayerCharacter(){
        this.name = "";
        this.bkgrnd = "";
        this.species = "";
        this.lvl = 1;
        this.xp = 0;
        this.hp = 0;
        this.size = "";
        this.charClass = null;
        this.strScore = 0;
        this.intlScore = 0;
        this.dexScore = 0;
        this.wisdScore = 0;
        this.conScore = 0;
        this.chariScore = 0;
        this.inv = new Inventory();
        this.languages = new ArrayList<>();
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

    public CharacterClass getCharClass(){
        return this.charClass;
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

    public void setClass(int classChoice, int speciesChoice, int characterBackground){
        switch(classChoice){
            case 1 -> this.charClass = new Barbarian();
            case 2 -> this.charClass = new Bard();
            case 3 -> this.charClass = new Cleric();
            case 4 -> this.charClass = new Druid();
            case 5 -> this.charClass = new Fighter();
            case 6 -> this.charClass = new Monk();
            case 7 -> this.charClass = new Paladin();
            case 8 -> this.charClass = new Ranger();
            case 9 -> this.charClass = new Rogue();
            case 10 -> this.charClass = new Sorceror();
            case 11 -> this.charClass = new Warlock();
            case 12 -> this.charClass = new Wizard();
            default -> System.out.println("invalid class");
        }
        switch(speciesChoice){
            case 1:
                this.species = "Aasmir";
                this.traits.add("")
        }
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
}
