package com.kennymaness;

public class Utilities {

    // method for displaying text sequentially, to be used in place of System.out.println()
    public static void slowPrint(String string) throws InterruptedException {
        char[] chars = string.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
            Thread.sleep(10);
        }
        System.out.print("\n");
    }

    // alternate text-displaying method for displaying text faster
    public static void fastPrint(String string) throws InterruptedException {
        char[] chars = string.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
            Thread.sleep(1);
        }
        System.out.print("\n");
    }

}
