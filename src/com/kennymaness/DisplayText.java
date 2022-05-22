package com.kennymaness;

import com.kennymaness.character.Player;

public class DisplayText {
    public static final String linebreak =
        """
                                 \s
        --------------------------
                                 \s
        """;
    public static final String confirmRequest = "\n\tconfirm [y/n]\n\t> ";
    public static final String alertOfInvalidAnswer = "Invalid answer.";
    public static final String startingHitPointsPrompt = "You do a quick pat check and notice that " +
            "your current hit points are at a nice comfortable " + Player.MAX_HIT_POINTS + ".";
    public static final String racePrompt = "What is your race?\n\n" +
            "Dragonborn\n" +
            "Dwarf\n" +
            "Elf\n" +
            "Gnome\n" +
            "Half-Elf\n" +
            "Halfling\n" +
            "Half-Orc\n" +
            "Human\n" +
            "Tiefling";
    public static final String classPrompt = "What is your class?\n\n" +
            "Barbarian\n" +
            "Bard\n" +
            "Cleric\n" +
            "Druid\n" +
            "Fighter\n" +
            "Monk\n" +
            "Paladin\n" +
            "Ranger\n" +
            "Rogue\n" +
            "Sorcerer\n" +
            "Warlock\n" +
            "Wizard";
    public static final String namePrompt = "\"Well hello there, youngster! What's your name?\"";
    public static final String startingWeaponDefaultName = "Old Reliable";
    public static final String startingWeaponNicknamePrompt = "Yeah, you're pretty sure he did." +
            "\nIt's on the tip of your tongue... What was it again?";

    public static final String gameHeader = """
    
    
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
        """;
    public static final String gameFooter = """
                                        
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
                            
        """;
}