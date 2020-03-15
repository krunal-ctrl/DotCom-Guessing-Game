import java.util.ArrayList;
public class DotComBust {
	private GameHelper helper =new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses=0;
	
	private void setUpGame() {
		DotCom one=new DotCom();
		one.setName("pets.com");
		DotCom two=new DotCom();
		two.setName("eToys.com");
		DotCom three=new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("your goal is to sink three dot coms.");
		System.out.println("pets.com, eToys.com, Go2.com");
		System.out.println("sink all in very few number");
		
		for(DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while(!dotComsList.isEmpty()) {
			String userGuess=helper.getUserInput("enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result="miss";
		for(DotCom dotComToTest : dotComsList) {
			result=dotComToTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if(result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("all dot Coms are dead!");
		if(numOfGuesses<=18) {
			System.out.println("it only took you "+numOfGuesses+" guesses.");
		}else {
			System.out.println("fishes are dancing with your "+numOfGuesses+" options");
		}
	}
	
	public static void main(String[] args) {
		DotComBust game =new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}

}




















