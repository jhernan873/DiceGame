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
public class Game 
{

    private int numPlayers;
    private ArrayList<Player> roster = new ArrayList<>();
    private ArrayList<Integer> chosenNumberList = new ArrayList<>();
    private int[] chosenNumber;
    private int[] roundNumbers;
    private  String numbers = null;
    private boolean possibleWinner = false;
       
    Dice dice = new Dice();
    Score score = new Score();
    Scanner in = new Scanner(System.in);
    
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
            playerSetup(in.nextInt());
            System.out.println("");
            
            totalScore();
        
    }
        public void playerSetup(int numPlayers)
    {
        this.numPlayers = numPlayers;
        
        for(int x = 0; x < numPlayers; x++)
            {   
                if(x == 0)
                {
                    Player player = new Player();
                    roster.add(x, player);
                    in.nextLine();
                    System.out.printf("Type player%d's name: ", x + 1);
                    roster.get(x).initializePlayer(in.nextLine(), true);
                    System.out.println("");
                }
                else
                {
                    Player player = new Player();
                    roster.add(x, player);
                    System.out.printf("Type player%d's name: ", x + 1);
                    roster.get(x).initializePlayer(in.nextLine(), false);
                    System.out.println("");
                }
            }
   
    }
    
    public void nextRound()
    {
 
        while(!possibleWinner)
        {
            for(int x = 0; x < numPlayers; x++) 
            {
                if(roster.get(x).isPlayerStatus())
                {
                    while(!dice.isAddToTotal())
                    {
                        rollDice();
                        chooseDice();
                    }
                }
            }
        }
    }  
    
    public int findActivePlayer()
    {
        int result = 0;
                
        for(int r = 0; r < numPlayers; r++)
        {
            if(r <= numPlayers)
            {
                if(roster.get(r).isPlayerStatus())
                {
                    result = r;   
                }
            }
        }
        
        return result;
    
    }
    
    public void totalScore()
    {
        System.out.printf("Score: \n\n");

        for (int x = 0; x < numPlayers; x++)
        {
            System.out.printf("%10s - %d\n\n", roster.get(x).getPlayerName(), roster.get(x).getTotalScore());
        }
    }

    public void displayRoundScore()
    {

        System.out.printf("Max Score: %d\n\n", score.calculateScoring(dice.getScoringSet()));

    }

    public void rollDice()
    {       
        Random rand = new Random();
       
        int activePlayer = findActivePlayer();
        
        for(int x = 0; x < 6; x++)
        {
            if(dice.getKeepArray(x))
            {

            }
            else
            {
                dice.setPlayingSet(x, rand.nextInt(6) + 1);
                System.out.printf("%s's Dice - #%d: %d\n\n",roster.get(findActivePlayer()).getPlayerName(), x + 1, dice.getPlayingSet(x));
            }
        }
        
        displayRoundScore();
        
    }
    
    public void chooseDice()
    {
        
        if(dice.chooseDice())
           {
                roster.get(findActivePlayer()).setTotalScore(roster.get(findActivePlayer()).getTotalScore() + score.getRoundScore());
                score.setRoundScore(0);
                getPossibleWinner();
                dice.setAddToTotal(false);
                totalScore();
                nextPlayer();
                
                for(int x = 0; x < 6; x++)
                {
                    dice.setKeepArray(x, false);
                }
                
           }
           else
           {
                
                System.out.print("Which dice numbers would you like to keep? ");
                numbers = in.nextLine();

                
                String[] numberss = numbers.split(" ");
                chosenNumber = new int[numberss.length];
                roundNumbers = new int[numberss.length];
          
               if(numbers.equals(""))
               {
               }
               else
               {
                   
                   
                   for (int i = 0; i < chosenNumber.length; i++)
                   {
                       chosenNumber[i] = Integer.parseInt(numberss[i]);
                       roundNumbers[i] = chosenNumber[i];
                   }
                   for (int i = 0; i < numberss.length; i++)
                   {
                       roundNumbers[i] = dice.getPlayingSet(chosenNumber[i] - 1); 
                       
                       if (chosenNumber[i] == 1)
                       {
                           dice.setKeepArray(0, true);
                       }
                       if (chosenNumber[i] == 2)
                       {
                            dice.setKeepArray(1, true);
                       }
                       if (chosenNumber[i] == 3)
                       {
                           dice.setKeepArray(2, true);
                       }
                       if (chosenNumber[i] == 4)
                       {
                           dice.setKeepArray(3, true);
                       }
                       if (chosenNumber[i] == 5)
                       {
                           dice.setKeepArray(4, true);
                       }
                       if (chosenNumber[i] == 6)
                       {
                           dice.setKeepArray(5, true);
                       }
                       
                    }
                   
                   score.setRoundScore(score.calculateScoring(changeChosenNumber(roundNumbers)));

                } 
               

               
           }
       }
    
    public void nextPlayer()
    {
        int active = findActivePlayer();
        
        if(active == numPlayers - 1)
        {
            roster.get(active).setPlayerStatus(false);
            roster.get(0).setPlayerStatus(true);
        }
        else
        {
            roster.get(active).setPlayerStatus(false);
            roster.get(active + 1).setPlayerStatus(true);
        }
    }
    
    public ArrayList<Integer> changeChosenNumber(int[] chosenNumber)
    {
        for(int x = 0; x < chosenNumber.length; x++)
        {
            chosenNumberList.add(x);
            chosenNumberList.set(x, chosenNumber[x]);
        }
        
        return chosenNumberList;
    }
    
    public boolean getPossibleWinner()        
    {
        for(int x = 0; x < numPlayers; x++)
        {
            if(roster.get(x).getTotalScore() >= 10000)
            {
                possibleWinner = true;
            }
        }
        
        return possibleWinner;
    }
}
