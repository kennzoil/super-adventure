package com.kennymaness;


/*
Even though IntelliJ thinks some of these imports aren't used
and should be 'safely deleted, DON'T DELETE THEM! If you do then
Java will throw this error
Exception in thread "main" java.lang.NoClassDefFoundError
when you run the game in the terminal!
Thank you
- Kenny
*/

import static com.kennymaness.Game.*;
import static com.kennymaness.character.Character.*;
import static com.kennymaness.character.Player.*;
import static com.kennymaness.character.CharacterRace.*;
import static com.kennymaness.character.CharacterClass.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        gameStart();
    }
}