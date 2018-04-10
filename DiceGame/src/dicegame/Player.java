package dicegame;

import java.util.Scanner;

public class Player
{
    public static int players;
    public static String[] playerName;
    public static boolean[] activePlayer;
    
    
    
    
    public void initializePlayer(int numPlayers)
    {
        Scanner input = new Scanner(System.in);
                
        Player.players = numPlayers;
        Player.playerName = new String[Player.players];
        Score.totalScore = new int[Player.players];
        Player.activePlayer = new boolean[Player.players];
        
        for (int x = 0; x < numPlayers; x++)
        {
            System.out.printf("Type player%d's name: ", x + 1);
            Player.playerName[x] = input.nextLine();  
            Score.totalScore[x] = 0;
            
            if(x == 0)
                Player.activePlayer[x] = true;
            else
                Player.activePlayer[x] = false;
        }
    }
    
    public static String getPlayers(int playerNum)
    {
        return Player.playerName[playerNum];
    }

   

    public void whosTurn()
    {
        
        
        
        
        
    }


}