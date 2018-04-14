package dicegame;

import java.util.*;


public class RollDice
{

    public static ArrayList<Integer> playingSet = new ArrayList<>();
    public static ArrayList<Integer> scoringSet = new ArrayList<>();
    private boolean keepArray[] = new boolean[6];
    private String numbers = null;    
    private int[] chosenNumber;
    private boolean addToTotal;
    
    Scanner input = new Scanner(System.in);
    Player player = new Player();
    Score score = new Score();
        
    public void createDice()     
    {
        for(int x = 0;x < 6; x++)
        {
            playingSet.add(x, 0);
            scoringSet.add(x, 0);
        }   
    }
    
    public void rollDice()
    {       
        Random rand = new Random();
       
        for(int x = 0; x < 6; x++)
        {
            if(keepArray[x])
            {
                scoringSet.set(x, playingSet.get(x));
            }
            else
            {
                playingSet.set(x, rand.nextInt(6) + 1);
                scoringSet.set(x, playingSet.get(x));
                System.out.printf("Die #%d: %d\n\n", x + 1, scoringSet.get(x));
            }
        }
    }
    
    public void chooseDice()
    {
        String keepScore;
        boolean addToTotal = false;
             
        for(int x = 0; x < 1; x++)
        {
            System.out.print("Would you like to 're-roll' or 'add' to score? ");
            keepScore = input.nextLine();
            System.out.println();
            
            switch(keepScore)
            {
                case "re-roll": addToTotal = false;
                                break;
                case "add":     addToTotal = true;
                                break;
                default:        x--;
                                break;
            }
            
            if(addToTotal)
            {
                for(int z = 0; z < player.getPlayers(); z++)
                {
                    if(player.getActivePlayer(z));
                    {
                    Score.totalScore[z] = score.getRoundScore();
                    score.setRoundScore(0);
                    }
                }
            }
            else
            {
            System.out.print("Which dice numbers would you like to keep? ");
            numbers = input.nextLine();
            if(numbers.equals(""))
            {
            }
            else
            {
            String[] numberss = numbers.split(" ");
            chosenNumber = new int[numberss.length];
            
            for (int i = 0; i < chosenNumber.length; i++)
            {
                chosenNumber[i] = Integer.parseInt(numberss[i]);
            }
            for (int i = 0; i < numberss.length; i++)
            {
                if (chosenNumber[i] == 1)
                {
                    keepArray[0] = true;
                }
                if (chosenNumber[i] == 2)
                {
                    keepArray[1] = true;
                }
                if (chosenNumber[i] == 3)
                {
                    keepArray[2] = true;
                }
                if (chosenNumber[i] == 4)
                {
                    keepArray[3] = true;
                }
                if (chosenNumber[i] == 5)
                {
                    keepArray[4] = true;
                }
                if (chosenNumber[i] == 6)
                {
                    keepArray[5] = true;
                }
            }
        }    
            }
        }
     }

        public void unlockDice()
        {
        for(int p = 0; p < 6; p++)
        {
            if(keepArray[p])
            {
            for(int j = 0; j < chosenNumber.length; j++)
            {
                System.out.printf("Would you like to unlock dice #%d? Type 'y' or 'n'. ", chosenNumber[j]);
                String unlockDice = input.nextLine();

                    for(int g = 0; g < 1; g++)
                    {
                        switch(unlockDice.toLowerCase())
                        {
                            case "y":   for (int f = 0; f < chosenNumber.length; f++)
                                        {
                                            if (chosenNumber[j] == 1)
                                            {
                                                keepArray[0] = false;
                                            }
                                            if (chosenNumber[j] == 2)
                                            {
                                                keepArray[1] = false;
                                            }
                                            if (chosenNumber[j] == 3)
                                            {
                                                keepArray[2] = false;
                                            }
                                            if (chosenNumber[j] == 4)
                                            {
                                                keepArray[3] = false;
                                            }
                                            if (chosenNumber[j] == 5)
                                            {
                                                keepArray[4] = false;
                                            }
                                            if (chosenNumber[j] == 6)
                                            {
                                                keepArray[5] = false;
                                            }
                                        }
                                        break;
                            case "n":   break;
                            default:    System.out.println("Invalid entry. Please try again.");
                                        g--;
                                        break;
                        }
                    }        
                p += 6;        
                }
                
            }
        }
    }

        public boolean getAddToTotal()
        {
            return addToTotal;
        }
        
}           
          