import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exercise03 {

    //used to keep a running score of the game also get updated once the player leaves.
    private static int userScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        fileChecker();

        while (true) {
            try {
                System.out.printf("What is your choice? \n %s \n %s \n %s \n %s \n %s \n %s \n %s \n %s", "0: Rock", "1: Paper", "2: Scissors", "3: Spock", "4: Lizard", "5: Save and Exit", "99: Reset Your game", ": ");
                int userChoice = cin.nextInt();
                System.out.println();
                if (userChoice >= 0 && userChoice <= 4) {
                    whoWins(computer(), userChoice);
                } else if (userChoice == 5) {
                    savingGame();
                } else if (userChoice == 99) {
                    fileCreate();
                    System.exit(0);
                    return;
                } else {
                    System.out.printf("%d is not a choice", userChoice);
                    System.out.println();
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("That's not an int try again");
                cin.nextLine();
                System.out.println();
            }
        }
    }

    public static void fileChecker() {
        //checks if file exists and if it doesn't exist it will go to the file create method
        File tmpDir = new File("SaveFile.txt");
        boolean exists = tmpDir.exists();

        if (!exists) {
            fileCreate();
        } else {
            readData();
        }
    }

    public static void fileCreate() {
        //creates a new file with default values 0, 0
        int startingUserValue = 0;
        int startingComputerValue = 0;

        try {
            PrintWriter myWriter = new PrintWriter(new FileWriter("SaveFile.txt"));
            myWriter.println(startingUserValue);
            myWriter.println(startingComputerValue);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void savingGame() {
        //when the user requests to save the game, this will write the current values to the file then close
        try {
            PrintWriter myWriter = new PrintWriter(new FileWriter("SaveFile.txt"));

            myWriter.println(userScore);
            myWriter.println(computerScore);
            myWriter.close();
            System.exit(0);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readData() {
        //when the user has the SaveFile.txt this will read it and set the values to the game
        String[] storage = new String[2];
        try {
            File file = new File("SaveFile.txt");

            Scanner myReader = new Scanner(file);
            for (int i = 0; i <= 1; ) {
                storage[i] = myReader.next();
                i++;
            }
            userScore = Integer.parseInt(storage[0]);
            computerScore = Integer.parseInt(storage[1]);
            System.out.printf("In your Previous game the score was :%d and the Computers score was:%d \n", userScore, computerScore);
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static int computer() {
        //this picks a random number between 0 - 5
        Random random = new Random();
        return (random.nextInt(6));
    }

    static String numberToName(int n) {
        //converts the users input (int) to a String
        switch (n) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            case 3:
                return "spock";
            case 4:
                return "lizard";
            default:
                return "Not defined";
        }
    }

    public static void score(int winner) {
        //adds point to the winner of each round then prints it out
        if (winner == 1) {
            userScore++;
        } else if (winner == 0) {
            computerScore++;
        }

        System.out.printf("Your score is :%d the Computers score is:%d \n", userScore, computerScore);
        System.out.println();
    }

    public static void whoWins(int computerChoice, int userChoice) {
        //checks who won each round
        String userToNum = numberToName(userChoice);
        String compToNum = numberToName(computerChoice);

        //set winner to
        int winner;
        if (userChoice == computerChoice) {
            System.out.printf("You both tied, you had: \"%s\" and the computer had: \"%s\" \n", userToNum, compToNum);
            //set winner to two so the score method knows it was a tie
            winner = 2;

        } else if (userChoice == 0 && (computerChoice == 2 || computerChoice == 4)) {
            System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", userToNum, compToNum);
            winner = 1;
        } else if (userChoice == 1 && (computerChoice == 0 || computerChoice == 3)) {
            System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", userToNum, compToNum);
            winner = 1;
        } else if (userChoice == 2 && (computerChoice == 1 || computerChoice == 4)) {
            System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", userToNum, compToNum);
            winner = 1;
        } else if (userChoice == 3 && (computerChoice == 0 || computerChoice == 2)) {
            System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", userToNum, compToNum);
            winner = 1;
        } else if (userChoice == 4 && (computerChoice == 1 || computerChoice == 3)) {
            System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", userToNum, compToNum);
            winner = 1;
        } else {
            System.out.printf("You lost, you had: \"%s\" and the computer had: \"%s\" \n", userToNum, compToNum);
            winner = 0;
        }
        score(winner);

    }
}
