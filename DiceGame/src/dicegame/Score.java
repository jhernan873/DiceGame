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
            
        for(int x = 0;x < 6; x++)
        {
        scoreResult[x] = Collections.frequency(RollDice.playingSet,x + 1);
        }

        for(int x = 0; x < 6; x++)
        {
            if(scoreResult[x] >= 3)
            {
                roundScore = (x + 1) * 100 * scoreResult[x];
            }
        }
       
        
        if(RollDice.playingSet.containsAll(straight))
        {
            roundScore = roundScore + 1500;
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
    
    
    public static void addToScore()
    {
        
    }



    }
