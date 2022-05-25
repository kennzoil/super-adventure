package com.kennymaness;

import com.kennymaness.character.CharacterClass;
import com.kennymaness.character.CharacterRace;

import java.util.Arrays;
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

    public static String confirmRace(String prompt, String proposedRace) throws InterruptedException {

        Scanner query = new Scanner(System.in);
        boolean yn = true;
        boolean firstRun = true;
        String response = null;

        while (yn) {

            if (firstRun) {

                /*
//                if (!Character.CharacterRace.allRaces().contains(proposedRace.toLowerCase())) {
//                    do {slowPrint("Invalid race. Please select again.");
//               TODO - print "Be sure to type the hyphen" if proposedRace
//                          does not have a hyphen but is otherwise entered correctly
//                        if (!proposedRace.contains("-") &&
//                                proposedRace.toLowerCase().contains("half") &&
//                                Character.CharacterRace.allRaceValues().contains(proposedRace)) {
//                            slowPrint("Be sure to type the hyphen.");
//                        }
//
//                        proposedRace = query.nextLine();
//                    } while (!Character.CharacterRace.allRaceValues().contains(proposedRace.toLowerCase()));
//                }
                */
                if (!CharacterRace.allRaces().contains(proposedRace.toLowerCase())) {
                    do {
                        Utilities.slowPrint("Invalid race. Please select again.\n" + DisplayText.racePrompt);
                        Utilities.inputCaret();
                        proposedRace = query.nextLine();
                    } while (!CharacterRace.allRaces().contains(proposedRace.toLowerCase()));
                }


                Utilities.slowPrint("You wish to be of the " + proposedRace + " race?");
                Utilities.yesNoCaret();
                response = query.nextLine().toLowerCase();
            }
            switch (response) {
                case "y": {
                    return proposedRace.replace("-", "");
                }
                case "n": {
                    Utilities.slowPrint(prompt);
                    proposedRace = query.nextLine();
                    firstRun = true;
                } break;
                default: {
                    boolean repeat = true;
                    while (repeat) {
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

    public static String confirmClass(String prompt, String proposedClass) throws InterruptedException {

        Scanner query = new Scanner(System.in);
        boolean yn = true;
        boolean firstRun = true;
        String response = null;

        while (yn) {

            if (firstRun) {

                if (!CharacterClass.allClasses().contains(proposedClass.toLowerCase())) {
                    do {
                        Utilities.slowPrint("Invalid class. Please select again." + DisplayText.classPrompt);
                        proposedClass = query.nextLine();
                    } while (!CharacterClass.allClasses().contains(proposedClass.toLowerCase()));
                }

                Utilities.slowPrint("You wish to be a " + proposedClass + "?");
                Utilities.yesNoCaret();
                response = query.nextLine().toLowerCase();
            }
            switch (response) {
                case "y": {
                    return proposedClass;
                }
                case "n": {
                    Utilities.slowPrint(prompt);
                    proposedClass = query.nextLine();
                    firstRun = true;
                } break;
                default: {
                    boolean repeat = true;
                    while (repeat) {
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
