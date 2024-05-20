package GuessingNumber;
import java.util.Random;
import java.util.Scanner;

class RandomNumberGenerator {
    private Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int generateRandomNumber(int bound) {
        return random.nextInt(bound) + 1;
    }
}

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int maxAttempts = 10;
        int attempts = 0;
        int remainingAttempts = maxAttempts;
        int randomNumber = randomNumberGenerator.generateRandomNumber(100); 

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Can you guess it?");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + " - Enter your guess: ");
            int guess = scanner.nextInt();
            scanner.nextLine();
            
            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the number correctly: " + randomNumber);
                break;
            }
            
            attempts++;
            remainingAttempts--;
            System.out.println("Remaining attempts: " + remainingAttempts);
        }
        if(attempts==maxAttempts) {
        	System.out.println("Sorry,you have reached the maximum number of attempts.");
        	System.out.println("The correct number was:"+randomNumber);
        }scanner.close();
        
}
    }


