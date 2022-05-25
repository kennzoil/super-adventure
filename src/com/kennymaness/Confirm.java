package com.kennymaness;

import com.kennymaness.character.CharacterClass;
import com.kennymaness.character.CharacterRace;
import jdk.jshell.execution.Util;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Confirm {

    private static final String[] yesResponses = {"y", "ye", "yes", "ya", "yea", "yeah", "yup", "yep", "yarp"};
    private static final String[] noResponses = {"n", "no", "naw", "nah", "narp"};


    public static Boolean getYesOrNo(String prompt) throws InterruptedException {
        Scanner query = new Scanner(System.in);
        String playerInput = null;
        boolean response;
        boolean responseInvalid = true;

        while (responseInvalid) {
            Utilities.slowPrint(prompt);
            Utilities.yesNoCaret();
            playerInput = query.nextLine().toLowerCase();
            responseInvalid = !Arrays.asList(yesResponses).contains(playerInput) &&
                    !Arrays.asList(noResponses).contains(playerInput);
            if (responseInvalid) {
                Utilities.slowPrint(DisplayText.alertOfInvalidAnswer);
            }
        }

        response = Arrays.asList(yesResponses).contains(playerInput);
        return response;
    }

    public static String getAnswer(String prompt) throws InterruptedException {

        Scanner query = new Scanner(System.in);
        String playerInput = null;
        boolean response;
        boolean responseIsValid = true;

        while (responseIsValid) {
            Utilities.slowPrint(prompt);
            Utilities.inputCaret();
            playerInput = query.nextLine();
            response = Confirm.getYesOrNo(playerInput);
            if (!response) { //loop again
            } else { responseIsValid = false; } //break the loop
        }
        return playerInput;
    }

    public static String confirmRace() throws InterruptedException {
        Scanner query = new Scanner(System.in);
        boolean yn = true;
        boolean firstRun = true;
        String response = null;
        String proposedRace = null;

        while (yn) {

            Utilities.slowPrint(DisplayText.racePrompt);
            Utilities.inputCaret();
            proposedRace = query.nextLine();

            if (firstRun) {
                if (!CharacterRace.allRaces().contains(proposedRace.toLowerCase())) {
                    do {
                        Utilities.slowPrint("Invalid race. Please select again.\n" + DisplayText.racePrompt);
                        Utilities.inputCaret();
                        proposedRace = query.nextLine();
                    } while (!CharacterRace.allRaces().contains(proposedRace.toLowerCase()));
                }


                Utilities.slowPrint("You wish to be of the " + proposedRace.toLowerCase() + " race?");
                Utilities.yesNoCaret();
                response = query.nextLine().toLowerCase();
            }
            switch (response) {
                case "y": {
                    return proposedRace.replace("-", "");
                }
                case "n": {
                    firstRun = true;
                } break;
                default: {
                    boolean repeat = true;
                    while (repeat) {
                        Utilities.slowPrint("You wish to be of the " + proposedRace.toLowerCase() + " race?");
                        Utilities.yesNoCaret();
                        response = query.nextLine().toLowerCase();
                        switch (response) {
                            case "y": {return proposedRace.replace("-", "");}
                            case "n": {firstRun = false; repeat = false;}
                            default : {}
                        }
                    }
                }
            }
        }
        return proposedRace.replace("-", "");
    }

    public static String confirmClass() throws InterruptedException {

        Scanner query = new Scanner(System.in);
        boolean yn = true;
        boolean firstRun = true;
        String response = null;
        String proposedClass = null;

        while (yn) {

            Utilities.slowPrint(DisplayText.classPrompt);
            Utilities.inputCaret();
            proposedClass = query.nextLine();

            if (firstRun) {

                if (!CharacterClass.allClasses().contains(proposedClass.toLowerCase())) {
                    do {
                        Utilities.slowPrint("Invalid class. Please select again." + DisplayText.classPrompt);
                        proposedClass = query.nextLine();
                    } while (!CharacterClass.allClasses().contains(proposedClass.toLowerCase()));
                }

                Utilities.slowPrint("You wish to be a " + proposedClass.toLowerCase() + "?");
                Utilities.yesNoCaret();
                response = query.nextLine().toLowerCase();
            }
            switch (response) {
                case "y": {
                    return proposedClass;
                }
                case "n": {
                    firstRun = true;
                } break;
                default: {
                    boolean repeat = true;
                    while (repeat) {
                        Utilities.slowPrint("You wish to be a " + proposedClass.toLowerCase() + "?");
                        Utilities.yesNoCaret();
                        response = query.nextLine().toLowerCase();
                        switch (response) {
                            case "y": {return proposedClass;}
                            case "n": {firstRun = false; repeat = false;}
                            default : {}
                        }
                    }
                }
            }
        }
        return proposedClass;
    }

}
