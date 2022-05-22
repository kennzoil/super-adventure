package com.kennymaness;

enum WeaponType {
    DAGGER("dagger", "melee", 2),
    LONGSWORD("longsword", "melee", 2),
    RAPIER("rapier", "melee", 2),
    MACE("mace", "melee", 2),
    BATTLEAXE("battleaxe", "melee", 2),
    HAMMER("hammer", "melee", 2),
    MORNINGSTAR("morningstar", "melee", 2),
    QUARTERSTAFF("quarterstaff", "melee", 2),
    BOW("bow", "melee", 2);

    private final String weaponType;
    private final String weaponRange;
    private final int weaponDamageOutput;

    WeaponType(String weaponType,
               String weaponRange,
               int weaponDamageOutput) {
        this.weaponType = weaponType;
        this.weaponRange = weaponRange;
        this.weaponDamageOutput = weaponDamageOutput;
    }

    public String getWeaponType() {return weaponType;}
    public String getWeaponRange() {return weaponRange;}
    public int getWeaponDamageOutput() {return weaponDamageOutput;}
}

// TODO - Configure WeaponType.weaponDamageOutput to WeaponType from int

public class Weapon {
    
    String weaponName;
    WeaponType weaponType;
    int weaponWeight;
    int weaponDamageOutput;
    Boolean isBroken;
    Boolean isEquipped;

    public Weapon(
            String weaponName,
            WeaponType weaponType,
            int weaponWeight,
            int weaponDamageOutput,
            Boolean isBroken,
            Boolean isEquipped) {

        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.weaponWeight = weaponWeight;
        this.weaponDamageOutput = weaponDamageOutput;
        this.isBroken = isBroken;
        this.isEquipped = isEquipped;
    }

    public int getWeaponWeight() {
        return weaponWeight;
    }
    public void setWeaponWeight(int weaponWeight) {
        this.weaponWeight = weaponWeight;
    }

    public int getWeaponDamageOutput() {
        return weaponDamageOutput;
    }
    public void setWeaponDamageOutput(int weaponDamageOutput) {
        this.weaponDamageOutput = weaponDamageOutput;
    }

    public String getWeaponType () {return weaponType.getWeaponType();}
    public void setType(WeaponType type) {
        this.weaponType = type;
    }

    public void breakWeapon() {if (!this.isBroken) { this.isBroken = true; }}
    public void repairWeapon() {
        if (this.isBroken) { this.isBroken = false; }
    }

    public String getWeaponName() {
        return weaponName;
    }
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public Boolean getEquipped() {return isEquipped;}
    public void setEquipped(Boolean equipped) {isEquipped = equipped;}

    // Constructor!
    public Weapon(
            String weaponName,
            int weaponWeight,
            int weaponDamageOutput,
            WeaponType weaponType,
            Boolean isBroken,
            Boolean isEquipped
    ) {
        this.weaponWeight = weaponWeight;
        this.weaponDamageOutput = weaponDamageOutput;
        this.weaponType = weaponType;
        this.isBroken = isBroken;
        this.weaponName = weaponName;
    }

}