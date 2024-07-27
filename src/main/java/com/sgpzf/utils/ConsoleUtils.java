package com.sgpzf.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void waitWindow(){
        System.out.println("");
        System.out.println("Press enter to continue");
        sc.nextLine();
    }

    public static int verifyingIntNoRange(){
        int option = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                option = sc.nextInt();
                sc.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.next();  
            }
        }
        
        return option;
    }

    public static int verifyEntryInt(int min, int max) {
        int option = -1;

        while (true) {
            try {
                option = sc.nextInt();
                sc.nextLine();
                if (option >= min && option <= max) {
                    break; 
                } else {
                    System.out.println("Invalid input. Please, select an option between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please, enter a number between " + min + " and " + max + ".");
                sc.nextLine(); 
            }
        }

        return option;
    }

    public static String verifyEntryString() {
        String entry = "";

        while (true) {
            entry = sc.nextLine().trim(); 
            if (!entry.isEmpty()) {
                break; 
            } else {
                System.out.println("Invalid input. Please enter text only.");
            }
        }

        return entry; 
    }

    public static Date verifyDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        while (true) {
            try {
                String dateStr = sc.nextLine().trim();
                java.util.Date utilDate = formatter.parse(dateStr);
                return new Date(utilDate.getTime());
            } catch (ParseException e) {
                System.out.println("Formato de fecha no válido. Por favor, ingrese la fecha en el formato yyyy-MM-dd.");
            }
        }
    }


    // verify the format from string
    public static String verifyingStringFormat(String regex, String type) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            input = sc.nextLine();

            if (input.matches(regex)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please follow the format for a valid " + type + ".");
            }
        }

        return input;
    }


    public static String verifyingStringMaxStringREGEX(int maxLength) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            input = sc.nextLine();

            if (input.length() <= maxLength) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a string with at most " + maxLength + " characters.");
            }
        }

        return input;
    }

   
    public static String verifyingIntREGEXString() {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            input = sc.nextLine();

            try {
                Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer(numbers only).");
            }
        }

        return input;
    }
}
