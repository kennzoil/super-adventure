package com.kennymaness.character;

import com.kennymaness.*;
import com.kennymaness.map.Direction;
import com.kennymaness.map.Location;
import com.kennymaness.weapon.Weapon;

import java.util.ArrayList;

public class Player extends Character {
    public Player(int currentHitPoints,
                  ArrayList<Weapon> weaponPouch,
                  ArrayList<Item> itemPouch,
                  int[] abilityScores,
                  CharacterClass characterClass,
                  CharacterRace characterRace,
                  Boolean isArmed,
                  Location currentLocation) {
        super(
                currentHitPoints,
                weaponPouch,
                itemPouch,
                abilityScores,
                characterClass,
                characterRace,
                isArmed,
                currentLocation
        );
    }

    public void addWeapon(Weapon weapon) {
        this.getWeaponPouch().add(weapon);
    }
    public void removeWeapon(Weapon weapon) {
        this.getWeaponPouch().remove(weapon);
    }

    /* --------------------------------------------------------------------------------------------- */
    /* ------------------------------------- MOVE PLAYER METHOD ------------------------------------ */
    /* --------------------------------------------------------------------------------------------- */

    public void movePlayer(Direction direction) throws InterruptedException {

        Location destination = null;
        switch (direction) {
            case NORTH -> this.setCurrentLocation(this.getCurrentLocation().getLocationToNorth());
            case SOUTH -> this.setCurrentLocation(this.getCurrentLocation().getLocationToSouth());
            case EAST -> this.setCurrentLocation(this.getCurrentLocation().getLocationToEast());
            case WEST -> this.setCurrentLocation(this.getCurrentLocation().getLocationToWest());
            case UP -> this.setCurrentLocation(this.getCurrentLocation().getLocationToUp());
            case DOWN -> this.setCurrentLocation(this.getCurrentLocation().getLocationToDown());
        }
        destination = this.getCurrentLocation();
        if (destination == null) {
            Utilities.slowPrint("There is no location in that direction.");
        } else {
            Utilities.slowPrint("You move " + direction.getDirectionName() +
                    " to " + destination.getName() + ".");
            this.currentLocation = destination;
        }

    }

    /* --------------------------------------------------------------------------------------------- */
    /* ------------------------------------ EQUIP WEAPON METHOD ------------------------------------ */
    /* --------------------------------------------------------------------------------------------- */

    public void equipWeapon(Weapon weapon) throws InterruptedException {

        // if the player isn't unarmed, equip the weapon and arm the player
        if (!this.isArmed) {
            weapon.setEquipped(true);
            this.isArmed = true;

        // but if the player is already armed,
        } else {
            // ask the player if they want to replace their currently equipped weapon with the new weapon
            Boolean playerAnswer = Confirm.getYesOrNo(
                    "Unequip your " + getWeaponPouch().get(0).getWeaponName() +
                    " and equip the " + weapon.getWeaponName() + "?"
            );

            // if they answer yes,
            if (playerAnswer) {
                // unequip their currently equipped weapon, and...
                this.getWeaponPouch().get(0).setEquipped(false);
                // ... if the new weapon is already in their weapon pouch, simply equip it
                if (this.getWeaponPouch().contains(weapon)) {
                    weapon.setEquipped(true);
                // otherwise, add it to their weapon pouch and equip it.
                } else {
                    this.addWeapon(weapon);
                    weapon.setEquipped(true);
                }

            // and if they do not want to replace their currently held weapon with the new weapon,
            } else {
                // don't.
                Utilities.slowPrint("You decide to keep on hanging on to your trusty " +
                        this.getWeaponPouch().get(0).getWeaponType() + " " +
                        this.getWeaponPouch().get(0).getWeaponName() + ".\n" +
                        "It's probably better this way anyway.");
                weapon = this.getWeaponPouch().get(0);
            }
        }
        // confirm for the player that they are now holding the weapon that they are holding,
        // whether it be the one they've just equipped,
        // or if they've decided to continue holding onto their previously equipped weapon.
        Utilities.slowPrint(
                "You're now wielding your " +
                        this.getWeaponPouch().get(0).getWeaponType() + ", " +
                        this.getWeaponPouch().get(0).getWeaponName() + ". ");
    }

    /* --------------------------------------------------------------------------------------------- */
    /* --------------------------------- CHARACTER CREATION METHOD --------------------------------- */
    /* --------------------------------------------------------------------------------------------- */

    public static Player createPlayer() throws InterruptedException {

        // player selects race
        CharacterRace newPlayerRace = CharacterRace.valueOf(Confirm.confirmRace().toUpperCase());

        // player selects class
        CharacterClass newPlayerClass = CharacterClass.valueOf(Confirm.confirmClass().toUpperCase());

        // assign default player attributes
        ArrayList<Weapon> newPlayerWeaponPouch = new ArrayList<>();
        ArrayList<Item> newPlayerItemPouch = new ArrayList<>();
        int[] newPlayerAbilityScores = new int[]{10, 10, 10, 10, 10, 10};

        // create the starting weapon with the weaponType corresponding to newPlayerClass
        Weapon startingWeapon = Utilities.createStartingWeapon(newPlayerClass);

        // create player object
        Player newPlayer = new Player(
                MAX_HIT_POINTS,
                newPlayerWeaponPouch,
                newPlayerItemPouch,
                newPlayerAbilityScores,
                newPlayerClass,
                newPlayerRace,
                false,
                Location.townGate
        );

        // add the starting weapon to the player's weapon pouch
        newPlayer.addWeapon(startingWeapon);

        Utilities.slowPrint(DisplayText.linebreak);
        Utilities.slowPrint(DisplayText.startingHitPointsPrompt);
        Utilities.slowPrint("You've made your way to the town gate, and you see a guard.");

        // if the starting weapon has a nickname, print this
        if (!startingWeapon.getWeaponName().equals(DisplayText.startingWeaponDefaultName)) {
            Utilities.slowPrint("Oh shoot, you're still holding your " +
                                startingWeapon.getWeaponType() +
                                " (which for some reason is named " + startingWeapon.getWeaponName() + ")! " +
                                "The guard's probably not gonna like that!");
            // otherwise, print this
        } else {
            Utilities.slowPrint("Oh crap, wait! You're still brandishing that old " +
                                startingWeapon.getWeaponType() + "! The guard's probably not gonna like that!");
        }

        // ----- STEP 3b - ask if the user would like to unequip it

        Boolean playerAnswer = Confirm.getYesOrNo(
                "Unequip your " + newPlayer.getWeaponPouch().get(0).getWeaponType() + "?");
        if (playerAnswer) {
            startingWeapon.setEquipped(false);
            Utilities.slowPrint(
                    "You quickly stow " + newPlayer.getWeaponPouch().get(0).getWeaponName() +
                    " back into your pouch before the guard notices. Phew!\n" +
                    "He turns to see you approaching the town gate and hails you, unaware of what just happened.");
        } else {
            newPlayer.equipWeapon(startingWeapon);
        }

        // the guard greets the player and asks for their name
        newPlayer.setCharacterName(Confirm.getAnswer(DisplayText.namePrompt));

        // player.assignPlayerName(playerPrompt);
        Utilities.slowPrint("\"Ah, a fine name indeed. Well met, " + newPlayer.getCharacterName() + "!\"");

        return newPlayer;
    }
}