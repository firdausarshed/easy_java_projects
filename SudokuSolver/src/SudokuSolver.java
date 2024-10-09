public class SudokuSolver {

    //constant for size of grid
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {

        //2d array to create game board
        int[][] board = {
                //randomly generated sudoku board
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        printBoard(board);

        if (solveBoard(board)){
            System.out.println("problem solved! :)");
        }
        else {
            System.out.println("board not solvable :(");
        }

        printBoard(board);

    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            //formatting the printed
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

    //validating user input - does the number already exist in the row? - boolean returns true is number exist in row
    private static boolean isNumberInRow(int[][] board, int number, int row){
        //loop for checking the input for each column within the grid's size
        for (int i = 0; i < GRID_SIZE; i++) {
            //if statement to confirm the input matches a number in the row
            if (board[row][i] == number) {
                return true;
            }
        }
        //if not found then is false
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column){
        for (int i = 0; i < GRID_SIZE; i++) {
            //board is now checking row i and column 'column'
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column){
        //determines which 3x3 sub-box the row and column belong to
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++){
            for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if (board[i][j] == number){
                    return true;
                }
            }
        }
        return false;

    }

    //checks that placement is valid
    private static boolean isValidPlacement(int[][] board, int number, int row, int column){
        //checks that suggested number is not in any row, column, or local sub-box
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column)&&
                !isNumberInBox(board, number, row, column);
    }

    //using recursion to solve the board
    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;

                            if (solveBoard(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



}
