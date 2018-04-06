package dicegame;

import java.util.Scanner;

public class Game
{

    private int number;
    
    

    public void nextTurn()
    {
        System.out.println("How many points did you get?");
        Scanner input = new Scanner(System.in);
        
        if (number > 0)
        {
            System.out.println("Thanks. I'll add those points to your total score. Next Player's Turn.");
        }
        else
        {
            System.out.println("You zoughted! Sorry! Next Player's Turn.");
        }
    
    }
    

}
