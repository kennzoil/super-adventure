package com.kennymaness.map;

import com.kennymaness.DisplayText;
import com.kennymaness.Item;

import java.util.ArrayList;
import java.util.HashMap;

import static com.kennymaness.map.Location.*;

public class Map {

    public static final HashMap<String, Location> townMap = new HashMap<>() {
        {
            put("Town Gate", townGate);
            put("Stables", stables);
            put("Main Street", mainStreet);
            put("Gatehouse", gatehouse);
            put("The Pub", pub);
            put("The Sewer", sewer);
            put("The Inn", inn);
            put("The Market", market);
            put("Potion Shop", potionShop);
            put("Weapon Store", weaponStore);
        }
    };
}
