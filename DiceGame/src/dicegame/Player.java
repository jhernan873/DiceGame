
package dicegame;

import java.util.*;
/**
 *
 * @author Jorge
 */

public class Player 
{
    
    private String playerName;
    private boolean playerStatus;
    private int totalScore;

    public void initializePlayer(String playerName, boolean playerStatus) 
    {
        this.playerName = playerName;
        this.playerStatus = playerStatus;
        this.totalScore =  9000;
    }

    public String getPlayerName() {
        return playerName;
    }
   
    public boolean isPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(boolean playerStatus) {
        this.playerStatus = playerStatus;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    
            
}



