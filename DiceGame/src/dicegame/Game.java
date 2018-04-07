package dicegame;

import java.util.Scanner;
import dicegame.Player.*;

public class Game
{

    public int totalScore[];
    public int roundScore[];   
    
    
    
    
    
    
    
    
    public void scoreBoard()
    {
        
        System.out.println("Score: ");
        
        for(int x = 0; x < 2; x++)
        {
            System.out.printf("%s: %d\n", Player.class., totalScore[x]);
        }
    }
  
}
