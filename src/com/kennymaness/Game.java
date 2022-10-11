package com.kennymaness;

import com.kennymaness.character.Player;
import com.kennymaness.map.Direction;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    // declare variables
    static Boolean playerAnswer;
    static Boolean gameContinue = true;

    // this is the game!!
    public static void gameStart() throws InterruptedException {

        /* -------------------------- WELCOME SCREEN / CREATE PLAYER CHARACTER ------------------------- */

        Utilities.fastPrint(DisplayText.gameHeader);
        Player player = Player.createPlayer();


        /* --------------------------------------------------------------------------------------------- */
        /* --------------------------------------- GAMEPLAY START -------------------------------------- */
        /* --------------------------------------------------------------------------------------------- */


        /* -------------------------------- PATH DIVERGES BASED ON RACE -------------------------------- */

        // if the player is neither an elf nor a half-elf
        if (!Objects.equals(player.getCharacterRace(), "Elf") &&
                !Objects.equals(player.getCharacterRace(), "Half-Elf")) {
            // The town guard asks you a mysterious question, and you answer
            playerAnswer = Confirm.getYesOrNo(
                    "\"Tell me, " + player.getCharacterName() + "... Have you heard of the high elves?\"");
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
                    Utilities.slowPrint("You have a bump on your head, and decide to go back home.\n" +
                                        "That's enough adventure for one day.");
                } else {
                    Utilities.slowPrint(
                            "He raises his halberd to bonk you on the head. " + "But you've still got your " +
                            player.getWeaponPouch().get(0).getWeaponType() + " equipped!\n");
                    playerAnswer = Confirm.getYesOrNo("Parry him?");
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
//                        Utilities.slowPrint("You have a bump on your head, and decide to go back home.\n" +
//                                            "That's enough adventure for one day.");
                    }
                }
            }
        } else {
            Utilities.slowPrint(DisplayText.ifPlayerIsAnElfOrHalfElf);
        }

        /* -------------------------- END OF PATH THAT DIVERGES BASED ON RACE -------------------------- */
        /* -------------------------------- BEGINNING OF GAMEPLAY PROPER ------------------------------- */
        while (gameContinue) {
            Utilities.validateUserCommandInput(player, Confirm.getAnswer(DisplayText.generalPrompt), gameContinue);
        }

        /* ------------------------------------ END-OF-GAME SCREEN ------------------------------------- */
        /* --------------------------------------------------------------------------------------------- */

        Boolean playerRestart = Confirm.getYesOrNo("New game?");
        if (!playerRestart) {
            Utilities.fastPrint(DisplayText.gameFooter); // game end
        } else {
            // TODO - delete the player before the game restarts
            gameStart(); // game restart
        }
    }

}