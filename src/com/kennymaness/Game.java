package com.kennymaness;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    // declare variables
    static Scanner playerInput = new Scanner(System.in);
    static String playerPrompt;

    // this is the game!!
    public static void gameStart() throws InterruptedException {
        Utilities.fastPrint(DisplayText.gameHeader);


        /* STEP 1 - CREATE PLAYER CHARACTER */

        // make the player
        Player player = Player.createPlayer();
            Utilities.slowPrint("You check your weapon pouch and find the old " +
            player.getWeaponPouch().get(0).getWeaponType() +
            " your father bestowed upon you before you left on your Super Adventure.\n" +
            "You can't quite remember... Did he have a nickname for it...?");
        Boolean playerAnswer = Confirm.yesOrNo();



        /* STEP 2 - SET THE WEAPON NAME */

        // if the player does have a nickname for the weapon,
        if (playerAnswer) {
            // the player names the starting weapon
            playerPrompt = "Yeah, you're pretty sure he did.\nIt's on the tip of your tongue... What was it again?";
            Utilities.slowPrint(playerPrompt);
            String input =  playerInput.nextLine();
            player.getWeaponPouch().get(0).setWeaponName(Confirm.confirm(playerPrompt, input));
            Utilities.slowPrint("Right, of course! Its name is " + player.getWeaponPouch().get(0).getWeaponName() + "!");

        // otherwise, the default name is used
        } else {
            Utilities.slowPrint("You look at the old " +
                    player.getWeaponPouch().get(0).getWeaponType() + " for a little longer.\n" +
                    "\"Hmmm... Pretty sure '" + player.getWeaponPouch().get(0).weaponName +
                    "' was this thing's nickname,\" you think to yourself.\nYou shrug. " +
                    "No sense worrying about it anyway.\n" +
                    "You've got bigger fish to fry. Adventure fish, to be precise! Onward you go!");
        }

        Utilities.slowPrint(DisplayText.linebreak + "You've made your way to the town gate, and you see a guard.");



        // ----- STEP 3a - alert user they're still brandishing the weapon

        if (!player.getWeaponPouch().get(0).weaponName.equals("Old Reliable")) {
            Utilities.slowPrint("Oh shoot, you're still holding your " +
                    player.getWeaponPouch().get(0).getWeaponType() +
                    " (which for some reason is named " +
                    player.getWeaponPouch().get(0).getWeaponName() + ")! The guard's probably not gonna like that!");
        } else {
            Utilities.slowPrint("Oh crap, wait! You're still brandishing that " +
                    player.getWeaponPouch().get(0).getWeaponType() + "! The guard's probably not gonna like that!");
        }



        // ----- STEP 3b - ask if the user would like to stow it

        Utilities.slowPrint("Stow it?");
        playerAnswer = Confirm.yesOrNo();
        if (playerAnswer) {
            player.getWeaponPouch().get(0).setEquipped(false);
            Utilities.slowPrint("You quickly stow " + player.getWeaponPouch().get(0).weaponName +
                    " back into your pouch before the guard notices. Phew!\n" +
                    "He turns to see you approaching the town gate and hails you, unaware of what just happened.");
        } else {
            player.equipWeapon(player.getWeaponPouch().get(0));
        }



        /* STEP 4 - SET PLAYER NAME */

        // the guard greets the player and asks for their name
        playerPrompt = "\"Well hello there, youngster! What's your name?\"";
        Utilities.slowPrint(playerPrompt);
        player.setCharacterName(Confirm.confirm(playerPrompt, playerInput.nextLine()));
        // player.assignPlayerName(playerPrompt);
        Utilities.slowPrint("\"Ah, a fine name indeed. Well met, " + player.getCharacterName() + "!\"");



        /* -------------------- GAMEPLAY STARTS -------------------- */




        /* STEP 5 - PATH DIVERGES BASED ON RACE */

        if (!Objects.equals(player.getCharacterRace(), "Elf") &&
                !Objects.equals(player.getCharacterRace(), "Half-Elf")) {
            // The town guard asks you a mysterious question
            Utilities.slowPrint("\"Tell me, " + player.getCharacterName() +
                    "... Have you heard of the high elves?\"");

            // you answer
            playerAnswer = Confirm.yesOrNo();
            // depending on your answer, he will either heal you or try to bonk you
            if (playerAnswer) {
                Utilities.slowPrint("\"Oh excellent! Me too!\"");
                Utilities.slowPrint("The guard seems so excited that he heals you with a magic spell. Wow!");
                player.heal(2);
                Utilities.slowPrint("Looks like this adventure is already shaping up to be pretty super!");
            } else {
                Utilities.slowPrint("\"What? Seriously?? That makes me mad!! I'm gonna hit you on the head!!!!\"");
                if (!player.isArmed) {
                    Utilities.slowPrint("He raises his halberd to bonk you on the head.\n" +
                            "You try to parry, but you have nothing to parry it with!\n" +
                            "Remember how you stowed your " + player.getWeaponPouch().get(0).getWeaponType() + "?? You fool!!");
                    Utilities.slowPrint("He bonks you on the head with the handle of his halberd. Ouch!");
                    player.damage(2);
                    Utilities.slowPrint("'Super' Adventure? More like STUPID adventure. That hurt!");
                } else {
                    Utilities.slowPrint("He raises his halberd to bonk you on the head. " +
                            "But you've still got your " + player.getWeaponPouch().get(0).getWeaponType() + " equipped!\n" +
                            "Parry him?");
                    playerAnswer = Confirm.yesOrNo();
                    if (playerAnswer) {
                        Utilities.slowPrint("Shing!!!! Hyah!!\n" +
                                "Brandishing your trusty " + player.getWeaponPouch().get(0).getWeaponType() +
                                player.getEquippedWeapon() + ", you parry the halberd with ease, " +
                                "and even hit the guard with one of those Marvel quips.\n" +
                                "Nice job!");
                    } else {
                        Utilities.slowPrint("He bonks you on the head with the handle of his halberd. Ouch!");
                        player.damage(2);
                        Utilities.slowPrint("'Super' Adventure? More like STUPID adventure. That hurt!");
                    }
                }
            }
        } else {
            Utilities.slowPrint("The guard looks at your ears. It catches you off guard.\n" +
                    "\"Say... I was going to ask you if you've heard of the High Elves, " +
                    "but from the looks of those ears of yours, I'd say I've got my answer!");
            Utilities.slowPrint("You shrug and move on. Adventure!!");
        }





        String playerStats = "\n\n" +
                "Name: " + player.getCharacterName() + "\n" +
                "Race: " + player.getCharacterRace() + "\n" +
                "Class: " + player.getCharacterClass() + "\n" +
                "HP: " + player.getCurrentHitPoints() + "\n" +
                "Equipped: a " + player.getWeaponPouch().get(0).getWeaponType() + " named " + player.getEquippedWeapon() + "\n";
        Utilities.slowPrint(playerStats);
        Utilities.slowPrint("New game?");
        playerAnswer = Confirm.yesOrNo();
        if (!playerAnswer) {
            Utilities.fastPrint(DisplayText.gameFooter);
        } else {
            gameStart();
        }
    }

}