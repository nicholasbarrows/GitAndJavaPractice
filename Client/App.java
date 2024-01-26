package Client;

import java.util.Scanner;

import Games.Games;
import Games.NumberGuess;
import Games.RockPaperScissors;

public class App {
    public static void main(String[] args) {
        Games chosen_game = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Pick a game, we have plenty of amazing games to choose from.");
        while (chosen_game == null) {
            System.out.println("1: Number Guessing Game");
            System.out.println("2: Rock Paper Scissors");
            System.out.print("Choose a game: ");
            String input = keyboard.nextLine();
            try {
                int choice = Integer.parseInt(input);
                switch(choice) {
                    case 1:
                        chosen_game = new NumberGuess();
                        break;
                    case 2:
                        chosen_game = new RockPaperScissors();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid choice");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Enter a number that is either 1 or 2.");
            }
        }
        chosen_game.playGame();
        keyboard.close();
    }
}
