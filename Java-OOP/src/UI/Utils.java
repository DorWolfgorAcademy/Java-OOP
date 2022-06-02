package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    public static int getIntFromUser(int min,int max){
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                int choose = sc.nextInt();
                if (choose >= min && choose <= max) {
                    return choose;
                } else {
                    System.out.println("please choose a number between " + min + " and " + max);
                }
            } catch (InputMismatchException exception) {
                System.out.println("please choose a number between " + min + " and " + max);
            }
        }
    }

    public static boolean getBooleanFromUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to play again?\ny/n\n");
        while(true) {
            char choose = sc.next().charAt(0);
            switch(choose){
                case 'y':
                    return true;
                case 'n':
                    return false;
                default:
                    System.out.println("Please enter y/n\n");
            }
        }
    }
    public static void clearConsoleScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
