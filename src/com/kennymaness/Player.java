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
            Boolean playerAnswer = Confirm.getYesOrNo(
                    "Unequip your " + getWeaponPouch().get(0).weaponName +
                    " and equip the " + weapon.weaponName + "?"
            );

            // if they answer yes,
            if (playerAnswer) {
                // unequip their currently equipped weapon, and...
                this.getWeaponPouch().get(0).setEquipped(false);
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
                Utilities.slowPrint("You decide to keep on hanging on to your trusty " +
                        this.getWeaponPouch().get(0).getWeaponType() + " " +
                        this.getWeaponPouch().get(0).weaponName + ".\n" +
                        "It's probably better this way anyway.");
                weapon = this.getWeaponPouch().get(0);
            }
        }
        // confirm for the player that they are now holding the weapon that they are holding,
        // whether it be the one they've just equipped,
        // or if they've decided to continue holding onto their previously equipped weapon.
        Utilities.slowPrint(
                "You're now wielding your " +
                        this.getWeaponPouch().get(0).getWeaponType() + ", " +
                        this.getWeaponPouch().get(0).weaponName + ". ");
    }

    public static Player createPlayer() throws InterruptedException {

        String playerPrompt;
        String playerInput;
        Scanner input = new Scanner(System.in);

        // assign starting hitpoints
        Utilities.slowPrint(DisplayText.startingHitPointsPrompt);

        // player selects race
        Utilities.slowPrint(DisplayText.racePrompt);
        playerInput = input.nextLine();
        CharacterRace newPlayerRace = CharacterRace.valueOf(
                Confirm.confirmRace(DisplayText.racePrompt, playerInput).toUpperCase());

        // player selects class
        Utilities.slowPrint(DisplayText.classPrompt);
        playerInput = input.nextLine();
        CharacterClass newPlayerClass = CharacterClass.valueOf(
                Confirm.confirmClass(DisplayText.classPrompt, playerInput).toUpperCase());

        // assign default player attributes
        ArrayList<Weapon> newPlayerWeaponPouch = new ArrayList<>();
        ArrayList<Item> newPlayerItemPouch = new ArrayList<>();
        int[] newPlayerAbilityScores = new int[]{10, 10, 10, 10, 10, 10};

        Player newPlayer = new Player(
                MAX_HIT_POINTS,
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
            weaponType = WeaponType.BATTLEAXE;
        } else if (newPlayer.getCharacterClass().equals("Bard")) {
            weaponType = WeaponType.RAPIER;
        } else if (newPlayer.getCharacterClass().equals("Cleric")) {
            weaponType = WeaponType.MACE;
        } else if (newPlayer.getCharacterClass().equals("Druid")) {
            weaponType = WeaponType.QUARTERSTAFF;
        } else if (newPlayer.getCharacterClass().equals("Fighter")) {
            weaponType = WeaponType.LONGSWORD;
        } else if (newPlayer.getCharacterClass().equals("Monk")) {
            weaponType = WeaponType.QUARTERSTAFF;
        } else if (newPlayer.getCharacterClass().equals("Paladin")) {
            weaponType = WeaponType.MORNINGSTAR;
        } else if (newPlayer.getCharacterClass().equals("Ranger")) {
            weaponType = WeaponType.BOW;
        } else if (newPlayer.getCharacterClass().equals("Rogue")) {
            weaponType = WeaponType.DAGGER;
        } else if (newPlayer.getCharacterClass().equals("Sorcerer")) {
            weaponType = WeaponType.QUARTERSTAFF;
        } else if (newPlayer.getCharacterClass().equals("Warlock")) {
            weaponType = WeaponType.QUARTERSTAFF;
        } else if (newPlayer.getCharacterClass().equals("Wizard")) {
            weaponType = WeaponType.QUARTERSTAFF;
        } else {
            weaponType = WeaponType.DAGGER;
        }
        Weapon startingWeapon = new Weapon(
                DisplayText.startingWeaponDefaultName,
                2,
                2,
                weaponType,
                false,
                false
        );

        Utilities.slowPrint(
                "You check your weapon pouch and find the old " +
                        startingWeapon.getWeaponType() +
                        " your father bestowed upon you before you left on your Super Adventure.");
        Boolean newPlayerAnswer = Confirm.getYesOrNo(
                "You can't quite remember... Did he have a nickname for it...?");

        // if the player does have a nickname for the weapon,
        if (newPlayerAnswer) {
            // the player names the starting weapon
            Utilities.slowPrint(DisplayText.startingWeaponNicknamePrompt);
            playerInput = input.nextLine();
            startingWeapon.setWeaponName(Confirm.confirm(
                    DisplayText.startingWeaponNicknamePrompt, playerInput));
            Utilities.slowPrint("Right, of course! Its name is " +
                    startingWeapon.getWeaponName() + "!");

        // otherwise, the default name is used
        } else {
            Utilities.slowPrint("You look at the old " +
                    startingWeapon.getWeaponType() + " for a little longer.\n" +
                    "\"Hmmm... Pretty sure '" + startingWeapon.weaponName +
                    "' was this thing's nickname,\" you think to yourself.\n" +
                    "You shrug. No sense worrying about it anyway.\n" +
                    "You've got bigger fish to fry. Adventure fish, to be precise!\nOnward you go!\n" +
                    DisplayText.linebreak +
                    "You've made your way to the town gate, and you see a guard.");
        }

        // add the weapon to the player's weapon pouch
        newPlayer.addWeapon(startingWeapon);

        // if the starting weapon has a nickname, print this
        if (!startingWeapon.weaponName.equals(DisplayText.startingWeaponDefaultName)) {
            Utilities.slowPrint("Oh shoot, you're still holding your " +
                    startingWeapon.getWeaponType() +
                    " (which for some reason is named " + startingWeapon.getWeaponName() + ")! " +
                    "The guard's probably not gonna like that!");
        // otherwise, print this
        } else {
            Utilities.slowPrint("Oh crap, wait! You're still brandishing that old " +
                    startingWeapon.getWeaponType() + "! The guard's probably not gonna like that!");
        }

        // ----- STEP 3b - ask if the user would like to unequip it

        Boolean playerAnswer = Confirm.getYesOrNo("Unequip your " + newPlayer.getWeaponPouch().get(0) + "?");
        if (playerAnswer) {
            startingWeapon.setEquipped(false);
            Utilities.slowPrint("You quickly stow " + newPlayer.getWeaponPouch().get(0).weaponName +
                    " back into your pouch before the guard notices. Phew!\n" +
                    "He turns to see you approaching the town gate and hails you, unaware of what just happened.");
        } else {
            newPlayer.equipWeapon(startingWeapon);
        }

        // the guard greets the player and asks for their name
        newPlayer.setCharacterName(Confirm.confirm(DisplayText.namePrompt, input.nextLine()));

        // player.assignPlayerName(playerPrompt);
        Utilities.slowPrint("\"Ah, a fine name indeed. Well met, " + newPlayer.getCharacterName() + "!\"");

        return newPlayer;
    }
}