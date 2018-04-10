package dicegame;

import java.util.*;


public class RollDice
{

    public static ArrayList<Integer> playingSet = new ArrayList<>();
    boolean[] chosenDice = new boolean[6];
    
    Scanner input = new Scanner(System.in);
        
    public void createDice()     
    {
        for(int x = 0;x < 6; x++)
        {
            playingSet.add(x, 0);
            chosenDice[x] = true;
        }   
    }
    
    public void rollDice()
    {       
        Random rand = new Random();
       
        for(int x = 0; x < 6; x++)
        {
            if(chosenDice[x])
            {
                playingSet.set(x, rand.nextInt(6) + 1);
                System.out.printf("Die #%d: %d\n", x + 1, playingSet.get(x));
            }
            else
            {
                System.out.printf("Die #%d: %d\n", x + 1, playingSet.get(x));
            }
            
            System.out.println();
        }
    }
    
    public void chooseDice()
    {
        String keepScore;
        boolean chooseDice = false;
        
        for(int x = 0; x < 1; x++)
        {
            System.out.print("Would you like to 're-roll' or 'add' to score? ");
            keepScore = input.nextLine();
            
            switch(keepScore)
            {
                case "re-roll": chooseDice = false;
                                break;
                case "add":     chooseDice = true;
                                break;
                default:        x--;
                                break;
            }
        }
        
        
        if(chooseDice)
        {
        
        }    
        else
        {
            for(int x = 0; x < 6; x++)
            {
                System.out.printf("Keep dice #%d? 'y' or 'n': ", x + 1);
                String keepDie = input.next();

                System.out.println();

                switch(keepDie)
                {
                    case "n":   break;

                    case "y":   chosenDice[x] = false;
                                break;
                    default:    System.out.println("Invalid option. Choose Again. ");
                                x--;
                                break;
                }
            }
        }   
    }
   
    
    
    
    
    
    
    
}