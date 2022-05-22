package com.kennymaness.map;

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

    public Location getLocationToNorth() {
        return locationToNorth;
    }

    public Location getLocationToSouth() {
        return locationToSouth;
    }

    public Location getLocationToEast() {
        return locationToEast;
    }

    public Location getLocationToWest() {
        return locationToWest;
    }

    public Location getLocationToUp() {
        return locationToUp;
    }

    public Location getLocationToDown() {
        return locationToDown;
    }

}
