package dicegame;

import java.util.Scanner;

public class Player
{
    private int players;
    private String[] playerName; 
    
    
    public void playerNames(int numPlayers)
    {
        Scanner input = new Scanner(System.in);
        this.players = numPlayers;
        playerName = new String[players];
        
        for (int x = 0; x < numPlayers; x++)
        {
            System.out.printf("Type player%d's name: ", x + 1);
            this.playerName[x] = input.nextLine();
        }
    }
        
    public void setPlayers(int players)
    {
        this.players = players;
    }
    
    public String getPlayers(int playerNum)
    {
        return this.playerName[playerNum];
    }

}