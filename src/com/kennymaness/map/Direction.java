package com.kennymaness.map;

public enum Direction {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west"),
    UP("up"),
    DOWN("down");

    private final String directionName;

    Direction(String directionName) {
        this.directionName = directionName;
    }

    public String getDirectionName() {
        return directionName;
    }
}
