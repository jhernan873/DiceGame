package dicegame;

import java.util.Arrays;


public class Game
{

    public void nextRound()
    {
        Score.totalScore();
        RollDice roll = new RollDice();
        
        roll.createDice();
        roll.rollDice();
        Score.calculateScoring();

        System.out.println(Score.roundScore);


    }
}
