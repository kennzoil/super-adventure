package com.kennymaness.map;

import com.kennymaness.DisplayText;
import com.kennymaness.Item;

import java.util.ArrayList;

public class Location {

    private final String name;
    private String description;
    private ArrayList<Item> items;
    private ArrayList<Character> characters;
    private Location locationToNorth;
    private Location locationToSouth;
    private Location locationToEast;
    private Location locationToWest;
    private Location locationToUp;
    private Location locationToDown;

    public Location(
            String name,
            String description,
            ArrayList<Item> items,
            ArrayList<Character> characters,
            Location locationToNorth,
            Location locationToSouth,
            Location locationToEast,
            Location locationToWest,
            Location locationToUp,
            Location locationToDown
    ) {
        this.name = name;
        this.description = description;
        this.locationToNorth = locationToNorth;
        this.locationToSouth = locationToSouth;
        this.locationToEast = locationToEast;
        this.locationToWest = locationToWest;
        this.locationToUp = locationToUp;
        this.locationToDown = locationToDown;

    }

    private static ArrayList<Item> townGateItems;
    private static ArrayList<Character> townGateCharacters;
    public static Location townGate = new Location(
            "Town Gate",
            DisplayText.townGateDescription,
            townGateItems,
            townGateCharacters,
            null,
            Location.stables,
            null,
            null,
            null,
            null
    );

    private static ArrayList<Item> stablesItems;
    private static ArrayList<Character> stablesCharacters;
    public static Location stables = new Location(
            "The Stables",
            DisplayText.stablesDescription,
            stablesItems,
            stablesCharacters,
            Location.townGate,
            null,
            null,
            null,
            null,
            null);


    private static ArrayList<Item> mainStreetItems;
    private static ArrayList<Character> mainStreetCharacters;
    public static Location mainStreet = new Location(
            "Main Street ",
            DisplayText.mainStreetDescription,
            mainStreetItems,
            mainStreetCharacters,
            Location.market,
            null,
            null,
            null,
            null,
            null
    );

    private static ArrayList<Item> gatehouseItems;
    private static ArrayList<Character> gatehouseCharacters;
    public static Location gatehouse = new Location(
            "Gatehouse",
            DisplayText.gatehouseDescription,
            gatehouseItems,
            gatehouseCharacters,
            null,
            null,
            Location.townGate,
            null,
            null,
            null
    );

    private static ArrayList<Item> pubItems;
    private static ArrayList<Character> pubCharacters;
    public static Location pub = new Location(
            "The Pub",
            DisplayText.pubDescription,
            pubItems,
            pubCharacters,
            null,
            null,
            Location.mainStreet,
            null,
            null,
            null
    );

    private static ArrayList<Item> sewerItems;
    private static ArrayList<Character> sewerCharacters;
    public static Location sewer = new Location(
            "The Sewer",
            DisplayText.sewerDescription,
            sewerItems,
            sewerCharacters,
            null,
            null,
            null,
            null,
            Location.mainStreet,
            null
    );

    private static ArrayList<Item> innItems;
    private static ArrayList<Character> innCharacters;
    public static Location inn = new Location(
            "The Inn",
            DisplayText.innDescription,
            innItems,
            innCharacters,
            null,
            null,
            null,
            Location.mainStreet,
            null,
            null
    );

    private static ArrayList<Item> marketItems;
    private static ArrayList<Character> marketCharacters;
    public static Location market = new Location(
            "The Market",
            DisplayText.marketDescription,
            marketItems,
            marketCharacters,
            null,
            Location.mainStreet,
            Location.potionShop,
            Location.weaponStore,
            null,
            null
    );

    private static ArrayList<Item> potionShopItems;
    private static ArrayList<Character> potionShopCharacters;
    public static Location potionShop = new Location(
            "Potion Shop",
            DisplayText.potionShopDescription,
            potionShopItems,
            potionShopCharacters,
            null,
            null,
            null,
            Location.market,
            null,
            null
    );

    private static ArrayList<Item> weaponStoreItems;
    private static ArrayList<Character> weaponStoreCharacters;
    public static Location weaponStore = new Location(
            "Weapon Store",
            DisplayText.weaponStoreDescription,
            weaponStoreItems,
            weaponStoreCharacters,
            null,
            null,
            Location.market,
            null,
            null,
            null
    );

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setAreaItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public Location getLocationToNorth() {return this.locationToNorth;}

    public Location getLocationToSouth() {
        return this.locationToSouth;
    }

    public Location getLocationToEast() {
        return this.locationToEast;
    }

    public Location getLocationToWest() {
        return this.locationToWest;
    }

    public Location getLocationToUp() {
        return this.locationToUp;
    }

    public Location getLocationToDown() {
        return this.locationToDown;
    }

}
