package draughtBoard;

import comments.BoardText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DraughtBoard {
    public static final int SIZE = 10;
    private int numberOfCompPawns = 12;
    private int numberOfPlayerPawns = 12;
    private DraughtsBoardObject[][] board = new DraughtsBoardObject[SIZE][SIZE];

    public DraughtBoard() {

        // lewa czesc ramki
        board[0][0] = createEmptyUnavailableSquare();
        board[1][0] = createUnavailableFrameElement("1");
        board[2][0] = createUnavailableFrameElement("2");
        board[3][0] = createUnavailableFrameElement("3");
        board[4][0] = createUnavailableFrameElement("4");
        board[5][0] = createUnavailableFrameElement("5");
        board[6][0] = createUnavailableFrameElement("6");
        board[7][0] = createUnavailableFrameElement("7");
        board[8][0] = createUnavailableFrameElement("8");
        board[9][0] = createEmptyUnavailableSquare();

        // górna czesc ramki
        board[0][1] = createUnavailableFrameElement("1");
        board[0][2] = createUnavailableFrameElement("2");
        board[0][3] = createUnavailableFrameElement("3");
        board[0][4] = createUnavailableFrameElement("4");
        board[0][5] = createUnavailableFrameElement("5");
        board[0][6] = createUnavailableFrameElement("6");
        board[0][7] = createUnavailableFrameElement("7");
        board[0][8] = createUnavailableFrameElement("8");
        board[0][9] = createEmptyUnavailableSquare();

        // dolna czesc ramki
        board[9][1] = createEmptyUnavailableSquare();
        board[9][2] = createEmptyUnavailableSquare();
        board[9][3] = createEmptyUnavailableSquare();
        board[9][4] = createEmptyUnavailableSquare();
        board[9][5] = createEmptyUnavailableSquare();
        board[9][6] = createEmptyUnavailableSquare();
        board[9][7] = createEmptyUnavailableSquare();
        board[9][8] = createEmptyUnavailableSquare();
        board[9][9] = createEmptyUnavailableSquare();

        // prawa czesc ramki
        board[1][9] = createEmptyUnavailableSquare();
        board[2][9] = createEmptyUnavailableSquare();
        board[3][9] = createEmptyUnavailableSquare();
        board[4][9] = createEmptyUnavailableSquare();
        board[5][9] = createEmptyUnavailableSquare();
        board[6][9] = createEmptyUnavailableSquare();
        board[7][9] = createEmptyUnavailableSquare();
        board[8][9] = createEmptyUnavailableSquare();

        //pola niedostepne
        board[1][1] = createEmptyUnavailableSquare();
        board[1][3] = createEmptyUnavailableSquare();
        board[1][5] = createEmptyUnavailableSquare();
        board[1][7] = createEmptyUnavailableSquare();

        board[2][2] = createEmptyUnavailableSquare();
        board[2][4] = createEmptyUnavailableSquare();
        board[2][6] = createEmptyUnavailableSquare();
        board[2][8] = createEmptyUnavailableSquare();

        board[3][1] = createEmptyUnavailableSquare();
        board[3][3] = createEmptyUnavailableSquare();
        board[3][5] = createEmptyUnavailableSquare();
        board[3][7] = createEmptyUnavailableSquare();

        board[4][2] = createEmptyUnavailableSquare();
        board[4][4] = createEmptyUnavailableSquare();
        board[4][6] = createEmptyUnavailableSquare();
        board[4][8] = createEmptyUnavailableSquare();

        board[5][1] = createEmptyUnavailableSquare();
        board[5][3] = createEmptyUnavailableSquare();
        board[5][5] = createEmptyUnavailableSquare();
        board[5][7] = createEmptyUnavailableSquare();

        board[6][2] = createEmptyUnavailableSquare();
        board[6][4] = createEmptyUnavailableSquare();
        board[6][6] = createEmptyUnavailableSquare();
        board[6][8] = createEmptyUnavailableSquare();

        board[7][1] = createEmptyUnavailableSquare();
        board[7][3] = createEmptyUnavailableSquare();
        board[7][5] = createEmptyUnavailableSquare();
        board[7][7] = createEmptyUnavailableSquare();

        board[8][2] = createEmptyUnavailableSquare();
        board[8][4] = createEmptyUnavailableSquare();
        board[8][6] = createEmptyUnavailableSquare();
        board[8][8] = createEmptyUnavailableSquare();

        //pola dostepne
        board[4][1] = createEmptyAvailableSquare();
        board[4][3] = createEmptyAvailableSquare();
        board[4][5] = createEmptyAvailableSquare();
        board[4][7] = createEmptyAvailableSquare();
        board[5][2] = createEmptyAvailableSquare();
        board[5][4] = createEmptyAvailableSquare();
        board[5][6] = createEmptyAvailableSquare();
        board[5][8] = createEmptyAvailableSquare();

        //pionki kompa
        board[1][2] = createCompPawn();
        board[1][4] = createCompPawn();
        board[1][6] = createCompPawn();
        board[1][8] = createCompPawn();

        board[2][1] = createCompPawn();
        board[2][3] = createCompPawn();
        board[2][5] = createCompPawn();
        board[2][7] = createCompPawn();

        board[3][2] = createCompPawn();
        board[3][4] = createCompPawn();
        board[3][6] = createCompPawn();
        board[3][8] = createCompPawn();

        // pionki gracza
        board[6][1] = createPlayerPawn();
        board[6][3] = createPlayerPawn();
        board[6][5] = createPlayerPawn();
        board[6][7] = createPlayerPawn();

        board[7][2] = createPlayerPawn();
        board[7][4] = createPlayerPawn();
        board[7][6] = createPlayerPawn();
        board[7][8] = createPlayerPawn();

        board[8][1] = createPlayerPawn();
        board[8][3] = createPlayerPawn();
        board[8][5] = createPlayerPawn();
        board[8][7] = createPlayerPawn();
    }

    public void printBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }
    }

    public void playerMove(int pawnRow, int pawnColumn, int squareRow, int squareColumn) { // ruch przy pustym nastepnym polu - zamiana pionka w pole i pola w pionek
        if (board[pawnRow][pawnColumn].isPlayer() && board[squareRow][squareColumn].isSquare() && board[squareRow][squareColumn].isAvailable() && (squareRow == pawnRow - 1) && ((squareColumn == (pawnColumn - 1)) || ((squareColumn == (pawnColumn + 1))))) {
            pawnToSquare(pawnRow, pawnColumn);//pionek zamienia sie w pole
            squareToPlayer(squareRow, squareColumn); //pole - pole staje sie pionkiem i ma wyglad gracza
        } else {
            System.err.println(BoardText.NOT_ALLOWED_OPERATION);
        }
    }

    public boolean compMove(int pawnRow, int pawnColumn) {
        boolean status = false;
        // jezeli po lewej byloby zbicie odbij w prawo jezeli jest mozliwosc
        if (board[pawnRow + 1][pawnColumn - 1].isSquare() && board[pawnRow + 1][pawnColumn - 1].isAvailable() && board[pawnRow + 2][pawnColumn - 2].isPlayer() && board[pawnRow + 1][pawnColumn + 1].isSquare() && board[pawnRow + 1][pawnColumn + 1].isAvailable()) {
            status = compMoveToRight(pawnRow, pawnColumn);
        }
        // jezeli zbicie byloby po prawej
        else if (board[pawnRow + 1][pawnColumn + 1].isSquare() && board[pawnRow + 1][pawnColumn + 1].isAvailable() && board[pawnRow + 2][pawnColumn + 2].isPlayer() && board[pawnRow + 1][pawnColumn - 1].isSquare() && board[pawnRow + 1][pawnColumn - 1].isAvailable()) {
            status = compMoveToLeft(pawnRow, pawnColumn);
        }
        //oba dostepne miejsca
        else if ((board[pawnRow + 1][pawnColumn - 1].isSquare() && board[pawnRow + 1][pawnColumn - 1].isAvailable()) && (board[pawnRow + 1][pawnColumn + 1].isSquare() && board[pawnRow + 1][pawnColumn + 1].isAvailable())) {
            int temp = getRandomNumber();
            if (temp == 0) { // ruch w lewo
                status = compMoveToLeft(pawnRow, pawnColumn);
            } else { // ruch w prawo
                status = compMoveToRight(pawnRow, pawnColumn);
            }
        }
        //wolne pole po lewej
        else if (board[pawnRow + 1][pawnColumn - 1].isSquare() && board[pawnRow + 1][pawnColumn - 1].isAvailable()) {
            status = compMoveToLeft(pawnRow, pawnColumn);
        }
        //wolne po prawej
        else if (board[pawnRow + 1][pawnColumn + 1].isSquare() && board[pawnRow + 1][pawnColumn + 1].isAvailable()) {
            status = compMoveToRight(pawnRow, pawnColumn);
        }
        return status;
    }

    private boolean compMoveToRight(int pawnRow, int pawnColumn) {
        boolean status;
        pawnToSquare(pawnRow, pawnColumn);
        squareToComp(pawnRow + 1, pawnColumn + 1);
        status = true;
        return status;
    }

    private boolean compMoveToLeft(int pawnRow, int pawnColumn) {
        boolean status;
        pawnToSquare(pawnRow, pawnColumn);
        squareToComp(pawnRow + 1, pawnColumn - 1);
        status = true;
        return status;
    }


    public boolean compulsoryPlayerMove(int pawnRow, int pawnColumn) { // obowiazkowe zbicie pionka  - idzie z auto dla kazdej strony
        boolean status = false;
        //opcja comp lewy gorny
        if (board[pawnRow - 1][pawnColumn - 1].isComp() && board[pawnRow - 2][pawnColumn - 2].isSquare() && board[pawnRow - 2][pawnColumn - 2].isAvailable()) {
            pawnToSquare(pawnRow, pawnColumn); //pionek playera zamienia sie w pole - dziala
            pawnToSquare((pawnRow - 1), pawnColumn - 1); //pionek compa zamienia sie w pole - dziala
            squareToPlayer(pawnRow - 2, pawnColumn - 2); // pole zamiania sie w pionek playera - dziala
            takeOffCompPawn();
//            compulsoryPlayerMove(pawnRow - 2, pawnColumn - 2); // na wypadek gdyby bicie bylo podwojne
            status = true;
        }
        //opcja comp prawy górny
        else if (board[pawnRow - 1][pawnColumn + 1].isComp() && board[pawnRow - 2][pawnColumn + 2].isSquare() && board[pawnRow - 2][pawnColumn + 2].isAvailable()) {
            pawnToSquare(pawnRow, pawnColumn);
            pawnToSquare((pawnRow - 1), pawnColumn + 1);
            squareToPlayer(pawnRow - 2, pawnColumn + 2);
            takeOffCompPawn();
//            compulsoryPlayerMove(pawnRow - 2, pawnColumn + 2);
            status = true;
        }
        //opcja comp lewy dolny
        if (board[pawnRow + 1][pawnColumn - 1].isComp() && board[pawnRow + 2][pawnColumn - 2].isSquare() && board[pawnRow + 2][pawnColumn - 2].isAvailable()) {
            pawnToSquare(pawnRow, pawnColumn);
            pawnToSquare((pawnRow + 1), pawnColumn - 1);
            squareToPlayer(pawnRow + 2, pawnColumn - 2);
            takeOffCompPawn();
//            compulsoryPlayerMove(pawnRow - 2, pawnColumn - 2);
            status = true;
        }
        //opcja comp prawy dolny
        else if (board[pawnRow + 1][pawnColumn + 1].isComp() && board[pawnRow + 2][pawnColumn + 2].isSquare() && board[pawnRow + 2][pawnColumn + 2].isAvailable()) {
            pawnToSquare(pawnRow, pawnColumn);
            pawnToSquare((pawnRow + 1), pawnColumn + 1);
            squareToPlayer(pawnRow + 2, pawnColumn + 2);
            takeOffCompPawn();
//            compulsoryPlayerMove(pawnRow + 2, pawnColumn + 2);
            status = true;
        }
        return status;
    }

    public boolean compulsoryCompMove(int pawnRow, int pawnColumn) {
        boolean status = false;

        //player w lewym górnym
        if (board[pawnRow - 1][pawnColumn - 1].isPlayer() && board[pawnRow - 2][pawnColumn - 2].isSquare() && board[pawnRow - 2][pawnColumn - 2].isAvailable()) {
            status = true;
            pawnToSquare(pawnRow, pawnColumn); //pionek compa zamienia sie w pole
            pawnToSquare((pawnRow - 1), pawnColumn - 1); //pionek playera zamienia sie w pole
            squareToComp(pawnRow - 2, pawnColumn - 2); // pole zamiania sie w pionek compa
            takeOffPlayerPawn();
            compulsoryCompMove(pawnRow - 2, pawnColumn - 2); // na wypadek gdyby bicie bylo podwojne
        }
        //player w prawym gornym
        else if (board[pawnRow - 1][pawnColumn + 1].isPlayer() && board[pawnRow - 2][pawnColumn + 2].isSquare() && board[pawnRow - 2][pawnColumn + 2].isAvailable()) {
            status = true;
            pawnToSquare(pawnRow, pawnColumn);
            pawnToSquare((pawnRow - 1), pawnColumn + 1);
            squareToComp(pawnRow - 2, pawnColumn + 2);
            takeOffPlayerPawn();
            compulsoryCompMove(pawnRow - 2, pawnColumn + 2);
        }
        // player w lewym dolnym
        else if (board[pawnRow + 1][pawnColumn - 1].isPlayer() && board[pawnRow + 2][pawnColumn - 2].isSquare() && board[pawnRow + 2][pawnColumn - 2].isAvailable()) {
            status = true;
            pawnToSquare(pawnRow, pawnColumn);
            pawnToSquare((pawnRow + 1), pawnColumn - 1);
            squareToComp(pawnRow + 2, pawnColumn - 2);
            takeOffPlayerPawn();
            compulsoryCompMove(pawnRow + 2, pawnColumn - 2);
        }
        //player w prawym dolnym
        else if (board[pawnRow + 1][pawnColumn + 1].isPlayer() && board[pawnRow + 2][pawnColumn + 2].isSquare() && board[pawnRow + 2][pawnColumn + 2].isAvailable()) {
            status = true;
            pawnToSquare(pawnRow, pawnColumn);
            pawnToSquare((pawnRow + 1), pawnColumn + 1);
            squareToComp(pawnRow + 2, pawnColumn + 2);
            takeOffPlayerPawn();
            compulsoryCompMove(pawnRow + 2, pawnColumn + 2);
        }

        return status;
    }

    private static DraughtsBoardObject createUnavailableFrameElement(String elementName) {
        String name = "  " + elementName + "  ";
        return new DraughtsBoardObject(name, false, false, true, false, false);
    }

    private static DraughtsBoardObject createPlayerPawn() {
        return new DraughtsBoardObject(BoardText.PLAYER_MARK, true, true, false, true, false);
    }

    private static DraughtsBoardObject createCompPawn() {
        return new DraughtsBoardObject(BoardText.COMP_MARK, true, true, false, false, true);
    }

    private static DraughtsBoardObject createEmptyAvailableSquare() {
        return new DraughtsBoardObject(BoardText.AVAILABLE_SQUARE, true, false, true, false, false);
    }

    private static DraughtsBoardObject createEmptyUnavailableSquare() {
        return new DraughtsBoardObject(BoardText.EMPTY_SQUARE, false, false, true, false, false);
    }

    private void squareToPlayer(int squareRow, int squareColumn) {
        board[squareRow][squareColumn].setIsPawn(true);
        board[squareRow][squareColumn].setIsPlayer(true);
        board[squareRow][squareColumn].setIsSquare(false);
        board[squareRow][squareColumn].setIsComp(false);
        board[squareRow][squareColumn].setName(BoardText.PLAYER_MARK);
    }

    private void squareToComp(int squareRow, int squareColumn) {
        board[squareRow][squareColumn].setIsPawn(true);
        board[squareRow][squareColumn].setIsPlayer(false);
        board[squareRow][squareColumn].setIsSquare(false);
        board[squareRow][squareColumn].setIsComp(true);
        board[squareRow][squareColumn].setName(BoardText.COMP_MARK);
    }

    private void pawnToSquare(int pawnRow, int pawnColumn) {
        board[pawnRow][pawnColumn].setIsSquare(true); //teraz jest polem
        board[pawnRow][pawnColumn].setIsPawn(false); // to nie jest juz pionek
        board[pawnRow][pawnColumn].setIsPlayer(false); // to nie jest juz player
        board[pawnRow][pawnColumn].setIsComp(false); // nie comp
        board[pawnRow][pawnColumn].setName(BoardText.AVAILABLE_SQUARE);//wygląd pola
    }

    public int getNumberOfCompPawns() {
        return this.numberOfCompPawns;
    }

    public void takeOffCompPawn() {
        this.numberOfCompPawns -= 1;
    }

    public int getNumberOfPlayerPawns() {
        return this.numberOfPlayerPawns;
    }

    public void takeOffPlayerPawn() {
        this.numberOfPlayerPawns -= 1;
    }

    public DraughtsBoardObject[][] getBoard() {
        return board;
    }

    public List<DraughtsBoardObject> getCompPawnsList() {
        List<DraughtsBoardObject> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].isComp()) {
                    temp.add(board[i][j]);
                }
            }
        }
        return temp;
    }

    public void addIndexesToPawn() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].setX(i);
                board[i][j].setY(j);

            }
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(2);
    }

    ///tymczasowe metody do usuniecia---------------------------------------------------------------------

    public void tempRemovePawn(int row, int column) { //zamiana pionka w puste miejsce
        board[row][column].setIsPawn(false);
        board[row][column].setIsSquare(true);
        board[row][column].setIsPlayer(false);
        board[row][column].setIsComp(false);
        board[row][column].setName(BoardText.AVAILABLE_SQUARE);

    }

    public void tempCompPawnAdd(int row, int column) {
        board[row][column] = createCompPawn();
    }
}