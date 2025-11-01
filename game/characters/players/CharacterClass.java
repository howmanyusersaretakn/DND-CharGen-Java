package game.characters.players;
import java.util.*;

public interface CharacterClass {
    String getClassName();
    String getPrimaryAbility();
    int getHitDieType();
    ArrayList<String> getSavingThrowProf();
    ArrayList<String> setSkillProf();
    ArrayList<String> getWeaponProf();
    ArrayList<String> getArmorProf();
}