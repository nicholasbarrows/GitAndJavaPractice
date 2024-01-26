package Games;

import java.util.Scanner;

/**
 * A simple, very fair, not rigged game of Rock Paper Scissors.
 * 
 * @author Nicholas Barrows
 * @version 01/24/2024
 */
public class RockPaperScissors implements Games {
    
    public void playGame() {
        Scanner keyboard = new Scanner(System.in);
        boolean quit_game = false;
        int times_lost = 0;
        int times_accused = 0;


        // Game loop
        while(!quit_game) {
            System.out.println("I'm assuming you know how this game works. It's Rock Paper Scissors. Let's play!");
            System.out.println("    -Type 0 to Quit");
            System.out.println("    -Type 1 for Rock");
            System.out.println("    -Type 2 for Paper");
            System.out.println("    -Type 3 for Scissors");
            if (times_lost >= 10) {
                System.out.println("    -Type 4 to accuse me of cheating");
            }
            System.out.print("Make a choice: ");
            try {
                int choice = Integer.parseInt(keyboard.nextLine());
                switch(choice) {
                    case 0:
                        System.out.printf("Bye! By the way, I won %d times and you won 0 times. Good game!\n", times_lost);
                        quit_game = true;
                        break;
                    case 1:
                        times_lost++;
                        System.out.printf("You picked Rock. I picked Paper. I win! I've won %d times!\n", times_lost);
                        break;
                    case 2:
                        times_lost++;
                        System.out.printf("You picked Paper. I picked Scissors. I win! I've won %d times!\n", times_lost);
                        break;
                    case 3:
                        times_lost++;
                        System.out.printf("You picked Scissors. I picked Rock. I win! I've won %d times!\n", times_lost);
                        break;
                    case 4:
                        if (times_lost < 10) {
                            throw new IllegalArgumentException("Invalid choice");
                        }
                        else {
                            times_accused++;
                            switch(times_accused) {
                                case 1:
                                    System.out.println("Haha, good one!");
                                    break;
                                case 2:
                                    System.out.println("That is a good one, but let's get back to the game.");
                                    break;
                                case 3:
                                    System.out.println("Okay now you're starting to wear this joke out.");
                                    break;
                                case 4:
                                    System.out.println("You are joking, right?");
                                    break;
                                case 5:
                                    System.out.println("You're serious about this? It's not my fault I'm so good at Rock Paper Scissors.");
                                    break;
                                case 6:
                                    System.out.println("Okay fine. If it makes you feel better, I'll let you win a round.");
                                    System.out.println("I'll pick Rock, okay? Could not be easier. Now, your turn.");
                                    System.out.println("    -Type 1 for Rock");
                                    System.out.println("    -Type 2 for Paper");
                                    System.out.println("    -Type 3 for Scissors");
                                    System.out.print("Make a choice: ");
                                    String new_choice = keyboard.nextLine();
                                    switch (new_choice) {
                                        case "1":
                                            System.out.println("I mean... you didn't fully lose... but you didn't win either, so...");
                                            break;
                                        case "2":
                                            System.out.println("See? This proves I don't cheat. You can win if you really try. Now, let's get back to business.");
                                            System.out.println("And no, this doesn't count as an actual win, but now you know you can do it since I've proven I don't cheat.");
                                            break;
                                        case "3":
                                            System.out.println("...moving on");
                                            break;
                                        default:
                                            System.out.println("That's not even a choice. Whatever, let's just move on.");
                                    }
                                    break;
                                case 7:
                                    System.out.println("Seriously? We already went over this, can we move on?");
                                    break;
                                case 8:
                                    System.out.println("Fine. I'm out of here. Have fun playing the game by yourself.");
                                    while(!quit_game) {
                                        System.out.println("    -Type 0 to Quit");
                                        System.out.println("    -Type 1 for Rock");
                                        System.out.println("    -Type 2 for Paper");
                                        System.out.println("    -Type 3 for Scissors");
                                        System.out.print("Make a choice: ");
                                        new_choice = keyboard.nextLine();
                                        if (new_choice.equals("0")) {
                                            quit_game = true;
                                        }
                                        else {
                                            System.out.println("...");
                                            System.out.println();
                                        }
                                    }
                                    break;
                            }
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid choice");
                    }
                }
            catch (IllegalArgumentException e) {
                times_lost++;
                System.out.printf("That's not an actual choice. That counts as win for me, by the way. That's %d wins for me.\n", times_lost);
            }
            // Put an empty line before starting a new round
            if (times_lost == -2147483648) {
                System.out.println("You somehow lost so many times you broke my score. Either that or you cheated to... let me win a lot more? Why? Either way, this is a good stopping point.");
                quit_game = true;
            }
            System.out.println();
        }
        keyboard.close();
    }
}