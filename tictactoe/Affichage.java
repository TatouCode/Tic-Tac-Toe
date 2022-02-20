package tictactoe;

public class Affichage {

    public static void showCells(String cells) {
        System.out.println("---------");
        for(int i=0; i<3; i++) {
            System.out.print("|");
            System.out.print(" ");
            for(int j=0; j<3; j++) {
                System.out.print(cells.charAt(3*i+j));
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        System.out.print("Enter the coordinates:");
    }

}
