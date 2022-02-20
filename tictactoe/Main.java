package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String cells = "_________";
        Affichage.showCells(cells);
        Scanner scanner = new Scanner(System.in);

        boolean play = true;
        char playerSymbol = 'X';
        while(play) {
            String playerY = scanner.next();
            String playerX = scanner.next();

            boolean canPlay = Analyzes.testInputPlayer(cells, playerX, playerY);
            if(canPlay) {
                int playerXInteger = Integer.parseInt(playerY);
                int playerYInteger = Integer.parseInt(playerX);
                String newCells = "";
                for (int i = 0; i < cells.length(); i++) {
                    if (i == (playerXInteger - 1) + (3 * (playerYInteger - 1))) {
                        newCells += playerSymbol;
                    } else {
                        newCells += cells.charAt(i);
                    }
                }
                Affichage.showCells(newCells);
                play = Analyzes.gameStatus(newCells);
                if(playerSymbol == 'X') {
                    playerSymbol = 'O';
                } else {
                    playerSymbol = 'X';
                }
                cells = newCells;
            }
        }
    }
}
