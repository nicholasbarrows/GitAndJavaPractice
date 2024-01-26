package Games;

import java.util.Random;
import java.util.Scanner;

/**
 * A fun game with hours of content included.
 * 
 * @author Nicholas Barrows
 * @version 01/24/2024
 */
public class NumberGuess implements Games {


     /**
     * Plays the greatest designed game ever made
     */
    public void playGame() {

        // Initalize the random and the input
        Random rand = new Random();
        Scanner keyboard = new Scanner(System.in);
        boolean quit_game = false;
        int max_value = 1000000;

        System.out.println("This is a great game! It's very well made, and very fun. I'll think of a number between 1 and a million, you just guess! If you guess right, you win!");

        // Game loop
        while (!quit_game) {
            int random_number = rand.nextInt(max_value) + 1;

            System.out.printf("I'm thinking of a number between 1 and %d. Take a guess what it is!\n", max_value);
            System.out.print("Guess a number (press 0 to quit): ");

            try {

                int guessed_number = Integer.parseInt(keyboard.nextLine());

                if (guessed_number == 0) {
                    System.out.println("That means I win, but okay.");
                    quit_game = true;
                }

                if (guessed_number == random_number) {
                    System.out.println("You win! Somehow...");
                    System.out.println("I guess you can go now.");
                    quit_game = true;
                }
                else if (guessed_number > 0 && guessed_number <= max_value) {
                    System.out.printf("Wrong! My number was %d, better luck next time!\n", random_number);
                }
                else if (guessed_number != 0)
                {
                    if (max_value < 2147000000) {
                        System.out.printf("There's %d options, is that not enough? Do you need more? I'll add 1,000,000 more just to be sure.\n", max_value);
                        max_value = max_value + 1_000_000;
                    }
                    else if (max_value == 2147000000) {
                        System.out.println("How did you even get this far? I can't even increase it anymore after this.");
                        max_value = 2147483647;
                    }
                    else {
                        System.out.println("Please, just make an actual guess.");
                    }
                    
                }
                
            }
            catch (IllegalArgumentException e) {
                System.out.println("That's not even a number. Or maybe it is, but it's above 2,147,483,647. Regardless, this is a really good game, why are you trying to ruin it?");
                System.out.println("Let's try again.");
            }
            // Put an empty line before starting a new round
            System.out.println();  
        }
        keyboard.close();
    }
}