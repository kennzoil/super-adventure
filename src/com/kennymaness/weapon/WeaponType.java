package com.kennymaness.weapon;

import com.kennymaness.Utilities;

import static com.kennymaness.weapon.DamageType.*;

public enum WeaponType {

    DAGGER(
            "dagger",
            "melee",
            4,
            1,
            PIERCING),
    LONGSWORD(
            "longsword",
            "melee",
            8,
            3,
            SLASHING),
    RAPIER(
            "rapier",
            "melee",
            8,
            2,
            PIERCING),
    MACE("mace",
            "melee",
            6,
            4,
            BLUDGEONING),
    BATTLEAXE(
            "battleaxe",
            "melee",
            8,
            4,
            SLASHING),
    MORNINGSTAR(
            "morningstar",
            "melee",
            8,
            4,
            PIERCING),
    QUARTERSTAFF(
            "quarterstaff",
            "melee",
            6,
            4,
            BLUDGEONING),
    BOW(
            "bow",
            "ranged",
            6,
            2,
            PIERCING);


    private final String weaponType;
    private final String weaponRange;
    private final int weaponDamageOutput;
    private final int weight;
    private final DamageType damageType;

    WeaponType(String weaponType,
               String weaponRange,
               int weaponDamageOutput,
               int weight,
               DamageType damageType) {
        this.weaponType = weaponType;
        this.weaponRange = weaponRange;
        this.weaponDamageOutput = weaponDamageOutput;
        this.weight = weight;
        this.damageType = damageType;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public String getWeaponRange() {
        return weaponRange;
    }

    public int getWeaponDamageOutput() {
        return weaponDamageOutput;
    }

    public int getWeight() {return weight;}

    public DamageType getDamageType() {return damageType;}
}
