import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Exercise03 {

	public static void main(String[] args) {

		int computerScore = 0;
		int userScore = 0;

		Scanner cin = new Scanner(System.in);
		System.out.printf("What is your choice? \n %s \n %s \n %s \n %s \n %s", "1: Rock", "2: Paper", "3: Scissors", "4: Spock", "5: Lizard");
		int userChoice = cin.nextInt();
		whoWins(computer(), userChoice);
	}

	public static void fileRead() {
		try{
			File saveFile = new File("Save.txt");
			Scanner myReader = new Scanner(saveFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
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
		int computerChoice = random.nextInt(1 - 6);
		return (computerChoice);
	}

	public static void whoWins(int computerChoice, int userChoice) {

		String usernotnum = numberToName(userChoice);
		String compnotnum = numberToName(computerChoice);


		if (userChoice == computerChoice) {
			System.out.printf("You both tied, you had: %s and the computer had: %s", usernotnum, compnotnum);
		} else if (userChoice == 0 && (computerChoice == 2 || computerChoice == 4)) {
			if (computerChoice == 2) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			} else if (computerChoice == 4) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			}
		} else if (userChoice == 1 && (computerChoice == 0 || computerChoice == 3)) {
			if (computerChoice == 0) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			} else if (computerChoice == 3) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			}
		} else if (userChoice == 2 && (computerChoice == 1 || computerChoice == 4)) {
			if (computerChoice == 1) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			} else if (computerChoice == 4) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			}
		} else if (userChoice == 3 && (computerChoice == 0 || computerChoice == 2)) {
			if (computerChoice == 0) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			} else if (computerChoice == 2) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			}
		} else if (userChoice == 4 && (computerChoice == 1 || computerChoice == 3)) {
			if (computerChoice == 1) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			} else if (computerChoice == 3) {
				System.out.printf("You won, you had: %s and the computer had: %s", usernotnum, compnotnum);
			}
		} else {
			System.out.printf("You lost, you had: %s and the computer had: %s", usernotnum, compnotnum);
		}
	}

}
