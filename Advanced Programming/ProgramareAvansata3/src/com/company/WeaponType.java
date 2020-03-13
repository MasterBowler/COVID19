package com.company;

import java.util.Random;

/**
 * AR, Handgun, LMG, MP, MR, Shotgun, SMG, Sword, Shield, Spear, Bow;
 */
public enum WeaponType {
    AR, Handgun, LMG, MP, MR, Shotgun, SMG, Sword, Shield, Spear, Bow;

    public static WeaponType getRandomWeapon() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
