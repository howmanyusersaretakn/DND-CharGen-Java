package game.characters.players.classes;
import java.util.*;

public interface CharacterClass {
    String getClassName();
    ArrayList<String> getPrimaryAbility();
    int getHitDieType();
    ArrayList<String> getSavingThrowProf();
    ArrayList<String> setSkillProf();
    ArrayList<String> getWeaponProf();
    ArrayList<String> getArmorProf();
}