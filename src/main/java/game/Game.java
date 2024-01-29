package game;

import comments.BoardText;
import draughtBoard.DraughtBoard;
import draughtBoard.DraughtsBoardObject;

import java.util.*;

public class Game {
    private DraughtBoard board = new DraughtBoard();
    Scanner scan = new Scanner(System.in);
    private int playerPawnRow;
    private int playerPawnColumn;
    private int playerSquareRow;
    private int playerSquareColumn;
    private int compPawnRow;
    private int compPawnColumn;
    private boolean wasCompulsoryForComp = false;
    private boolean wasCompulsoryForPlayer = false;


    public void start() {

        System.out.println(BoardText.RULES);

        board.printBoard();

        while (board.getNumberOfPlayerPawns() != 0 && board.getNumberOfCompPawns() != 0) {

            //częśc playera
            System.out.println("--------------- moj ruch");
            if (board.getNumberOfCompPawns() != 0) {
                for (int i = 0; i < 4; i++) {
                    tryToCompulsoryBeat(); // sprawdzam mozliwosc bicia dla playera
                }
                if (wasCompulsoryForPlayer) {// jezeli bylo bicie to wyswietl plansze
                    board.printBoard();
                }

                if (!wasCompulsoryForPlayer) { // jezeli nie bylo auto bicia to kolejka gracza
                    System.out.println(BoardText.PLAYER_INSTRUCTION_PAWN);
                    convertToPawnCords();
                    System.out.println(BoardText.PLAYER_INSTRUCTION_SQUARE);
                    convertToSquareCords();
                    board.playerMove(playerPawnRow, playerPawnColumn, playerSquareRow, playerSquareColumn);
                    board.printBoard();
                }
                wasCompulsoryForPlayer = false;// reset stanu
            }

            System.out.println("---------------komp");
            // kod dla ruchu komputera
            if (board.getNumberOfCompPawns() != 0) {
                for (int i = 0; i < 4; i++) {
                    board.addIndexesToPawn(); //aktualizacja indexów dla pioknów
                    List<DraughtsBoardObject> temp = board.getCompPawnsList(); //lista z pionkami kompa
                    compCompulsoryBeat(); // komp sprawdza czy jest musowe bicie
                }
                board.addIndexesToPawn(); //aktualizacja indexów dla pioknów
                List<DraughtsBoardObject> temp = board.getCompPawnsList(); //lista z pionkami kompa

                if (wasCompulsoryForComp) { // jezeli jest musowe bicie to wyswietl  tablice
                    board.printBoard();
                }

                if (!wasCompulsoryForComp) {
                    do {
                        getCordsRandomCompPawn(temp);
                    } while (!board.compMove(compPawnRow, compPawnColumn));
                    board.printBoard();
                }
                wasCompulsoryForComp = false;
            }
            System.out.println("wynik player: " + board.getNumberOfPlayerPawns());
            System.out.println("wynik komp: " + board.getNumberOfCompPawns());
        }
        System.out.println("bye bye");
    }

    private void compCompulsoryBeat() {
        if (board.getBoard().length != 0) {
            for (int i = 0; i < board.getBoard().length; i++) {
                for (int j = 0; j < board.getBoard().length; j++) {
                    if (board.getBoard()[i][j].isComp() && board.compulsoryCompMove(i, j)) {
                        wasCompulsoryForComp = true;
                    }
                }
            }
        }
    }

    private void getCordsRandomCompPawn(List<DraughtsBoardObject> temp) { // pobiera cordy z losowego pionka kompa
        DraughtsBoardObject tempObjectForCords = getRandomPawn(temp);
        compPawnRow = tempObjectForCords.getX();
        compPawnColumn = tempObjectForCords.getY();
    }


    private void tryToCompulsoryBeat() { // sprawdzam czy gdzies wystapi musowe bicie dla playera
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if (board.getBoard()[i][j].isPlayer() && board.compulsoryPlayerMove(i, j)) {
                    wasCompulsoryForPlayer = true;
                }
            }
        }
    }

    private void convertToSquareCords() { // zamiana danych od playera na cordy - square ta dolna metode usunac bo sie powtarza kod
        String[] cords = scan.nextLine().split(",");
        playerSquareRow = Integer.parseInt(cords[0]);
        playerSquareColumn = Integer.parseInt(cords[1]);
    }

    private void convertToPawnCords() {
        String[] cords = scan.nextLine().split(",");
        playerPawnRow = Integer.parseInt(cords[0]);
        playerPawnColumn = Integer.parseInt(cords[1]);
    }

    private int getRandomNumber(List<DraughtsBoardObject> list) { // uzyskujemy randomowa pozycje pionka
        int temp = 0;                                             // losowanie od 0 do wielkosci listy
        Random random = new Random();
        if (!list.isEmpty()) {
            temp = random.nextInt(list.size());
        }
        return temp;
    }

    private DraughtsBoardObject getRandomPawn(List<DraughtsBoardObject> list) { // losowy pionek z listy
        return list.get(getRandomNumber(list));
    }
}
