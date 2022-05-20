package com.kennymaness;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    // declare variables
    static Scanner playerInput = new Scanner(System.in);
    static String playerPrompt;
    private static final String linebreak =
            "                          \n" +
            "--------------------------\n" +
            "                          \n";

    // method for displaying text sequentially, to be used in place of System.out.println()
    public static void slowPrint(String string) throws InterruptedException {
        char[] chars = string.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
            Thread.sleep(2);
        }
        System.out.print("\n");
    }

    // alternate text-displaying method for displaying text faster
    public static void fastPrint(String string) throws InterruptedException {
        char[] chars = string.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
            Thread.sleep(1);
        }
        System.out.print("\n");
    }

    // this is the game!!
    public static void gameStart() throws InterruptedException {

        fastPrint("""


                                      ██████╗ ██╗   ██╗ ██████╗  ███████╗ ██████╗                          \s
                                     ██╔════╝ ██║   ██║ ██╔══██╗ ██╔════╝ ██╔══██╗                         \s
                                     ╚█████╗  ██║   ██║ ██████╔╝ █████╗   ██████╔╝                         \s
                                      ╚═══██╗ ██║   ██║ ██╔═══╝  ██╔══╝   ██╔══██╗                         \s
                                     ██████╔╝ ╚██████╔╝ ██║      ███████╗ ██║  ██║                         \s
                                     ╚═════╝   ╚═════╝  ╚═╝      ╚══════╝ ╚═╝  ╚═╝                         \s
                                                                                                           \s
                    █████╗  ██████╗  ██╗   ██╗ ███████╗ ███╗  ██╗ ████████╗ ██╗   ██╗ ██████╗  ███████╗ ██╗\s
                   ██╔══██╗ ██╔══██╗ ██║   ██║ ██╔════╝ ████╗ ██║ ╚══██╔══╝ ██║   ██║ ██╔══██╗ ██╔════╝ ██║\s
                   ███████║ ██║  ██║ ╚██╗ ██╔╝ █████╗   ██╔██╗██║    ██║    ██║   ██║ ██████╔╝ █████╗   ██║\s
                   ██╔══██║ ██║  ██║  ╚████╔╝  ██╔══╝   ██║╚████║    ██║    ██║   ██║ ██╔══██╗ ██╔══╝   ╚═╝\s
                   ██║  ██║ ██████╔╝   ╚██╔╝   ███████╗ ██║ ╚███║    ██║    ╚██████╔╝ ██║  ██║ ███████╗ ██╗\s
                   ╚═╝  ╚═╝ ╚═════╝     ╚═╝    ╚══════╝ ╚═╝  ╚══╝    ╚═╝     ╚═════╝  ╚═╝  ╚═╝ ╚══════╝ ╚═╝\s
                                                                                                           \s
                                                 by Kenny Maness                                           \s
                                                                                                           \s
                                                                                                           \s
                                           Welcome to Super Adventure!                                     \s
                              You've just set off on your very own Super Adventure.                        \s
                                     It's sure to be full of fun and whimsy!                               \s
                                                                                                           \s
                                                                                                           \s
                                                                                                           \s
                                                                                                           \s
                                                                                                           \s
                                           
                """);
        // make the player
        Player player = Player.createPlayer();
                    slowPrint("You check your weapon pouch and find the old " +
                    player.getWeaponPouch().get(0).getWeaponType() +
                    " your father bestowed upon you before you left on your Super Adventure.\n" +
                    "You can't quite remember... Did he have a nickname for it...?");
        Boolean playerAnswer = Confirm.yesOrNo();

        // if the player does have a nickname for the weapon,
        if (playerAnswer) {

            // the player names the starting weapon
            playerPrompt = "Yeah, you're pretty sure he did.\nIt's on the tip of your tongue... What was it again?";
            slowPrint(playerPrompt);
            String input =  playerInput.nextLine();
            player.getWeaponPouch().get(0).setWeaponName(Confirm.confirm(playerPrompt, input));
            slowPrint("Right, of course! Its name is " + player.getWeaponPouch().get(0).getWeaponName() + "!");

        // otherwise, the default name is used
        } else {
            slowPrint("You look at the old " +
                    player.getWeaponPouch().get(0).getWeaponType() + " for a little longer.\n" +
                    "\"Hmmm... Pretty sure '" + player.getWeaponPouch().get(0).weaponName +
                    "' was this thing's nickname,\" you think to yourself.\nYou shrug. " +
                    "No sense worrying about it anyway.\n" +
                    "You've got bigger fish to fry. Adventure fish, to be precise! Onward you go!");
        }

        slowPrint(linebreak + "You've made your way to the town gate, and you see a guard.");

        if (!player.getWeaponPouch().get(0).weaponName.equals("Old Reliable")) {
            slowPrint("Oh shoot, you're still holding your " +
                    player.getWeaponPouch().get(0).getWeaponType() +
                    " (which for some reason is named " +
                    player.getWeaponPouch().get(0).getWeaponName() + ")! The guard's probably not gonna like that!");
        } else {
            slowPrint("Oh crap, wait! You're still brandishing that " +
                    player.getWeaponPouch().get(0).getWeaponType() + "! The guard's probably not gonna like that!");
        }

        slowPrint("Stow it?");
        playerAnswer = Confirm.yesOrNo();
        if (playerAnswer) {
            player.getWeaponPouch().get(0).setEquipped(false);
            slowPrint("You quickly stow " + player.getWeaponPouch().get(0).weaponName +
                    " back into your pouch before the guard notices. Phew!\n" +
                    "He turns to see you approaching the town gate and hails you, unaware of what just happened.");
        } else {
            player.equipWeapon(player.getWeaponPouch().get(0));
        }

        // the guard greets the player and asks for their name
        playerPrompt = "\"Well hello there, youngster! What's your name?\"";
        slowPrint(playerPrompt);
        player.setCharacterName(Confirm.confirm(playerPrompt, playerInput.nextLine()));
//        player.assignPlayerName(playerPrompt);

        slowPrint("\"Ah, a fine name indeed. Well met, " + player.getCharacterName() + "!\"");

        if (!Objects.equals(player.getCharacterRace(), "Elf") &&
                !Objects.equals(player.getCharacterRace(), "Half-Elf")) {
            // The town guard asks you a mysterious question
            slowPrint("\"Tell me, " + player.getCharacterName() +
                    "... Have you heard of the high elves?\"");

            // you answer
            playerAnswer = Confirm.yesOrNo();
            // depending on your answer, he will either heal you or try to bonk you
            if (playerAnswer) {
                slowPrint("\"Oh excellent! Me too!\"");
                slowPrint("The guard seems so excited that he heals you with a magic spell. Wow!");
                player.heal(2);
                slowPrint("Looks like this adventure is already shaping up to be pretty super!");
            } else {
                slowPrint("\"What? Seriously?? That makes me mad!! I'm gonna hit you on the head!!!!\"");
                if (!player.isArmed) {
                    slowPrint("He raises his halberd to bonk you on the head.\n" +
                            "You try to parry, but you have nothing to parry it with!\n" +
                            "Remember how you stowed your " + player.getWeaponPouch().get(0).getWeaponType() + "?? You fool!!");
                    slowPrint("He bonks you on the head with the handle of his halberd. Ouch!");
                    player.damage(2);
                    slowPrint("'Super' Adventure? More like STUPID adventure. That hurt!");
                } else {
                    slowPrint("He raises his halberd to bonk you on the head. " +
                            "But you've still got your " + player.getWeaponPouch().get(0).getWeaponType() + " equipped!\n" +
                            "Parry him?");
                    playerAnswer = Confirm.yesOrNo();
                    if (playerAnswer) {
                        slowPrint("Shing!!!! Hyah!!\n" +
                                "Brandishing your trusty " + player.getWeaponPouch().get(0).getWeaponType() +
                                player.getEquippedWeapon() + ", you parry the halberd with ease, " +
                                "and even hit the guard with one of those Marvel quips.\n" +
                                "Nice job!");
                    } else {
                        slowPrint("He bonks you on the head with the handle of his halberd. Ouch!");
                        player.damage(2);
                        slowPrint("'Super' Adventure? More like STUPID adventure. That hurt!");
                    }

                }

            }
        } else {
            slowPrint("The guard looks at your ears. It catches you off guard.\n" +
                    "\"Say... I was going to ask you if you've heard of the High Elves, " +
                    "but from the looks of those ears of yours, I'd say I've got my answer!");
            slowPrint("You shrug and move on. Adventure!!");
        }

        String playerStats = "\n\n" +
                "Name: " + player.getCharacterName() + "\n" +
                "Race: " + player.getCharacterRace() + "\n" +
                "Class: " + player.getCharacterClass() + "\n" +
                "HP: " + player.getCurrentHitPoints() + "\n" +
                "Equipped: a " + player.getWeaponPouch().get(0).getWeaponType() + " named " + player.getEquippedWeapon() + "\n";
        slowPrint(playerStats);
        slowPrint("New game?");
        playerAnswer = Confirm.yesOrNo();
        if (!playerAnswer) {
            fastPrint("""
                                        
                    ████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗                 \s
                    ╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝                 \s
                       ██║   ███████║███████║██╔██╗ ██║█████╔╝                  \s
                       ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗                  \s
                       ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗                 \s
                       ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝                 \s
                                                                                \s
                         ██╗   ██╗ ██████╗ ██╗   ██╗                            \s
                         ╚██╗ ██╔╝██╔═══██╗██║   ██║                            \s
                          ╚████╔╝ ██║   ██║██║   ██║                            \s
                           ╚██╔╝  ██║   ██║██║   ██║                            \s
                            ██║   ╚██████╔╝╚██████╔╝                            \s
                            ╚═╝    ╚═════╝  ╚═════╝                             \s
                                                                                \s
                                   ███████╗ ██████╗ ██████╗                     \s
                                   ██╔════╝██╔═══██╗██╔══██╗                    \s
                                   █████╗  ██║   ██║██████╔╝                    \s
                                   ██╔══╝  ██║   ██║██╔══██╗                    \s
                                   ██║     ╚██████╔╝██║  ██║                    \s
                                   ╚═╝      ╚═════╝ ╚═╝  ╚═╝                    \s
                                                                                \s
                    ██████╗ ██╗      █████╗ ██╗   ██╗██╗███╗   ██╗ ██████╗ ██╗  \s
                    ██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██║████╗  ██║██╔════╝ ██║  \s
                    ██████╔╝██║     ███████║ ╚████╔╝ ██║██╔██╗ ██║██║  ███╗██║  \s
                    ██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██║██║╚██╗██║██║   ██║╚═╝  \s
                    ██║     ███████╗██║  ██║   ██║   ██║██║ ╚████║╚██████╔╝██╗  \s
                    ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  \s
                                                                                \s
                                        
                    """);
        } else {
            gameStart();
        }
    }

}