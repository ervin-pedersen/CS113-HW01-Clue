package edu.miracosta.cs113;

/**
 * RandomClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries.  RandomClue is ONE solution to the problem,
 * where a set of random numbers is generated every attempt until all three
 * random numbers match the solution from the AssistantJack object.
 *
 * This is a sample solution, a driver using random number implementation.
 * You can use this file as a guide to create your own SEPARATE driver for
 * your implementation that can solve it in <= 20 times consistently.
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;
import model.TheoryItem;

import static java.lang.Boolean.FALSE;

public class atempt2Solver {

    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * DO
     *      weapon = random int between 1 and 6
     *      location = random int between 1 and 10
     *      murder = random int between 1 and 6
     *      solution = jack.checkAnswer(weapon, location, murder)
     * WHILE solution != 0
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        //used to debug code
        //ArrayList<Theory> alreadyTried = new ArrayList<>();
        //place to keep track of already tried combinations
        ArrayList<Integer> alreadyTesetedWeapon = new ArrayList<>();
        ArrayList<Integer> alreadyTesetedMurder = new ArrayList<>();
        ArrayList<Integer> alreadyTesetedLocation = new ArrayList<>();

        // INPUT
        System.out.println("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        //To start look at the arrayList if it has things in it, if it doesnt start at a random three, if it does have check
        //to make sure it doesn't reuse previous guess.
        weapon = random.nextInt(6) + 1;
        location = random.nextInt(10) + 1;
        murder = random.nextInt(6) + 1;
        solution = jack.checkAnswer(weapon, location, murder);
        answer = new Theory(weapon, location, murder);
        //alreadyTried.add(answer);

        TheoryItem used = new TheoryItem();

        do
            {
                if (solution == 0)
                {
                    //0 if all three are correct
                    System.out.println("ding winner!");
                }
                else if (solution == 3)
                {
                    int oldMurder = murder;
                    murder = random.nextInt(6) +1;
                    if (oldMurder == murder )
                    {
                        murder = random.nextInt(6) +1;
                    }

                    //while loop makes it so we dont re-use a number that has failed, and kicks out a random number
                    //that has not been used
                   while (alreadyTesetedMurder.contains(murder))
                    {
                      murder = random.nextInt(6) +1;
                    }
                    //3 if the person is incorrect.
                    //weapon and location are correct
                    //System.out.println("Solution = 3 reroll murder value and dont use already guessed");


                    solution = jack.checkAnswer(weapon, location, murder);
                    answer = new Theory(weapon, location, murder);
                    //alreadyTried.add(answer);
                    alreadyTesetedMurder.add(murder);

                }
                else if(solution == 2)
                {
                    int oldLocation = location;
                    location = random.nextInt(10) +1;
                    if (oldLocation == location )
                    {
                        location = random.nextInt(10) +1;
                    }
                    while (alreadyTesetedLocation.contains(location))
                    {
                        location = random.nextInt(10)+1;
                    }
                    //2 if the location is incorrect
                    //could mean 2 or more are incorrect
                    //weapon and person are correct
                    //System.out.println("Solution = 2 reroll location");


                    solution = jack.checkAnswer(weapon, location, murder);
                    answer = new Theory(weapon, location, murder);
                    //alreadyTried.add(answer);
                    alreadyTesetedLocation.add(location);
                }
                else if (solution == 1)
                {
                    int oldWeapon = weapon;
                    weapon = random.nextInt(6) +1;
                    if (oldWeapon == weapon )
                    {
                        weapon = random.nextInt(6) +1;
                    }
                    while (alreadyTesetedWeapon.contains(weapon))
                    {
                        weapon = random.nextInt(6)+1;
                    }
                    //1 if the weapon is incorrect
                    //this means person and location are correct
                    //System.out.println("Solution = 1 rerolling weapon");

                    solution = jack.checkAnswer(weapon, location, murder);
                    answer = new Theory(weapon, location, murder);
                    //alreadyTried.add(answer);
                    alreadyTesetedWeapon.add(weapon);
                    //look to the arraylist so we don't use a guess on a weapon we have already guessed.
                    // for (alreadyTried : .)
                }
                else
                {
                    //1 2 3 if more than one item is wrong
                    System.out.println("Something went really, really wrong");
                }
            }while (solution != 0);



        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);
        //to see how big my arraylist is
        //System.out.println("AL size is " + alreadyTried.size());

        //alreadyTried.forEach((n) -> System.out.println(n));



        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}