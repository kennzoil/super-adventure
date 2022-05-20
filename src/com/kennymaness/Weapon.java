package com.kennymaness;


public class Weapon {

    enum WeaponType {
        DAGGER("dagger"),
        LONGSWORD("longsword"),
        RAPIER("rapier"),
        MACE("mace"),
        BATTLEAXE("battleaxe"),
        HAMMER("hammer"),
        MORNINGSTAR("morningstar"),
        QUARTERSTAFF("quarterstaff"),
        BOW("bow");

        public final String weaponType;
        WeaponType(String type) {this.weaponType = type;}

        public String getWeaponType() {return weaponType;}
    }
    
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