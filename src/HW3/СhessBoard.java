package HW3;

public class СhessBoard {
    public static void main(String[] args) {
        String[][] Board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j) % 2 == 0) {
                    Board[i][j] = "W";
                } else
                    Board[i][j] = "B";
                System.out.print(" " + Board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
