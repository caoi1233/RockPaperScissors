import java.util.*;

public class RPS {

	public static void main (String []args) {
	
		Scanner sc = new Scanner(System.in);

		int myscore = 0; 
		int computerscore = 0;
	
		//boolean to check if the programme will run through
		// this statement
		boolean willRun = true;
		//Use a selection of statements to see who wins
	
		while(willRun) {
			//The computer begins the game
			//Instead of RPS you can put in hangman..?
			System.out.println("Rock, paper or scissors?");
			String guess = sc.nextLine().toLowerCase();
			if(!(guess.equals("rock") || guess.equals("paper") || guess.equals("scissors"))) {
				System.out.println("You entered invalid keyword " + guess);
				//If it doesn't equal any of these stop the game!
				//break;
			}
			
			//Brain of computer
			Brain brain = new Brain();
			String computer = brain.getChoice();
			//Selection of choices in RPS.
			//A draw, or a win for one player and a loss for the other. 
			//Six outcomes
		
			if(guess.equals(computer)) {
				System.out.println("There is a draw between the players");
				//Next round
				System.out.println("Next Round");
			}
			else {
				//See which choice gets the guess correct
				System.out.println("The computer chose " + computer + "!");
			}
			
			
			if(guess.equals("rock")) {
				System.out.println("The user has chosen rock");
				if(computer.equals("paper")) {
					//System.out.println("You have lost a point");
					computerscore++;
					System.out.println("Here is computer score: " + computerscore);
				}
				else if(computer.equals("scissors")) {
					System.out.println("You have gotten one point");
					myscore++;
					System.out.println("Here is your score: " + myscore);
				}
			}
			else if(guess.equals("paper")) {
				System.out.println("The user has chosen  paper");
				if(computer.equals("rock")) {
					System.out.println("You have gained a point");
					myscore++;
					System.out.println("Here is your score: " + myscore);
				}
				else if(computer.equals("scissors")) {
					//	System.out.println("You have lost a point");
					computerscore++;
					System.out.println("Here is computer score: " + computerscore);
				}
			}
			else if(guess.equals("scissors")) {
				System.out.println("The user has chosen scissors");
				if(computer.equals("rock")) {
					//System.out.println("You have lost a point");
					computerscore++;
					System.out.println("Here is computer score:" + computerscore);
				}	
				else if(computer.equals("paper")) {
					System.out.println("You have gained a point");				
					myscore++;
					System.out.println("Here is your score: " + myscore);
				}
			}
			
			//We need a condition to check if the game doesn't run
			//We need a condition to check if computer or the user reaches 5.
			if(computerscore == 5 || myscore == 5) {
				willRun = false;
				System.out.println("The game has ended");
			}
			
		} // End while
		
		System.out.println("Your score: " + myscore);
		System.out.println("Computer score: " + computerscore);
			
		if(myscore == 5) {
			System.out.println("You win!");
		} else {
			System.out.println("You lose!");
		}
	}
}
	
//Now we to define the Brain class
class Brain {
	//Within the brain method, we have three choices. 
	//Rock, paper and scissors.
	private String [] choices = {"rock", "paper", "scissors"};
	private String choice;
	
	public Brain() {
		//The math.random() returns a floating point integer between 0 and 1.
		int index = (int) (Math.random() * 3);
		choice = choices[index];
		//This line will take a variable in choices by random
	}
	
	//Get method needs to be defined.	
	public String getChoice() {
		return choice;
	}
}

	



