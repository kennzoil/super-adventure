package com.kennymaness;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    // declare variables
    static Scanner playerInput = new Scanner(System.in);
    static String playerPrompt;
    static Boolean playerAnswer;

    // this is the game!!
    public static void gameStart() throws InterruptedException {

        // Welcome Screen
        Utilities.fastPrint(DisplayText.gameHeader);

        /* -------------------------- CREATE PLAYER CHARACTER -------------------------- */
        Player player = Player.createPlayer();


        /* -------------------------- GAMEPLAY START -------------------------- */

        /* -------------------------- PATH DIVERGES BASED ON RACE -------------------------- */

        if (!Objects.equals(player.getCharacterRace(), "Elf") &&
                !Objects.equals(player.getCharacterRace(), "Half-Elf")) {
            // The town guard asks you a mysterious question
            Utilities.slowPrint(
                    "\"Tell me, " + player.getCharacterName() + "... Have you heard of the high elves?\"");

            // you answer
            playerAnswer = Confirm.yesOrNo();
            // depending on your answer, he will either heal you or try to bonk you
            if (playerAnswer) {
                Utilities.slowPrint("\"Oh excellent! Me too!\"\n" +
                        "The guard seems so excited that he heals you with a magic spell. Wow!");
                player.heal(2);
                Utilities.slowPrint(
                        "Looks like this adventure is already shaping up to be pretty super!");
            } else {
                Utilities.slowPrint(
                        "\"What? Seriously?? That makes me mad!! I'm gonna hit you on the head!!!!\"");
                if (!player.isArmed) {
                    Utilities.slowPrint("He raises his halberd to bonk you on the head.\n" +
                            "You try to parry, but you have nothing to parry it with!\nRemember how you stowed your " +
                            player.getWeaponPouch().get(0).getWeaponType() + "?? You fool!!");
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


        /* -------------------------- END OF GAME SCREEN -------------------------- */

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