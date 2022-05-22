package com.kennymaness.character;

import com.kennymaness.Item;
import com.kennymaness.Utilities;
import com.kennymaness.Weapon;

import java.util.ArrayList;


public class Character {

    static final int MAX_HIT_POINTS = 20;

    // declare the attributes!
    private String characterName = "";
    private int currentHitPoints;
    private ArrayList<Weapon> weaponPouch;
    private ArrayList<Item> itemPouch;
    private int[] abilityScores;
    CharacterClass characterClass;
    CharacterRace characterRace;
    public Boolean isArmed;

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
        this.currentHitPoints = MAX_HIT_POINTS;
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

    public ArrayList<Weapon> getWeaponPouch() {return weaponPouch;}

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
