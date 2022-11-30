import java.util.Scanner;

class RPS {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int rounds = 5;
		boolean running = true;
		int your_score = 0;
		int comp_score = 0;
		
		while(running) {
			System.out.println("Rock, Paper, or Scissors?");
			String guess = in.nextLine().toLowerCase().strip();
			
			Brain brain = new Brain();
			String computer = brain.getChoice();
			
			if(guess.equals(computer)) { // If both same choice, just go to new round
				System.out.println("You both chose " + guess + "!");
				System.out.println("Next Round!");
			} else { // Otherwise see which choice wins, update scores and rounds
				System.out.println("The computer chose " + computer + "!");
				--rounds;
				if(guess.equals("rock")) {
					if(computer.equals("paper")) {
						System.out.println("You lost this round!");
						++comp_score;
					} else if(computer.equals("scissors")) {
						System.out.println("You won this round!");
						++your_score;
					}
				} else if(guess.equals("paper")) {
					if(computer.equals("scissors")) {
						System.out.println("You lost this round!");
						++comp_score;
					} else if(computer.equals("rock")) {
						System.out.println("You won this round!");
						++your_score;
					}
				} else if(guess.equals("scissors")) {
					if(computer.equals("rock")) {
						System.out.println("You lost this round!");
						++comp_score;
					} else if(computer.equals("paper")) {
						System.out.println("You won this round!");
						++your_score;
					}
				}
			}
			
			// Check end-game conditions
			if(rounds == 0 || your_score >2 || comp_score > 2) {
				running = false;
			}
		} // End while
		
		System.out.println("Your score: " + your_score);
		System.out.println("Computer score: " + comp_score);
			
		if(your_score > comp_score) {
			System.out.println("You win!");
			
		} else {
			System.out.println("You loose!");
		}
		
	} // End main
} // End class Game

class Brain {
	private String[] choices = {"rock", "paper", "scissors"};
	private String choice;
	
	public Brain() {
		int index = (int)(Math.random() * 3);
		choice = choices[index];
	}
	
	public String getChoice() {
		return choice;
	}
}