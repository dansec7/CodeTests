import java.util.Scanner;
import java.awt.*;
import java.io.*;

public class Eoccalc {
    public static void main(String[] args) throws IOException {
        Dialog();
    }

    public static void Dialog() {
        System.out.println("Enter one of the following numbers to perform operation:");
        System.out.println("1. SSR Alter Calc");
        System.out.println("2. Not Yet Implemented");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) sc.next(); //this prevents crash from user inputting letters
        int userInput = sc.nextInt();
        boolean readyInput = true;

        do {
            if (userInput == 1) {
                SSRAltar(readyInput);
                readyInput = false;
            }
            else if (userInput == 2) {

            }
            else {
                System.out.println("Enter either \"1\", \"2\", or \"3\"");
                while (!sc.hasNextInt()) sc.next();
                userInput = sc.nextInt();
            }
        } while (readyInput == true); 
    }

    public static void SSRAltar(boolean readyInput) {
        short starInput = 530;
        final byte fullReward = 45;

        System.out.println("SSR Altar - What star is your needed SSR? \n (Only 3 to 6 are accepted)");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) sc.next();
        int userInput = sc.nextInt();
        switch (userInput) {                
            case 0: break;
            case 1: break;
            case 2: break;
            case 3: starInput -= 80;
                    break;
            case 4: starInput -= 180;
            case 5: starInput -= 330;
            case 6: starInput -= 530;
        }
        if (starInput == 530) {
            System.out.println("Nope");
        }
        else if (starInput == 200) {
            
        }

    }
}