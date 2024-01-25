package draughtBoard;


import comments.BoardText;

public class DraughtBoard {
    public static final int SIZE = 10;
    private DraughtsBoardObject[][] board = new DraughtsBoardObject[SIZE][SIZE];

    public DraughtBoard() {

        // lewa czesc ramki
        board[0][0] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 0, 0);
        board[1][0] = new DraughtsBoardObject("  1  ", false, false, true, false, false, 1, 0);
        board[2][0] = new DraughtsBoardObject("  2  ", false, false, true, false, false, 2, 0);
        board[3][0] = new DraughtsBoardObject("  3  ", false, false, true, false, false, 3, 0);
        board[4][0] = new DraughtsBoardObject("  4  ", false, false, true, false, false, 4, 0);
        board[5][0] = new DraughtsBoardObject("  5  ", false, false, true, false, false, 5, 0);
        board[6][0] = new DraughtsBoardObject("  6  ", false, false, true, false, false, 6, 0);
        board[7][0] = new DraughtsBoardObject("  7  ", false, false, true, false, false, 7, 0);
        board[8][0] = new DraughtsBoardObject("  8  ", false, false, true, false, false, 8, 0);
        board[9][0] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 0);

        // górna czesc ramki
        board[0][1] = new DraughtsBoardObject("  1  ", false, false, true, false, false, 0, 1);
        board[0][2] = new DraughtsBoardObject("  2  ", false, false, true, false, false, 0, 2);
        board[0][3] = new DraughtsBoardObject("  3  ", false, false, true, false, false, 0, 3);
        board[0][4] = new DraughtsBoardObject("  4  ", false, false, true, false, false, 0, 4);
        board[0][5] = new DraughtsBoardObject("  5  ", false, false, true, false, false, 0, 5);
        board[0][6] = new DraughtsBoardObject("  6  ", false, false, true, false, false, 0, 6);
        board[0][7] = new DraughtsBoardObject("  7  ", false, false, true, false, false, 0, 7);
        board[0][8] = new DraughtsBoardObject("  8  ", false, false, true, false, false, 0, 8);
        board[0][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 0, 9);

        // dolna czesc ramki
        board[9][1] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 1);
        board[9][2] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 2);
        board[9][3] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 3);
        board[9][4] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 4);
        board[9][5] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 5);
        board[9][6] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 6);
        board[9][7] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 7);
        board[9][8] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 8);
        board[9][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 9, 9);

        // prawa czesc ramki
        board[1][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 1, 9);
        board[2][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 2, 9);
        board[3][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 3, 9);
        board[4][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 4, 9);
        board[5][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 5, 9);
        board[6][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 6, 9);
        board[7][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 7, 9);
        board[8][9] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 8, 9);

        //pola niedostepne
        board[1][1] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 1, 1);
        board[1][3] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 1, 3);
        board[1][5] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 1, 5);
        board[1][7] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 1, 7);

        board[2][2] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 2, 2);
        board[2][4] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 2, 4);
        board[2][6] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 2, 6);
        board[2][8] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 2, 8);

        board[3][1] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 3, 1);
        board[3][3] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 3, 3);
        board[3][5] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 3, 5);
        board[3][7] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 3, 7);

        board[4][2] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 4, 2);
        board[4][4] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 4, 4);
        board[4][6] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 4, 6);
        board[4][8] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 4, 8);

        board[5][1] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 5, 1);
        board[5][3] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 5, 3);
        board[5][5] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 5, 5);
        board[5][7] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 5, 7);

        board[6][2] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 6, 2);
        board[6][4] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 6, 4);
        board[6][6] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 6, 6);
        board[6][8] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 6, 8);

        board[7][1] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 7, 1);
        board[7][3] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 7, 3);
        board[7][5] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 7, 5);
        board[7][7] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 7, 7);

        board[8][2] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 8, 2);
        board[8][4] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 8, 4);
        board[8][6] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 8, 6);
        board[8][8] = new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false, 8, 8);

        //pola dostepne
        board[4][1] = new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false, 4, 1);
        board[4][3] = new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false, 4, 3);
        board[4][5] = new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false, 4, 5);
        board[4][7] = new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false, 4, 7);
        board[5][2] = new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false, 3, 2);
        board[5][4] = new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false, 5, 4);
        board[5][6] = new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false, 5, 6);
        board[5][8] = new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false, 5, 8);

        //pionki kompa
        board[1][2] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 1, 2);
        board[1][4] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 1, 4);
        board[1][6] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 1, 6);
        board[1][8] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 1, 8);

        board[2][1] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 2, 1);
        board[2][3] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 2, 3);
        board[2][5] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 2, 5);
        board[2][7] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 2, 7);

        board[3][2] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 3, 2);
        board[3][4] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 3, 4);
        board[3][6] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 3, 6);
        board[3][8] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, 3, 8);

        // pionki gracza
        board[6][1] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 6, 1);
        board[6][3] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 6, 3);
        board[6][5] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 6, 5);
        board[6][7] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 6, 7);

        board[7][2] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 7, 2);
        board[7][4] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 7, 4);
        board[7][6] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 7, 6);
        board[7][8] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 7, 8);

        board[8][1] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 8, 1);
        board[8][3] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 8, 3);
        board[8][5] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 8, 5);
        board[8][7] = new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false, 8, 7);
    }

    public void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }
    }

    public void playerMove(int pawnRow, int pawnColumn, int squareRow, int squareColumn) { // ruch - zamiana pionka w pole i na odwrot
        //ruch w przypadku pustego pola---------------------------------------------------------
        if (board[pawnRow][pawnColumn].isPlayer() && board[squareRow][squareColumn].isSquare() && board[squareRow][squareColumn].isAvailable() && (squareRow == pawnRow-1) && ((squareColumn == (pawnColumn-1))||((squareColumn == (pawnColumn+1))))){

            //pole pionka
            board[pawnRow][pawnColumn].setIsPawn(false); // to nie jest juz pionek
            board[pawnRow][pawnColumn].setIsPlayer(false); // to nie jest juz player
            board[pawnRow][pawnColumn].setIsSquare(true); //teraz jest polem
            board[pawnRow][pawnColumn].setName(BoardText.AVAILABLE_SQUARE);//wygląd pola

            //pole - pole staje sie pionkiem i ma wyglad gracza
            board[squareRow][squareColumn].setIsPawn(true);
            board[squareRow][squareColumn].setIsSquare(false);
            board[squareRow][squareColumn].setName(BoardText.PLAYER_MARK);

        } else {
            System.err.println(BoardText.NOT_ALLOWED_OPERATION);
        }
    }


    public void removePawn(int row, int column) { //zamiana pionka w puste miejsce
        board[row][column].setIsPawn(false);
        board[row][column].setIsSquare(true);
        board[row][column].setIsPlayer(false);
        board[row][column].setIsComp(false);
        board[row][column].setName(BoardText.AVAILABLE_SQUARE);

    }

    public void tempAdd(int row,int column){
        board[row][column] = new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true, row, column);
    }
}