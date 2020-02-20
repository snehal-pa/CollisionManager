package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public int getRandomPoints() {
        System.out.println("\nHow many points do you want to add?");
        return getIntInput();

    }

    public int getRandomCircles() {
        System.out.println("\nHow many Circles do you want to add?");
        return getIntInput();
    }

    public int getRandomRectangles() {
        System.out.println("\nHow many Rectangles do you want to add?");
        return getIntInput();
    }


    private int getIntInput() {
        Scanner input = new Scanner(System.in);
        //int num = 0;
            try {
                while (!input.hasNextInt()){
                    input.next();
                    System.out.println("Enter correct input!");
                }
            } catch (InputMismatchException ex) {
                ex.printStackTrace();
            }

        return input.nextInt();
    }

}
