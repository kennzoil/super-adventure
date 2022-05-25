package com.kennymaness;

import com.kennymaness.character.Player;

public class DisplayText {
    public static final String linebreak =
        """
                                 \s
        --------------------------
                                 \s
        """;
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

    /* ----------------------------------- LOCATION DESCRIPTIONS ----------------------------------- */
    /* --------------------------------------------------------------------------------------------- */

    public static final String townGateDescription =
            "The gate leading into town. There is a guard with a halberd posted just outside.\n";

    public static final String stablesDescription =
            "The stables just outside the city wall. There are horses.\n";

    public static final String gatehouseDescription =
            "The gatehouse just outside the city gates, where the guards eat their snacks.\n";

    public static final String mainStreetDescription =
            "The bit of Main Street just inside the town wall. To the west is the pub, and the inn is to your east.\n";

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