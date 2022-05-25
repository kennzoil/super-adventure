package com.kennymaness.map;

import com.kennymaness.DisplayText;
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
            DisplayText.townGateDescription,
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
            DisplayText.stablesDescription,
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
            DisplayText.mainStreetDescription,
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
            DisplayText.gatehouseDescription,
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
