import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        //setting up a scanner for the player move input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] rps = {"r", "p", "s"};

            //computer will give a random number 0, 1, or 2
            String computerMove = rps[new Random().nextInt(rps.length)];

            String playerMove;

            //while loop for input validation
            while (true) {
                //asking for the player's move
                System.out.println("enter your move (r, p, or s): ");
                //gets the player's move
                playerMove = scanner.nextLine();
                //input validation
                if (playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
                    break;
                }
                System.out.println(playerMove + " is not a valid move");
            }
            System.out.println("computer's move is " + computerMove);

            //if statement - player and computer moves being equal outputs a tie
            if (playerMove.equals(computerMove)) {
                System.out.println("tie!");
            }
            //if statements to determine winner for each move possibility
            else if (playerMove.equals("r")) {
                if (computerMove.equals("p")) {
                    System.out.println("you lose!");
                } else if (computerMove.equals("s")) {
                    System.out.println("you win!");
                }
            } else if (playerMove.equals("p")) {
                if (computerMove.equals("r")) {
                    System.out.println("you win!");
                } else if (computerMove.equals("s")) {
                    System.out.println("you lose!");
                }
            } else if (playerMove.equals("s")) {
                if (computerMove.equals("p")) {
                    System.out.println("you win!");
                } else if (computerMove.equals("r")) {
                    System.out.println("you lose!");
                }
            }

            System.out.println("play again? (y/n): ");
            String playAgain = scanner.nextLine();

            //if statement - if input is not "y" then breaks while loop
            if (!playAgain.equals("y")){
                break;
            }

            scanner.close();

        }
    }

}
