package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class Game {

    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    private final static String[] basicMoveOptions = {"rock", "paper", "scissors"};

    private final User user;
    private final String[] moveOptions;
    private String userInput;
    private Move userMove;
    private Move computerMove;

    public Game(String userName, String gameOptions) {
        this.user = new User(userName);
        this.moveOptions = "".equals(gameOptions) ? basicMoveOptions : gameOptions.split(",");
    }

    public void run() {
        do {
            userInput = scanner.next();
        } while (response());
    }

    protected boolean response() {
        if (Move.isExist(userInput)) {
            userMove = new Move(userInput);
            computerMove = new Move(moveOptions[random.nextInt(moveOptions.length)]);
            System.out.println(outcome());
            return true;
        } else if (userInput.equals("!exit")) {
            System.out.println("Bye!");
            return false;
        } else if (userInput.equals("!rating")) {
            System.out.println("Your rating: " + user.getScore());
            return true;
        } else {
            System.out.println("Invalid input");
            return true;
        }
    }

    protected String outcome() {
        String draw = "There is a draw (%s)";
        String userWin = "Well done. The computer chose %s and failed";
        String userLoss = "Sorry, but the computer chose %s";

        if (computerMove.matchWinList(userMove)) {
            return String.format(userLoss, computerMove.getMove());
        } else if (userMove.matchWinList(computerMove)) {
            user.setScore(user.getScore() + 100);
            return String.format(userWin, computerMove.getMove());
        } else {
            user.setScore(user.getScore() + 50);
            return String.format(draw, userMove.getMove());
        }
    }

}
