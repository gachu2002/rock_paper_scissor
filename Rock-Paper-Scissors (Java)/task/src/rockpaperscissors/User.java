package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {
    private final String name;
    private int score;

    private static int readFile(String name) {
        File file = new File(".\\rating.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                if (scanner.next().equals(name)) {
                    return scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println();
        }
        return 0;
    }

    public User(String name) {
        this.name = name;
        this.score = readFile(name);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
