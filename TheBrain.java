/**
 * This program simulates a Kiosk seen at an ATT fair booth in the 1960s
 * The kiosk would ask you to pick a number from 0 to 15 and then ask
 * 4 questions to guess your number.
 * 
 * @author  Dwight Johnson 
 * @version 10-8-2015
 */
import java.util.*;
import java.io.*;

public class TheBrain
{
    public static boolean isYes(String question)
    {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.print(question + "? ");
        String answer = keyboardInput.nextLine();
        answer = answer.toUpperCase();
        switch (answer.charAt(0))
        {
            case 'Y':
            case 'N':
                return answer.charAt(0)=='Y';
            default:
                System.out.println("Please answer with a 'yes' or 'no'");
                return isYes(question);
        }

    }

    /**
     * main executable for class theBrain
     */
    public static void main(String[] args)
    {
        Scanner keyboardInput = new Scanner(System.in);

        int questions = 0;
        while (questions < 1) 
        {

            System.out.print("How many questions can I ask (must be 1 or more)? ");
            if(keyboardInput.hasNextInt())
            {
                questions=keyboardInput.nextInt();
            }
            else
            {
                System.out.println("That wasn't an integer number. Try again: ");
                keyboardInput.next();
            }

        }
        int maxNumber = (int)Math.pow(2,questions);
        System.out.println("\nPick a number between 0 and " + (maxNumber - 1) + ".\n");

        boolean isOdd = isYes("Is your number odd");
        int guess = maxNumber / 2 - 1;
        int delta = maxNumber / 4;
        for(int questionNum = questions - 1; questionNum >0; questionNum--)
        {
            if (isYes("Is your number greater than " + guess))
            {guess += delta;}
            else
            {guess -= delta;}
            delta /= 2;
        }
        if (isOdd)
        { guess++;}
        System.out.println("The number you guessed is " + guess + ". Am I good or what!\n");
        System.out.println("-----------------------------------------\n\n");
    }
}