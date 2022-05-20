package com.kennymaness;

import java.util.ArrayList;


enum CharacterRace {
    DRAGONBORN("Dragonborn"),
    DWARF("Dwarf"),
    ELF("Elf"),
    GNOME("Gnome"),
    HALFELF("Half-Elf"),
    HALFLING("Halfling"),
    HALFORC("Half-Orc"),
    HUMAN("Human"),
    TIEFLING("Tiefling");

    public final String characterRace;

    CharacterRace(String race) {
        this.characterRace = race;
    }

    public String getCharacterRace() {return characterRace;}

    // returns the ones WITH hyphens
    public static ArrayList<String> allRaces() {
        ArrayList<String> races = new ArrayList<String >();
        for (CharacterRace r : CharacterRace.values()) {
            races.add(r.characterRace.toLowerCase());
        }
        return races;
    }

    // returns the ones WITHOUT hyphens
    public static ArrayList<String> allRaceValues() {
        ArrayList<String> races = new ArrayList<String >();
        for (CharacterRace r : CharacterRace.values()) {
            races.add(r.toString().toLowerCase());
        }
        return races;
    }

    public static String raceRegex() {
        StringBuilder raceRegexBuilder = new StringBuilder();
        raceRegexBuilder.append("/");
        for (CharacterRace r : CharacterRace.values()) {
            raceRegexBuilder.append("(").append(r.characterRace).append(")|");
        }
        raceRegexBuilder.append("ENDREGEX/g");
        return raceRegexBuilder.toString();
    }

}


enum CharacterClass {
    BARBARIAN("Barbarian"),
    BARD("Bard"),
    CLERIC("Cleric"),
    DRUID("Druid"),
    FIGHTER("Fighter"),
    MONK("Monk"),
    PALADIN("Paladin"),
    RANGER("Ranger"),
    ROGUE("Rogue"),
    SORCERER("Sorcerer"),
    WARLOCK("Warlock"),
    WIZARD("Wizard");

    public final String characterClass;
    CharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getCharacterClass() {return characterClass;}

    // returns the ones in blue, made into lowercase
    public static ArrayList<String> allClasses() {
        ArrayList<String> classes = new ArrayList<String>();
        for (CharacterClass c : CharacterClass.values()) {
            classes.add(c.toString().toLowerCase());
        }
        return classes;
    }

    // returns the ones in green, made into lowercase
    public static ArrayList<String> allClassValues() {
        ArrayList<String> classes = new ArrayList<String >();
        for (CharacterClass c : CharacterClass.values()) {
            classes.add(c.toString().toLowerCase());
        }
        return classes;
    }
}


public class Character {

    static final int maxHitPoints = 20;

    // declare the attributes!
    private String characterName = "";
    private int currentHitPoints;
    private ArrayList<Weapon> weaponPouch;
    private ArrayList<Item> itemPouch;
    private int[] abilityScores;
    CharacterClass characterClass;
    CharacterRace characterRace;
    Boolean isArmed;

    // constructor
    public Character(int currentHitPoints,
                     ArrayList<Weapon> weaponPouch,
                     ArrayList<Item> itemPouch,
                     int[] abilityScores,
                     CharacterClass characterClass,
                     CharacterRace characterRace,
                     Boolean isArmed) {

        this.currentHitPoints = currentHitPoints;
        this.weaponPouch = weaponPouch;
        this.itemPouch = itemPouch;
        this.abilityScores = abilityScores;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.isArmed = isArmed;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    // Use resetHitPoints when resetting a character, and damage & heal when a character's hitpoints change
    public void resetHitPoints(int currentHitPoints) {
        this.currentHitPoints = maxHitPoints;
    }
    public void damage(int damageTaken) throws InterruptedException {
        this.currentHitPoints = this.getCurrentHitPoints() - damageTaken;
        Utilities.slowPrint("You take " + damageTaken + " damage.");
        Utilities.slowPrint("HP: " + this.getCurrentHitPoints());
    }
    public void heal(int amountHealed) throws InterruptedException {
        this.currentHitPoints = this.getCurrentHitPoints() + amountHealed;
        Utilities.slowPrint("You heal " + amountHealed + " hitpoints.");
        Utilities.slowPrint("HP: " + this.getCurrentHitPoints());
    }

    public String getCharacterRace() {
        return characterRace.getCharacterRace();
    }

    public void setCharacterRace(CharacterRace characterRace) {
        this.characterRace = characterRace;
    }

    public String getCharacterClass() {
        return characterClass.getCharacterClass();
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public ArrayList<Weapon> getWeaponPouch() {
        return weaponPouch;
    }

    // assign an entire weapon pouch, equip a single weapon, and unequip a single weapon
    public void setWeaponPouch(ArrayList<Weapon> weaponPouch) {this.weaponPouch = weaponPouch;}
    public void addWeapon(Weapon weapon) {weaponPouch.add(weapon);}
    public void removeWeapon(Weapon weapon) {weaponPouch.remove(weapon);}

    public String getEquippedWeapon() {return weaponPouch.get(0).getWeaponName();}

    public int[] getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(int[] abilityScores) {
        this.abilityScores = abilityScores;
    }
}
