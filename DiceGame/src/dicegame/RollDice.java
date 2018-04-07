package dicegame;

import java.util.ArrayList;
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
    private ArrayList<int[]> chosenNumber1 = new ArrayList<int[]>();
    private int chosenNumber[] = new int[6];
    Scanner input = new Scanner(System.in).useDelimiter("[,\\s+]");

    
    public void createDice()
    {
        for (int i = 0; i < 6; ++i)
        {
            numberArray[i] = number;
            number++;
            diceArray[i] = rand.nextInt(6) + 1;
        }
    }
    
    public void rollTheDice()
    {
        
        for (int i = 0; i < 6; i++)
        {
            System.out.printf("Dice%d: ", numberArray[i]);

            System.out.printf("%d%n", diceArray[i]);
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

        System.out.print("Which dice numbers would you like to keep? ");

        // ugh why won't this work. need them to enter multiple numbers on one line and has them be locked out properly
        while (input.hasNext())
        {
            if (input.hasNextInt())
            {
                int i = 0;
                chosenNumber[i] = input.nextInt();
                i++;
            } else
            {
                input.next();
            }
        }

        if (chosenNumber[0] == 1)
        {
            keepArray[0] = true;
        }
        if (chosenNumber[1] == 2)
        {
            keepArray[1] = true;
        }
        if (chosenNumber[2] == 3)
        {
            keepArray[2] = true;
        }
        if (chosenNumber[3] == 4)
        {
            keepArray[3] = true;
        }
        if (chosenNumber[4] == 5)
        {
            keepArray[4] = true;
        }
        if (chosenNumber[5] == 6)
        {
            keepArray[5] = true;
        }

        for (int i = 0; i < 6; i++)
        {
            if (keepArray[i] == false)
            {
                System.out.printf("Dice%d: ", numberArray[i]);

                diceArray[i] = rand.nextInt(6) + 1;
                System.out.printf("%d%n", diceArray[i]);
            }
        }
    }

}
