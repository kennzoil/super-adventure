package com.kennymaness;

import com.kennymaness.character.CharacterClass;
import com.kennymaness.character.Player;
import com.kennymaness.weapon.Weapon;
import com.kennymaness.weapon.WeaponType;

import java.util.*;

public class Utilities {

    private static final List<String> singleCommands = List.of(
            "look",
            "inv",
            "stats",
            "wait",
            "help",
            "quit"
    );

    private static final List<String> actionCommands = List.of(
            "go",
            "look",
            "take",
            "drop",
            "talk"
    );

//    private static final List<String> goCommands = List.of(
//            "go",
//            "walk",
//            "move",
//            "run",
//            "progress",
//            "travel",
//            "approach",
//            "journey",
//            "mosey",
//            "abscond",
//            "escape",
//            "pass",
//            "flee",
//            "retire");

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
        String startingWeaponName;
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
            Utilities.slowPrint("Yeah, you're pretty sure he did.");
            startingWeaponName = (Confirm.getAnswer(
                    DisplayText.startingWeaponNicknamePrompt));
            Utilities.slowPrint("Right, of course! Its name is " +
                                startingWeaponName + "!");
        } else {
            Utilities.slowPrint("You look at the old " +
                                startingWeaponType.getWeaponType() + " for a little longer.\n" +
                                "\"Hmmm... Pretty sure '" + DisplayText.startingWeaponDefaultName +
                                "' was this thing's nickname,\" you think to yourself.\n" +
                                "You shrug. \"No sense worrying about it anyway.\"\n" +
                                "You've got bigger fish to fry. Adventure fish, to be precise!\nOnward you go!");
            startingWeaponName = DisplayText.startingWeaponDefaultName;
        }

        return new Weapon(
                startingWeaponName,
                startingWeaponType,
                false,
                false); }

    /* --------------------------------------------------------------------------------------------- */
    /* -------------------------------------- GAMEPLAY METHODS ------------------------------------- */
    /* --------------------------------------------------------------------------------------------- */

    // This private method, called wordListerizer, receives user input and
    // turns it into an ArrayList of Strings.
    private static List<String> wordListerizer(String input) {
        String splitters = "[ \t,.:;?!\"']+";
        String[] words = input.split(splitters);
        return new ArrayList<>(Arrays.asList(words));
    }

    // This method receives a user command input, uses wordListerizer to make it a List of Strings,
    // then determines if it should be sent to the single-word command processor method
    // or the action command processor method.
    // If the user's input command cannot be sent to either method, it asks for input again.
    public static void validateUserCommandInput(Player player, String userCommand, Boolean gameContinue) throws InterruptedException {

        // use wordListerizer to turn the input into a parsable List of Strings,
        // and put it in a new List called commandInput
        List<String> commandInput = wordListerizer(userCommand.toLowerCase());

        if (commandInput.size() == 1) {
            if (singleCommands.contains(commandInput)) {
                processSingleCommand(player, userCommand, gameContinue);
            } else {
            }
        } else if (commandInput.size() == 2) {
            if (actionCommands.contains(commandInput.get(0))){
            }
        } else {
        }

    }

    private static void processSingleCommand(Player player, String command, Boolean gameContinue) throws InterruptedException {

        String playerStats = "\n\n" +
                "Name: " + player.getCharacterName() + "\n" +
                "Race: " + player.getCharacterRace() + "\n" +
                "Class: " + player.getCharacterClass() + "\n" +
                "HP: " + player.getCurrentHitPoints() + "\n" +
                "Equipped: a " + player.getWeaponPouch().get(0).getWeaponType() +
                " named " + player.getEquippedWeapon() + "\n";

        switch (command) {
            case "look" -> slowPrint(player.getCurrentLocation().getDescription());
            case "inv" -> slowPrint(player.getWeaponPouch().toString());
            case "stats" -> slowPrint(playerStats);
            case "wait" -> slowPrint(DisplayText.wait);
            case "help" -> slowPrint(DisplayText.help);
            case "quit" -> {
                Boolean quitConfirm = Confirm.getYesOrNo("Quit game?");
                if (quitConfirm) {
                    Boolean areYouSure = Confirm.getYesOrNo("Are... are you sure...?");
                    if (areYouSure) {gameContinue = false;}
                    else {slowPrint("""
                                    Oh thank goodness, I thought you were going to leave me.
                                    Whew!
                                    Okay!
                                    Anyway,
                                    """);}
                } else {slowPrint(player.getCurrentLocation().getDescription());}
            }
        }
    }


}