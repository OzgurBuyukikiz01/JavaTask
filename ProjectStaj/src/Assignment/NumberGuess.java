package Assignment;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int randomValue = random.nextInt(100) + 1;
        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("*** Guess the random number between 1 and 100: ***");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
            int guessedNum = scan.nextInt();
            attempts++;

            if (guessedNum == randomValue) {
                System.out.println("Good Job! You guessed the correct number: " + randomValue);
                break;
            } else if (guessedNum > randomValue) {
                System.out.println("Your number is too high.");
            } else if (guessedNum < randomValue) {
                System.out.println("Your number is too low.");
            }

            if (attempts == maxAttempts) {
                System.out.println("You've used all your attempts. The correct number was: " + randomValue);
            }
        }

        scan.close();
    }
}
