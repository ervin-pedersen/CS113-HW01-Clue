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

import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;

public class ervinClueSolver {

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

        // INPUT
        System.out.println("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);
        weapon = 0;
        location = 1;
        murder = 1;
        int[] weapons = {1,2,3,4,5,6};
        int[] locations = {1,2,3,4,5,6,7,8,9,10};
        int[] murders = {1,2,3,4,5,6};
        int i, j, k;
        solution = 3;
        for(i = 1;i < 7;i++)
        {   if (solution == 0)
            break;
            weapon = i;
            for(j = 1;j<11; j++)
            {   if (solution == 0)
                break;
                location = j;
                for(k=1;k<7;k++)
                {
                    murder = k;
                    solution = jack.checkAnswer(i, j, k);
                    if (solution == 3) {
                        //System.out.println("Solution = 3");
                    } else if (solution == 2) {
                        //System.out.println("Solution = 2");
                    } else if (solution == 1) {
                        //System.out.println("Solution = 1");
                    } else if (solution == 0)
                        {
                        System.out.println("Ding Winner!");

                        break;
                        }
                    else
                    {
                        System.out.println("Something went wrong");
                    }

                }


            }

            //break;
            }
        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}