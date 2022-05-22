package com.kennymaness.character;

import java.util.ArrayList;

public enum CharacterClass {
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

    public String getCharacterClass() {
        return this.characterClass;
    }

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
        ArrayList<String> classes = new ArrayList<String>();
        for (CharacterClass c : CharacterClass.values()) {
            classes.add(c.toString().toLowerCase());
        }
        return classes;
    }
}
