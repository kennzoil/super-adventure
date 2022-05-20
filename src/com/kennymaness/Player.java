package com.kennymaness;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character {
    public Player(int currentHitPoints,
                  ArrayList<Weapon> weaponPouch,
                  ArrayList<Item> itemPouch,
                  int[] abilityScores,
                  CharacterClass characterClass,
                  CharacterRace characterRace,
                  Boolean isArmed) {
        super(
                currentHitPoints,
                weaponPouch,
                itemPouch,
                abilityScores,
                characterClass,
                characterRace,
                isArmed
        );
    }

    public void addWeapon(Weapon weapon) {
        this.getWeaponPouch().add(weapon);
    }
    public void removeWeapon(Weapon weapon) {
        this.getWeaponPouch().remove(weapon);
    }

    public void equipWeapon(Weapon weapon) throws InterruptedException {

        // if the player isn't unarmed, equip the weapon and arm the player
        if (!this.isArmed) {
            weapon.setEquipped(true);
            this.isArmed = true;

        // but if the player is already armed,
        } else {
            // ask the player if they want to replace their currently equipped weapon with the new weapon
            Utilities.slowPrint(
                    "Unequip your " + getWeaponPouch().get(0).weaponName +
                    " and equip the " + weapon.weaponName + "?");
            Boolean playerAnswer = Confirm.yesOrNo();

            // if they answer yes,
            if (playerAnswer) {
                // unequip their currently equipped weapon, and...
                this.unequipWeapon(this.getWeaponPouch().get(0));
                // ... if the new weapon is already in their weapon pouch, simply equip it
                if (this.getWeaponPouch().contains(weapon)) {
                    weapon.setEquipped(true);
                // otherwise, add it to their weapon pouch and equip it.
                } else {
                    this.addWeapon(weapon);
                    weapon.setEquipped(true);
                }

            // and if they do not want to replace their currently held weapon with the new weapon,
            } else {
                // don't.
                Utilities.slowPrint("You decide to keep on hanging on to your trusty " + this.getWeaponPouch().get(0).getWeaponType() + " " +
                        this.getWeaponPouch().get(0).weaponName + ". It's probably better this way anyway.");
                weapon = this.getWeaponPouch().get(0);
            }
        }
        // confirm for the player that they are now holding the weapon that they are holding,
        // whether it be the one they've just equipped,
        // or if they've decided to continue holding onto their previously equipped weapon.
        Utilities.slowPrint("You're now wielding your " + this.getWeaponPouch().get(0).getWeaponType() + ", " + this.getWeaponPouch().get(0).weaponName + ". ");
    }

    public void unequipWeapon(Weapon weapon) {weapon.setEquipped(false);}


    public static Player createPlayer() throws InterruptedException {

        String playerPrompt;
        String playerInput;
        Scanner input = new Scanner(System.in);

        // assign starting hitpoints
        Utilities.slowPrint("You do a quick pat check and notice that " +
                "your current hit points are at a nice comfortable " +
                maxHitPoints + ".");

        // player selects race
        playerPrompt = "What is your race?\n\nDragonborn\nDwarf\nElf\nGnome\nHalf-Elf\nHalfling\nHalf-Orc\nHuman\nTiefling";
        Utilities.slowPrint(playerPrompt);
        playerInput =  input.nextLine();
        CharacterRace newPlayerRace = CharacterRace.valueOf(Confirm.confirmRace(playerPrompt, playerInput).toUpperCase());

        // player selects class
        playerPrompt = "What is your class?\n\nBarbarian\nBard\nCleric\nDruid\nFighter\nMonk\nPaladin\nRanger\nRogue\nSorcerer\nWarlock\nWizard";
        Utilities.slowPrint(playerPrompt);
        playerInput = input.nextLine();
        CharacterClass newPlayerClass = CharacterClass.valueOf(Confirm.confirmClass(playerPrompt, playerInput).toUpperCase());

        // assign default player attributes
        ArrayList<Weapon> newPlayerWeaponPouch = new ArrayList<>();
        ArrayList<Item> newPlayerItemPouch = new ArrayList<>();
        int[] newPlayerAbilityScores = new int[]{10, 10, 10, 10, 10, 10};

        Player newPlayer = new Player(
                maxHitPoints,
                newPlayerWeaponPouch,
                newPlayerItemPouch,
                newPlayerAbilityScores,
                newPlayerClass,
                newPlayerRace,
                false
        );

        // create starting weapon based on player's chosen class
        WeaponType weaponType;
        if (newPlayer.getCharacterClass().equals("Barbarian")) {
            weaponType = WeaponType.valueOf("BATTLEAXE");
        } else if (newPlayer.getCharacterClass().equals("Bard")) {
            weaponType = WeaponType.valueOf("RAPIER");
        } else if (newPlayer.getCharacterClass().equals("Cleric")) {
            weaponType = WeaponType.valueOf("MACE");
        } else if (newPlayer.getCharacterClass().equals("Druid")) {
            weaponType = WeaponType.valueOf("QUARTERSTAFF");
        } else if (newPlayer.getCharacterClass().equals("Fighter")) {
            weaponType = WeaponType.valueOf("LONGSWORD");
        } else if (newPlayer.getCharacterClass().equals("Monk")) {
            weaponType = WeaponType.valueOf("QUARTERSTAFF");
        } else if (newPlayer.getCharacterClass().equals("Paladin")) {
            weaponType = WeaponType.valueOf("MORNINGSTAR");
        } else if (newPlayer.getCharacterClass().equals("Ranger")) {
            weaponType = WeaponType.valueOf("BOW");
        } else if (newPlayer.getCharacterClass().equals("Rogue")) {
            weaponType = WeaponType.valueOf("DAGGER");
        } else if (newPlayer.getCharacterClass().equals("Sorcerer")) {
            weaponType = WeaponType.valueOf("QUARTERSTAFF");
        } else if (newPlayer.getCharacterClass().equals("Warlock")) {
            weaponType = WeaponType.valueOf("QUARTERSTAFF");
        } else if (newPlayer.getCharacterClass().equals("Wizard")) {
            weaponType = WeaponType.valueOf("QUARTERSTAFF");
        } else {
            weaponType = WeaponType.valueOf("DAGGER");
        }
        Weapon startingWeapon = new Weapon(
                "Old Reliable",
                2,
                2,
                weaponType,
                false,
                false
        );

        newPlayer.addWeapon(startingWeapon);

        return newPlayer;
    }

}