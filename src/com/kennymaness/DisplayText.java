package com.kennymaness;

import com.kennymaness.character.Player;

public class DisplayText {
    public static final String linebreak =
        """
                                 \s
        -------------------------
                                 
        """;
    public static final String generalPrompt = "What would you like to do?";
    public static final String alertOfInvalidAnswer = "Invalid answer.";
    public static final String startingHitPointsPrompt = "You do a quick pat check and notice that " +
            "your current hit points are at a nice comfortable " + Player.MAX_HIT_POINTS + ".";
    public static final String racePrompt =
            """

                    --- select race ---
                    Dragonborn
                    Dwarf
                    Elf
                    Gnome
                    Half-Elf
                    Halfling
                    Half-Orc
                    Human
                    Tiefling
                    """;
    public static final String classPrompt =
            """

                    --- select class ---
                    Barbarian
                    Bard
                    Cleric
                    Druid
                    Fighter
                    Monk
                    Paladin
                    Ranger
                    Rogue
                    Sorcerer
                    Warlock
                    Wizard
                    """;
    public static final String namePrompt = "\"Well hello there, youngster! What's your name?\"";
    public static final String startingWeaponDefaultName = "Old Reliable";
    public static final String startingWeaponNicknamePrompt = "It's on the tip of your tongue... What was it again?";
    public static final String ifPlayerIsAnElfOrHalfElf =
                    """
                    The guard looks at your ears. It catches you off guard.
                    "Say... I was going to ask you if you've heard of the High Elves, but from the looks of those ears of yours, I'd say I've got my answer!
                    You think about it for a second, then shrug and move on.
                    Adventure!!
                    """;
    public static final String wait = "You figure you can take your time with it, so you decide to wait a bit.\n" +
            "You start to get a little bored with waiting after a little while. You're itching for adventure!";
    public static final String help = "Here are the things you can do!\n" +
            "look\n" +
            "inv\n" +
            "stats\n" +
            "help\n" +
            "quit";

    /* ----------------------------------- LOCATION DESCRIPTIONS ----------------------------------- */
    /* --------------------------------------------------------------------------------------------- */

    public static final String townGateDescription =
            "The gate leading into town. There is a guard with a halberd posted just outside.";

    public static final String stablesDescription =
            "The stables just outside the city wall. There are horses.";

    public static final String mainStreetDescription =
            "The bit of Main Street just inside the town wall. To the west is the pub, and the inn is to your east.";

    public static final String gatehouseDescription =
            "The gatehouse just outside the city gates, where the guards eat their snacks.";

    public static final String pubDescription =
            "The Pub. There are people drinking here, and it smells.";

    public static final String sewerDescription =
            "The sewer. Smells almost as bad as the pub.";

    public static final String innDescription =
            "The local Inn. Very welcoming.";

    public static final String marketDescription =
            "The market square. People are bustling and whatnot.";

    public static final String potionShopDescription =
            "The potion shop. Owned and run by the local Potion Seller, who sells only the strongest potions.";

    public static final String weaponStoreDescription =
            "The weapon store. Buy a weapon, why don'tcha!";

    /* -------------------------------- END OF LOCATION DESCRIPTIONS ------------------------------- */
    /* --------------------------------------------------------------------------------------------- */

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
                                    (c) 2022 Kenny Maness                                          \s
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