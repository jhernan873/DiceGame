package dicegame;

import java.util.*;


public class Game
        
{   Player player = new Player();
    RollDice roll = new RollDice();
    Scanner input = new Scanner(System.in);
    Score score = new Score(); 

    public void Intro()
    {
           
        System.out.printf("Welcome to The Dice Game. Here are the rules: You start with rolling six dice. Every turn you must keep at least one dice. You must have a 1 or a 5 to continue or else you\n"
                + "r turn is over. 1's are worth 100 points, and 5's are worth 50. If at any point you roll your dice and you don't get any points you 'zoughted' and your turn\n"
                + " is over. The exceptions to getting points besides in a 1 or a 5 are as follows. If you roll three 1's at once you get 1000 points, three\n"
                + " 2's is 200 points, three 3's is 300 points, three 4's is 400 points, three 5's is 500 points, and three 6's is 600 points. If you roll four\n"
                + "of the same number at once then you add that amount to the points. So four 5's for instance is 1000 points. 500 for the inital three dice, then \n"
                + "500 for the one extra 5. Five 5's would be 1500 points. If you roll 3 pair it's 1200 points. An example of this would be two 2's, two 3's, and two\n"
                + " 6's. A straight is worth 1500 points. A straight has to be 1-6 in one roll. If you happen to use all 6 of your dice, and they are all valid points\n"
                + " then you get to re-roll all 6 dice again and you keep your points. If you 'zought' though then you lose it all. If you get six of a kind of any number \n"
                + "in one roll then you automatically win the game! Once someone reaches 10,000 points everybody else gets one more turn \nto try and win and"
                + " pass their score. After the last round the person with the higest score wins. Have fun! \n\n");
                
        System.out.print("Choose number of players: ");       
        player.setPlayers(input.nextInt());      
       
        player.initializePlayer(player.getPlayers());
        
        System.out.printf("\n%30s \n\n", "Start!");
              
        roll.createDice();
        
        score.totalScore();
        
    }
    
    public void nextRound()
    {
        
        Score score = new Score();
       
        RollDice roll = new RollDice();
        
        roll.rollDice();

        score.displayRoundScore();
        
        roll.chooseDice();
        
        while(roll.getAddToTotal())
        {
            roll.rollDice();

            score.displayRoundScore();
        
            roll.chooseDice();
        
            roll.unlockDice();
        
            roll.rollDice();

            score.displayRoundScore();
        }
    }
}
