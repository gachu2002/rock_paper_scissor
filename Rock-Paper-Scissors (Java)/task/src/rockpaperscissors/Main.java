package rockpaperscissors;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName);
        String gameOptions = scanner.nextLine();
        Game game = new Game(userName, gameOptions);
        System.out.println("Okay, let's start");
        game.run();
    }

}
