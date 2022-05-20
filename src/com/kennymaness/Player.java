package com.kennymaness;

import java.util.ArrayList;
import java.util.Scanner;

import static com.kennymaness.Game.slowPrint;

public class Player extends Character {
    public Player(int currentHitPoints,
                  CharacterRace characterRace,
                  CharacterClass characterClass,
                  String characterName,
                  ArrayList<Weapon> weaponPouch,
                  Boolean isArmed,
                  int[] abilityScores) {
        super(
                currentHitPoints,
                characterRace,
                characterClass,
                characterName,
                weaponPouch,
                isArmed,
                abilityScores
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
            slowPrint(
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
                slowPrint("You decide to keep on hanging on to your trusty " + this.getWeaponPouch().get(0).getWeaponType() + " " +
                        this.getWeaponPouch().get(0).weaponName + ". It's probably better this way anyway.");
                weapon = this.getWeaponPouch().get(0);
            }
        }
        // confirm for the player that they are now holding the weapon that they are holding,
        // whether it be the one they've just equipped,
        // or if they've decided to continue holding onto their previously equipped weapon.
        slowPrint("You're now wielding your " + this.getWeaponPouch().get(0).getWeaponType() + ", " + this.getWeaponPouch().get(0).weaponName + ". ");
    }

    public void unequipWeapon(Weapon weapon) {weapon.setEquipped(false);}


    public static Player createPlayer() throws InterruptedException {

        String playerPrompt;
        String playerInput;
        Scanner input = new Scanner(System.in);

        // assign starting hitpoints
        slowPrint("You do a quick pat check and notice that " +
                "your current hit points are at a nice comfortable " +
                maxHitPoints + ".");

        // player selects race
        playerPrompt = "What is your race?\n\nDragonborn\nDwarf\nElf\nGnome\nHalf-Elf\nHalfling\nHalf-Orc\nHuman\nTiefling";
        slowPrint(playerPrompt);
        playerInput =  input.nextLine();
        CharacterRace newPlayerRace = CharacterRace.valueOf(Confirm.confirmRace(playerPrompt, playerInput).toUpperCase());

        // player selects class
        playerPrompt = "What is your class?\n\nBarbarian\nBard\nCleric\nDruid\nFighter\nMonk\nPaladin\nRanger\nRogue\nSorcerer\nWarlock\nWizard";
        slowPrint(playerPrompt);
        playerInput = input.nextLine();
        CharacterClass newPlayerClass = CharacterClass.valueOf(Confirm.confirmClass(playerPrompt, playerInput).toUpperCase());

        // assign default player attributes
        String newPlayerName = "";
        ArrayList<Weapon> newPlayerWeaponPouch = new ArrayList<Weapon>();
        Boolean isNewPlayerArmed = false;
        int[] newPlayerAbilityScores = new int[]{10, 10, 10, 10, 10, 10};

        Player newPlayer = new Player(maxHitPoints,
                newPlayerRace,
                newPlayerClass,
                newPlayerName,
                newPlayerWeaponPouch,
                isNewPlayerArmed,
                newPlayerAbilityScores);

        // create starting weapon based on player's chosen class
        Weapon.WeaponType weaponType;
        if (newPlayer.getCharacterClass().equals("Barbarian")) {
            weaponType = Weapon.WeaponType.valueOf("BATTLEAXE");
        } else if (newPlayer.getCharacterClass().equals("Bard")) {
            weaponType = Weapon.WeaponType.valueOf("RAPIER");
        } else if (newPlayer.getCharacterClass().equals("Cleric")) {
            weaponType = Weapon.WeaponType.valueOf("MACE");
        } else if (newPlayer.getCharacterClass().equals("Druid")) {
            weaponType = Weapon.WeaponType.valueOf("QUARTERSTAFF");
        } else if (newPlayer.getCharacterClass().equals("Fighter")) {
            weaponType = Weapon.WeaponType.valueOf("LONGSWORD");
        } else if (newPlayer.getCharacterClass().equals("Monk")) {
            weaponType = Weapon.WeaponType.valueOf("QUARTERSTAFF");
        } else if (newPlayer.getCharacterClass().equals("Paladin")) {
            weaponType = Weapon.WeaponType.valueOf("MORNINGSTAR");
        } else if (newPlayer.getCharacterClass().equals("Ranger")) {
            weaponType = Weapon.WeaponType.valueOf("BOW");
        } else if (newPlayer.getCharacterClass().equals("Rogue")) {
            weaponType = Weapon.WeaponType.valueOf("DAGGER");
        } else if (newPlayer.getCharacterClass().equals("Sorcerer")) {
            weaponType = Weapon.WeaponType.valueOf("QUARTERSTAFF");
        } else if (newPlayer.getCharacterClass().equals("Warlock")) {
            weaponType = Weapon.WeaponType.valueOf("QUARTERSTAFF");
        } else if (newPlayer.getCharacterClass().equals("Wizard")) {
            weaponType = Weapon.WeaponType.valueOf("QUARTERSTAFF");
        } else {
            weaponType = Weapon.WeaponType.valueOf("DAGGER");
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
