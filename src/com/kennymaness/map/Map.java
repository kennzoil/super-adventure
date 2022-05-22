package com.kennymaness.map;

import com.kennymaness.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {

    private final HashMap<String, Location> map = new HashMap<>() {
        {
            put("Town Gate", townGate);
            put("Stables", stables);
            put("Gatehouse", gatehouse);
            put("Main Street", mainStreet);
        }
    };

    private ArrayList<Item> townGateItems;
    private ArrayList<Character> townGateCharacters;
    private Location townGate = new Location(
            "Town Gate",
            "The gate leading into town. There is a guard with a halberd posted just outside.",
            this.townGateItems,
            this.townGateCharacters,
            null,
            this.stables,
            null,
            null,
            null,
            null
    );

    private ArrayList<Item> stablesItems;
    private ArrayList<Character> stablesCharacters;
    private Location stables = new Location(
            "The Stables",
            "The stables just outside the city wall. There are horses.",
            stablesItems,
            stablesCharacters,
            this.townGate,
            null,
            null,
            null,
            null,
            null);


    private ArrayList<Item> mainStreetItems;
    private ArrayList<Character> mainStreetCharacters;
    private Location mainStreet = new Location(
            "Main Street ",
            "The bit of Main Street just inside the town wall. To the west is the pub, and the inn is to your east.",
            this.mainStreetItems,
            this.mainStreetCharacters,
            null,
            null,
            null,
            null,
            null,
            null
    );

    private ArrayList<Item> gatehouseItems;
    private ArrayList<Character> gatehouseCharacters;
    private Location gatehouse = new Location(
            "Gatehouse",
            "The gatehouse just outside the city gates, where the guards eat their snacks.",
            this.gatehouseItems,
            this.gatehouseCharacters,
            null,
            null,
            this.townGate,
            null,
            null,
            null
    );

    /* TODO - create the following Locations
    *
    * pub
    * sewer
    * inn
    * market
    * weapon store
    * potion shop
    *
    * */

}
