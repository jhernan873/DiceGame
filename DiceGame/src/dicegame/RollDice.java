package dicegame;

import java.util.Random;
import java.util.Scanner;

public class RollDice
{

    Random rand = new Random();
    private int count = 0;
    private int number = 1;
    private int numberArray[] = new int[6];
    private int diceArray[] = new int[6];
    private boolean keepArray[] = new boolean[6];
    private int chosenNumber;
    Scanner input = new Scanner(System.in);

    public void rollTheDice()
    {
        for (int i = 0; i < 6; ++i)
        {
            numberArray[i] = number;
            number++;
        }

        for (int i = 0; i < 6; i++)
        {
            System.out.printf("Dice %d||", numberArray[i]);

        }
        System.out.println("");
        for (int i = 0; i < 6; i++)
        {
            diceArray[i] = rand.nextInt(6) + 1;
            System.out.printf("%5d ", diceArray[i]);
        }
        System.out.println("");

    }

    public void whichDice()
    {
        for (int i = 0; i < 6; ++i)
        {
            keepArray[i] = false;
            i++;
        }

        System.out.println("Which dice numbers would you like to keep?");
        chosenNumber = input.nextInt();
        if (chosenNumber == 1)
        {

        }

    }

}
