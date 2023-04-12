package rockpaperscissors;

import java.util.Objects;

public class Move {
    final static String[] moveList = {"rock", "fire", "scissors", "snake", "human", "tree", "wolf",
            "sponge", "paper", "air", "water", "dragon", "devil", "lightning", "gun"};

    private String move;
    private final String[] winAgainst;

    public Move(String move) {
        this.move = move;
        this.winAgainst = this.getWinList();
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String[] getWinAgainst() {
        return this.winAgainst;
    }

    public static boolean isExist(String userInput) {
        for (int i = 0; i < moveList.length; i++) {
            if (Objects.equals(moveList[i], userInput)) {
                return true;
            }
        }
        return false;
    }

    private int findIndex() {
        for (int i = 0; i < moveList.length; i++) {
            if (Objects.equals(moveList[i], this.move)) {
                return i;
            }
        }
        return -1;
    }

    private String[] getWinList() {
        String[] winList = new String[7];
        for (int i = 0; i < 7; i++) {
            winList[i] = moveList[(this.findIndex() + i + 1) % 15];
        }
        return winList;
    }

    public boolean matchWinList(Move move) {
        for (String str : this.winAgainst) {
            if (str.equals(move.getMove())) {
                return true;
            }
        }
        return false;
    }

}
