package tictactoe;

public class Main {

    public static void drawBoard(char[][] board) {
        System.out.println(java.util.Arrays.deepToString(board)
                .replace(", ", "")
                .replace("[", "")
                .replace("]", "\n"));
    }

    public static boolean winner(char[][] board, char c) {
        for (int i = 1, j = 2; i <= 3; i++) {
            if (checkRow(board, i) && board[i][2] == c)
                return true;
            for (; j <= 6; j += 2) {
                if (checkColumn(board, j) && board[1][j] == c)
                    return true;
            }
        }
        if (checkLeftDiagonal(board) && board[1][2] == c)
            return true;
        else return checkRightDiagonal(board) && board[1][6] == c;
    }

    public static boolean checkRow(char[][] board, int row) {
        return board[row][2] == board[row][4] && board[row][2] == board[row][6];
    }

    public static boolean checkColumn(char[][] board, int col) {
        return board[1][col] == board[2][col] && board[1][col] == board[3][col];
    }

    public static boolean checkLeftDiagonal(char[][] board) {
        return board[1][2] == board[2][4] && board[1][2] == board[3][6];
    }

    public static boolean checkRightDiagonal(char[][] board) {
        return board[1][6] == board[2][4] && board[1][6] == board[3][2];
    }

    public static void turn(char[][] board, char xo){
        while (true) {
            try {
                var sc = new java.util.Scanner(System.in);
                System.out.print("Enter the coordinates: ");
                int row = sc.nextInt();
                int col = sc.nextInt();

                if (row > 3 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3");
                } else if (board[row][col * 2] == '_') {
                    board[row][col * 2] = xo;
                    return;
                } else {
                    System.out.println("The cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'-', '-', '-', '-', '-', '-' ,'-', '-', '-'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'-', '-', '-', '-', '-', '-' ,'-', '-', '-'}
        };
        for (int i = 0; i < 9; i++){
            drawBoard(board);
            turn(board, i % 2 == 0 ? 'X' : 'O');
            if (winner(board, i % 2 == 0 ? 'X' : 'O')) {
                drawBoard(board);
                System.out.println((i % 2 == 0 ? "X" : "O") + " wins");
                return;
            }
        }
        drawBoard(board);
        System.out.println("Draw");
    }
}