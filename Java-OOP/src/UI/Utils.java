package UI;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static int getIntFromUser(int min,int max) {
        Scanner sc = new Scanner(System.in);
        int choose;
        try {
            choose = sc.nextInt();
            if (choose >= min && choose <= max) {
                return choose;
            } else {
                System.out.println("please choose a number between " + min + " and " + max);
            }
        } catch (InputMismatchException exception) {
            choose = getIntFromUser(min,max);
        }
        return choose;
    }

    public static boolean getBooleanFromUser() {
        Scanner sc = new Scanner(System.in);
        boolean bool;
        System.out.println("Would you like to play again?\ny/n\n");
        try {
            char choose = sc.next().charAt(0);
            switch (choose) {
                case 'y' -> bool = true;
                case 'n' -> bool = false;
                default -> {
                    System.out.println("Please enter y/n\n");
                    bool = getBooleanFromUser();
                }
            }
        } catch (NoSuchElementException exception) {
            System.out.println("Please enter y/n\n");
            bool = getBooleanFromUser();
        }
        return bool;
    }

    public static String initUserName(){
        System.out.println("Please enter your name:");
        Scanner sc = new Scanner(System.in);
        String userName;
        try{
            userName = sc.nextLine();
        }
        catch(NoSuchElementException exception){
            userName = initUserName();
        }
        return userName;
    }

    public static int getRandomNumber(int min,int max){
        Random rand = new Random();
        return rand.nextInt(min, max);
    }

    public static void clearConsoleScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
