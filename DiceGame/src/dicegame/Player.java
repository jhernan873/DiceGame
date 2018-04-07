package dicegame;

import java.util.Scanner;

public class Player
{
    public int players;
    public String[] playerName;
    public int totalScore[];
    
    public void initializePlayer(int numPlayers)
    {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
                
        this.players = numPlayers;
        playerName = new String[players];
        totalScore = new int[players];
        
        for (int x = 0; x < numPlayers; x++)
        {
            System.out.printf("Type player%d's name: ", x + 1);
            this.playerName[x] = input.nextLine();  
            totalScore[x] = 0;           
        }
    }
    
    public String getPlayers(int playerNum)
    {
        return this.playerName[playerNum];
    }

    public void playerTotalScore()
    {
        System.out.printf("Score: \n\n");
        
        for(int x = 0; x < this.players; x++)
        {
            System.out.printf("%10s - %d\n\n", getPlayers(x), totalScore[x]);
        }
    }



}