package dicegame;
 
import java.util.*;


public class RollDice2
{

    Random rand = new Random();
    private int count = 0;
    private int number = 1;
    private int numberArray[] = new int[6];
    private int diceArray[] = new int[6];
    private boolean keepArray[] = new boolean[6];
    private ArrayList<int[]> chosenNumber1 = new ArrayList<int[]>();

    Scanner input = new Scanner(System.in);
    private String numbers;

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

        numbers = input.nextLine();

        String[] numberss = numbers.split(" ");

        int[] chosenNumber = new int[numberss.length];

        for (int i = 0; i < chosenNumber.length; i++)
        {
            chosenNumber[i] = Integer.parseInt(numberss[i]);
        }

        for (int i = 0; i < numberss.length; i++)
        {
            if (chosenNumber[i] == 1)
            {
                keepArray[0] = true;
            }
            if (chosenNumber[i] == 2)
            {
                keepArray[1] = true;
            }
            if (chosenNumber[i] == 3)
            {
                keepArray[2] = true;
            }
            if (chosenNumber[i] == 4)
            {
                keepArray[3] = true;
            }
            if (chosenNumber[i] == 5)
            {
                keepArray[4] = true;
            }
            if (chosenNumber[i] == 6)
            {
                keepArray[5] = true;
            }

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

