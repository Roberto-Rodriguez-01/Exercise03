import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Exercise03 {
    private static int computerScore = 0;
    private static int userScore = 0;

    public static void main(String[] args) {


        if(gameState == 0){
            fileCreate();
        }

        Scanner cin = new Scanner(System.in);

        while (true) {
            System.out.printf("What is your choice? \n %s \n %s \n %s \n %s \n %s \n %s ", "0: Rock", "1: Paper", "2: Scissors", "3: Spock", "4: Lizard", ": ");
            try {
                int userChoice = cin.nextInt();
                System.out.println();
                if (userChoice >= 0 && userChoice <= 4) {
                    whoWins(computer(), userChoice);
                } else {
                    System.out.printf("%d is not a choice", userChoice);
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.printf("That's not an int try again");
                System.out.println();
            }
        }
    }

    public static void fileChecker(){
        
    }

    public static void fileCreate() {
        try {
            File saveFile = new File("SaveFile.txt");
            Scanner myReader = new Scanner(saveFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readAndWriteFile(){

    }

    static String numberToName(int n) {
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

    public static int computer() {
        Random random = new Random();
        return (random.nextInt(5));
    }


    public static void score(int winner) {

        if (winner == 1) {
            userScore++;
        } else if (winner == 0) {
            computerScore++;
        }

        System.out.printf("Your score is :%d the Computers score is:%d \n", userScore, computerScore);
    }

    public static void whoWins(int computerChoice, int userChoice) {

        String usertonum = numberToName(userChoice);
        String comptonum = numberToName(computerChoice);

        int winner = 0;

        if (userChoice == computerChoice) {
            System.out.printf("You both tied, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);

        } else if (userChoice == 0 && (computerChoice == 2 || computerChoice == 4)) {
            if (computerChoice == 2) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;

            } else if (computerChoice == 4) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            }
        } else if (userChoice == 1 && (computerChoice == 0 || computerChoice == 3)) {
            if (computerChoice == 0) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            } else if (computerChoice == 3) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            }
        } else if (userChoice == 2 && (computerChoice == 1 || computerChoice == 4)) {
            if (computerChoice == 1) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            } else if (computerChoice == 4) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            }
        } else if (userChoice == 3 && (computerChoice == 0 || computerChoice == 2)) {
            if (computerChoice == 0) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            } else if (computerChoice == 2) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            }
        } else if (userChoice == 4 && (computerChoice == 1 || computerChoice == 3)) {
            if (computerChoice == 1) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            } else if (computerChoice == 3) {
                System.out.printf("You won, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
                winner = 1;
            }
        } else {
            System.out.printf("You lost, you had: \"%s\" and the computer had: \"%s\" \n", usertonum, comptonum);
            winner = 0;
        }
        score(winner);
    }

}
