/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.util.*;



/**
 *
 * @author Jorge
 */
public class Score 
{

    public static int[] totalScore;
    public static int[] scoreResult;
    public static int roundScore;
    
    
    public static void calculateScoring()
    {
        
        int[] gameEnder = new int[6];
        ArrayList<Integer> straight = new ArrayList<>(
            Arrays.asList(1,2,3,4,5,6));
        scoreResult = new int[6];
        
        //loops through playingSet and finds frequency of each value in set
        for(int x = 0;x < 6; x++)
        {
        scoreResult[x] = Collections.frequency(RollDice.playingSet,x + 1);
        }


        //checks to see if playingSet contains a straight
        if(RollDice.playingSet.containsAll(straight))
        {
            roundScore = roundScore + 1500;
        }
        
        //calculates score by multiplying the number of instances times 100 times the value of the dice
        for(int x = 0; x < 6; x++)
        {
            if(scoreResult[x] >= 3)
            {
                roundScore = roundScore + (x + 1) * 100 * scoreResult[x];
            }
        }
        
        //creates an array of size six then  fills up with that value to check if game ending score is rolled
        for(int y = 0; y < 6; y++)
        {
            for(int x = 0; x < 6; x++)
            {
                gameEnder[x] = RollDice.playingSet.get(y);
            }
            
            if(gameEnder.equals(RollDice.playingSet.toArray()))
            {
                roundScore = roundScore + 10000;
            }
        }
        
        //checks for either a 1 or 5 rolled to continue     
        if(scoreResult[0] > 0 && scoreResult[0] < 3)
        {
            roundScore = roundScore + (scoreResult[0] * 100);
        }
        if(scoreResult[4] > 0 && scoreResult[4] < 3)
        {
            roundScore = roundScore + (scoreResult[4] * 50);
        }
        else if(roundScore == 0)
        {
            
        }
}   
         
    
    
    public static void totalScore()
       {
           System.out.printf("Score: \n\n");

           for(int x = 0; x < Player.players; x++)
           {
               System.out.printf("%10s - %d\n\n", Player.getPlayers(x), totalScore[x]);
           }
       }

    public static void calculateMax()
    {
        
    }
    
    
    public static void addToScore(int calculatedScore)
    {
        if(calculatedScore > 0)
        {
            
        }
    }



    }
