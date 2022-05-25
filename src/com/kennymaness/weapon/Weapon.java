package com.kennymaness.weapon;

import com.kennymaness.Item;

public class Weapon extends Item {
    
    String weaponName;
    WeaponType weaponType;
    int weaponWeight;
    int weaponDamageOutput;
    Boolean isBroken;
    Boolean isEquipped;

    public Weapon(
            String weaponName,
            WeaponType weaponType,
            Boolean isBroken,
            Boolean isEquipped) {

        this.weaponName = weaponName;
        this.weaponType = weaponType;
        this.isBroken = isBroken;
        this.isEquipped = isEquipped;
    }


    public int getWeaponWeight() {
        return weaponWeight;
    }

    public int getWeaponDamageOutput() {
        return weaponDamageOutput;
    }

    public String getWeaponType () {return weaponType.getWeaponType();}

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

}