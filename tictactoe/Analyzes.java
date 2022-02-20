package tictactoe;

import java.util.regex.Pattern;

public class Analyzes {

    public static boolean testInputPlayer(String cells, String playerX, String playerY) {
        boolean canPlay = false;
        //if player input are number
        if (playerX.matches("[0-9]") && playerY.matches("[0-9]")) {
            //Coordinates cast in integer
            int playerXInteger = Integer.parseInt(playerX);
            int playerYInteger = Integer.parseInt(playerY);
            //if coordinates are beetween 0 and 3
            if ((playerXInteger <= 3 && playerXInteger > 0) && (playerYInteger <= 3 && playerYInteger > 0)) {
                //if box is empty, like '_'
                if (cells.charAt((playerYInteger - 1) + (3 * (playerXInteger - 1))) == '_') {
                    canPlay = true;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        } else {
            System.out.println("You should enter numbers!");
        }
        return canPlay;
    }

    public static boolean gameStatus(String cells) {
        boolean gameNotFinished = false;
        boolean xWin = false;
        boolean oWin = false;

        int countOSymbol = cells.length() - cells.replace("X", "").length();
        int countXSymbol = cells.length() - cells.replace("O", "").length();

        //if there are no more O symbol or X symbol
        if(Math.abs(countOSymbol - countXSymbol) < 2) {
            for(int i=0; i<3; i++) {
                String ligne = "";
                String col = "";
                //Loop for check all column and line
                for(int j=0; j<3; j++) {
                    ligne += String.valueOf(cells.charAt(3*i+j));
                    col += String.valueOf(cells.charAt((3*j+i)));
                }
                if(Pattern.matches("XXX",ligne)) {
                    xWin = true;
                } else if(Pattern.matches("OOO",ligne)){
                    oWin = true;
                }
                if(Pattern.matches("XXX",col)) {
                    xWin = true;
                } else if(Pattern.matches("OOO",col)){
                    oWin = true;
                }
            }

            String diag1 = new StringBuilder().append(cells.charAt(0)).append(cells.charAt(4)).append(cells.charAt(8)).toString();
            String diag2 = new StringBuilder().append(cells.charAt(2)).append(cells.charAt(4)).append(cells.charAt(6)).toString();

            if(Pattern.matches("XXX",diag1)) {
                xWin = true;
            } else if(Pattern.matches("OOO",diag1)){
                oWin = true;
            }

            if(Pattern.matches("XXX",diag2)) {
                xWin = true;
            } else if(Pattern.matches("OOO",diag2)){
                oWin = true;
            }

            if(oWin && xWin) {
                System.out.println("Impossible");
            } else if(oWin) {
                System.out.println("O wins");
            }else if(xWin) {
                System.out.println("X wins");
            }else if(cells.indexOf('_') != -1) {
                //System.out.println("Game not finished");
                gameNotFinished = true;
            } else {
                System.out.println("Draw");
            }
        } else {
            System.out.println("Impossible");
        }
        return gameNotFinished;
    }
}
