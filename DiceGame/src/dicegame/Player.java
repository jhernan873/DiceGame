package dicegame;

import java.util.Scanner;

public class Player
{
    private int players;
    private String[] playerName;
    private boolean[] activePlayer;
    
    
    
    
    public void initializePlayer(int numPlayers)
    {
        
        
        Scanner input = new Scanner(System.in);
                
        this.players = numPlayers;
        this.playerName = new String[this.players];
        Score.totalScore = new int[this.players];
        this.activePlayer = new boolean[this.players];
        
        for (int x = 0; x < numPlayers; x++)
        {
            System.out.printf("Type player%d's name: ", x + 1);
            this.playerName[x] = input.nextLine();  
            Score.totalScore[x] = 0;
            
            if(x == 0)
                this.activePlayer[x] = true;
            else
                this.activePlayer[x] = false;
        }
    }
    
    public String getPlayerName(int playerNum)
    {
        return this.playerName[playerNum];
    }

    public int getPlayers()
    {
        return players;
    }
    
    public void setPlayers(int x)
    {
        if(x > 0)
            this.players = x;
    }
    public boolean getActivePlayer(int x)
    {
        return activePlayer[x];
    }

    public void whosTurn()
    {
        
        
        
        
        
    }


}