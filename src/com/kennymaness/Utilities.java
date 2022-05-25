package com.kennymaness;

import com.kennymaness.character.CharacterClass;
import com.kennymaness.weapon.Weapon;
import com.kennymaness.weapon.WeaponType;

import java.util.Random;

public class Utilities {

    /* ------------------------------ SLOW PRINT & FAST PRINT METHODS ------------------------------ */
    /* ----methods for displaying text sequentially, to be used in place of System.out.println()---- */
    /* --------------------------------------------------------------------------------------------- */
    public static void slowPrint(String text) throws InterruptedException {
        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
            Thread.sleep(15);
        }
        System.out.print("\n");
    }
    public static void fastPrint(String text) throws InterruptedException {
        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
            Thread.sleep(1);
        }
        System.out.print("\n");
    }
    // alternate version of slowPrint() used exclusively for displaying the '> ' before a text input
    public static void inputCaret() {
        System.out.print("> ");
    }
    public static void yesNoCaret() {
        System.out.print("confirm [y/n] > ");
    }


    /* ------------------ DICE ROLLING METHOD ------------------ */
    public static int rollDice(int numberOfDice, int typeOfDie) {
        Random roll = new Random();
        int dieRoll = 0;
        for (int i=1; i<numberOfDice+1; numberOfDice++) {
            dieRoll += (roll.nextInt(typeOfDie));
        }
        return dieRoll;
    }

    /* ------------------------------- CREATE STARTING WEAPON METHOD ------------------------------- */
    /* ------------------This method is called in the Player.createPlayer() method------------------ */
    /* --------------------------------------------------------------------------------------------- */
    public static Weapon createStartingWeapon(CharacterClass newPlayerClass) throws InterruptedException {

        WeaponType startingWeaponType = null;
        String startingWeaponName = null;
        switch (newPlayerClass) {
            case BARBARIAN -> startingWeaponType = WeaponType.BATTLEAXE;
            case BARD -> startingWeaponType = WeaponType.RAPIER;
            case CLERIC -> startingWeaponType = WeaponType.MACE;
            case DRUID, MONK, SORCERER, WARLOCK, WIZARD
                    -> startingWeaponType = WeaponType.QUARTERSTAFF;
            case FIGHTER -> startingWeaponType = WeaponType.LONGSWORD;
            case PALADIN -> startingWeaponType = WeaponType.MORNINGSTAR;
            case RANGER -> startingWeaponType = WeaponType.BOW;
            case ROGUE -> startingWeaponType = WeaponType.DAGGER;
        }

        Utilities.slowPrint(
                "You check your weapon pouch and find the old " + startingWeaponType.getWeaponType() +
                " your father bestowed upon you before you left on your Super Adventure.");
        Boolean newPlayerAnswer = Confirm.getYesOrNo(
                "You can't quite remember... Did he have a nickname for it...?");
        if (newPlayerAnswer) {
            startingWeaponName = (Confirm.getAnswer(
                    DisplayText.startingWeaponNicknamePrompt));
            Utilities.slowPrint("Right, of course! Its name is " +
                                startingWeaponName + "!");
        } else {
            Utilities.slowPrint("You look at the old " +
                                startingWeaponType.getWeaponType() + " for a little longer.\n" +
                                "\"Hmmm... Pretty sure '" + DisplayText.startingWeaponDefaultName +
                                "' was this thing's nickname,\" you think to yourself.\n" +
                                "You shrug. \"No sense worrying about it anyway.\"" +
                                "You've got bigger fish to fry. Adventure fish, to be precise!\nOnward you go!");
        }

        return new Weapon(
                startingWeaponName,
                startingWeaponType,
                false,
                false); }
    }
