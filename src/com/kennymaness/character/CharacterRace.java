package com.kennymaness.character;

import java.util.ArrayList;

public enum CharacterRace {
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

    public String getCharacterRace() {
        return characterRace;
    }

    // returns the ones WITH hyphens
    public static ArrayList<String> allRaces() {
        ArrayList<String> races = new ArrayList<String>();
        for (CharacterRace r : CharacterRace.values()) {
            races.add(r.characterRace.toLowerCase());
        }
        return races;
    }

    // returns the ones WITHOUT hyphens
    public static ArrayList<String> allRaceValues() {
        ArrayList<String> races = new ArrayList<String>();
        for (CharacterRace r : CharacterRace.values()) {
            races.add(r.toString().toLowerCase());
        }
        return races;
    }

    // TODO - try and format this regex
//    public static String raceRegex() {
//        StringBuilder raceRegexBuilder = new StringBuilder();
//        raceRegexBuilder.append("/");
//        for (CharacterRace r : CharacterRace.values()) {
//            raceRegexBuilder.append("(").append(r.characterRace).append(")|");
//        }
//        raceRegexBuilder.append("ENDREGEX/g");
//        return raceRegexBuilder.toString();
//    }

}
