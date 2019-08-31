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


        //to replace the do loop of randomness I will start with an aimed
        do {
            weapon = random.nextInt(6) + 1;
            location = random.nextInt(10) + 1;
            murder = random.nextInt(6) + 1;
            solution = jack.checkAnswer(weapon, location, murder);
        } while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // shit is broken
        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution ");

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

        int testSolution, testMurder = 0, testWeapon=0, testLocation=0;
        AssistantJack newJack = new AssistantJack(answerSet);
        Theory newAnswer;

        System.out.println("This is my New Jack system.");
        do {
            for (int i = 0; i < 6 ; i++)
            {
                testWeapon = i;
                testMurder = i;
                testLocation = i;
            }

            testSolution = newJack.checkAnswer(testWeapon, testLocation, testMurder);
        } while (solution < 3);

        newAnswer = new Theory(weapon, location, murder);
        System.out.println("Total Checks = " + newJack.getTimesAsked() + ", Solution ");
    }

}