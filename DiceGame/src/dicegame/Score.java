
package dicegame;

import java.util.*;

/**
 *
 */
public class Score{

    public static int[] totalScore;
    private int[] scoreResult;
    private int roundScore;
    
    Player player = new Player();
    
    
    public void calculateScoring()
    {
        
        int[] gameEnder = new int[6];
        ArrayList<Integer> straight = new ArrayList<>(
            Arrays.asList(1,2,3,4,5,6));
        scoreResult = new int[6];
        roundScore = 0;
        
        //loops through playingSet and finds frequency of each value in set
        for(int x = 0;x < 6; x++)
        {
        scoreResult[x] = Collections.frequency(RollDice.scoringSet,x + 1);
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
                roundScore = roundScore + (100 * (x + 1));
                
                if(scoreResult[x] >= 4)
                    roundScore = roundScore +((x - 3) * (100 * (x + 1)));
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
         
    public void totalScore()
       {
           System.out.printf("Score: \n\n");

           for(int x = 0; x < player.getPlayers(); x++)
           {
               System.out.printf("%10s - %d\n\n", player.getPlayerName(x), totalScore[x]);
           }
       }

    public void displayRoundScore()
    {
        calculateScoring();
        
        System.out.printf("Max Score: %d\n\n", roundScore);   
        
    }
    
    
    public void addToScore(int x)
    {
        if(roundScore > 0)
        {
            totalScore[x] = roundScore;
        }
    }
    
    public int getRoundScore()
    {
        return roundScore;
    }

    public void setRoundScore(int x)
    {
        if(x > 0)
            roundScore = x;
    }


}
