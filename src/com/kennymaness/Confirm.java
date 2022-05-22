package com.kennymaness;

import java.util.Arrays;
import java.util.Scanner;

public class Confirm {

    private static final String[] yesResponses = {"y", "ye", "yes", "ya", "yea", "yeah", "yup", "yep", "yarp"};
    private static final String[] noResponses = {"n", "no", "naw", "nah", "narp"};

    public static Boolean getYesOrNo(String prompt) throws InterruptedException {
        Utilities.slowPrint(prompt + DisplayText.confirmRequest);
        Scanner query = new Scanner(System.in);
        String playerInput = null;
        boolean response;
        boolean responseInvalid = true;
        while (responseInvalid) {
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

    public static String confirm(String prompt, String answer) throws InterruptedException {

        Utilities.slowPrint(prompt);

        Scanner query = new Scanner(System.in);
        boolean yn = true;
        boolean firstRun = true;
        String response = null;

        while (yn) {

            if (firstRun) {
                Utilities.slowPrint("'" + answer + "': confirm [y/n]");
                response = query.nextLine().toLowerCase();
            }
            switch (response) {
                case "y": {
                    return answer;
                }
                case "n": {
                    Utilities.slowPrint(prompt);
                    answer = query.nextLine();
                    firstRun = true;
                }
                break;
                default: {
                    boolean repeat = true;
                    while (repeat) {
                        Utilities.slowPrint("confirm [y/n]");
                        response = query.nextLine().toLowerCase();
                        switch (response) {
                            case "y": {return answer;}
                            case "n": {firstRun = false; repeat = false;}
                            default : {}
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static Boolean yesOrNo() throws InterruptedException {

        // make the scanner, print the prompt
        Scanner query = new Scanner(System.in);
        Boolean yes = null;
        Utilities.slowPrint("[y/n]");

        // store user input in 'answer' String
        String answer = query.nextLine().toLowerCase();

        // ensure answer is either 'yes' or 'no'
        switch (answer) {
            case "y": {yes = true;} break;
            case "n": {yes = false;} break;
            default: {
                boolean repeat = true;
                while (repeat) {
                    Utilities.slowPrint(
                            "[y] = yes/n" +
                            "[n] = no");
                    answer = query.nextLine().toLowerCase();
                        switch (answer) {
                            case "y": {yes = true; repeat = false;} break;
                            case "n": {yes = false; repeat = false;} break;
                            default: {}
                    }
                }
            }
        }
        return yes;
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
                    do {Utilities.slowPrint("Invalid race. Please select again.");
                        proposedRace = query.nextLine();
                    } while (!CharacterRace.allRaces().contains(proposedRace.toLowerCase()));
                }


                Utilities.slowPrint("'" + proposedRace + "': confirm [y/n]");
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
                        Utilities.slowPrint("confirm [y/n]");
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
                        Utilities.slowPrint("Invalid class. Please select again.");
                        prompt = query.nextLine();
                    } while (!CharacterClass.allClasses().contains(proposedClass.toLowerCase()));
                }

                Utilities.slowPrint("'" + proposedClass + "': confirm [y/n]");
                response = query.nextLine().toLowerCase();
            }
            switch (response) {
                case "y": {
                    return proposedClass;
                }
                case "n": {
                    Utilities.slowPrint(prompt);
                    prompt = query.nextLine();
                    firstRun = true;
                } break;
                default: {
                    boolean repeat = true;
                    while (repeat) {
                        Utilities.slowPrint("confirm [y/n]");
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
