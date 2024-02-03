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

        while (getPlayerPawns() != 0 && getCompPawns() != 0) { // pętla trwa tak dlugo jak są pionki w grze
            //częśc playera
            System.out.println(BoardText.PLAYER_TURN);
            if (getCompPawns() != 0) {
                for (int i = 0; i < 4; i++) {
                    tryToCompulsoryBeat(); // sprawdzam mozliwosc bicia dla playera na wszelki wypadek 4 razy bo jak bedzie bicie to moze jest kolejne
                }
                if (wasCompulsoryForPlayer) {// jezeli bylo bicie to wyswietl plansze - zastepuje ta pierwsza
                    board.printBoard();
                }
                if (!wasCompulsoryForPlayer) { // jezeli nie bylo auto bicia to kolejka gracza / w przypadku musowego bicia - player nie wykonuje ruchu
                    System.out.println(BoardText.PLAYER_INSTRUCTION_PAWN); // bo wasCompulsory jest ustawione na true po met try compulsoryBeat
                    convertToPawnCords();
                    System.out.println(BoardText.PLAYER_INSTRUCTION_SQUARE);
                    convertToSquareCords();
                    board.playerMove(playerPawnRow, playerPawnColumn, playerSquareRow, playerSquareColumn); // trzeba dorobic poprawke bo player traci swoj ruch kompletnie
                    board.printBoard();                                                                     //jeze wyjdzie niedozwolony ruch
                }
                wasCompulsoryForPlayer = false;// reset stanu, dla next pętli
            }

            System.out.println(BoardText.COMP_TURN);
            // kod dla ruchu komputera
            if (getCompPawns() != 0) { // sprawdzam czy zostaly jeszcze jakies pionki kompa
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
                if (!wasCompulsoryForComp) { // w przypadku braku musowego bicia nastepuje normalny ruch
                    do {
                        getCordsRandomCompPawn(temp); // pobrany random pionek
                    } while (!board.compMove(compPawnRow, compPawnColumn)); // powtarza sprawdzanie dostepnosci ruchu do momenty uzyskania true z metody
                    board.printBoard();
                }
                wasCompulsoryForComp = false; // trzeba zresetowac stan
            }
            System.out.println(BoardText.PLAYER_RESULT + getPlayerPawns());
            System.out.println(BoardText.COMP_RESULT + getCompPawns());
        }
        gemeResult();
    }

    private void gemeResult() {
        if (getCompPawns() == 0) {
            System.out.println(BoardText.PLAYER_WIN);
        } else if (getPlayerPawns() == 0) {
            System.out.println(BoardText.PLAYER_LOST);
        }
    }

    private int getPlayerPawns() { // zwraca ilosc pionkow gracza
        int tempPawnNr = 0;
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if (board.getBoard()[i][j].isPlayer()) {
                    tempPawnNr++;
                }
            }
        }
        return tempPawnNr;
    }

    private int getCompPawns() { // zwraca ilosc pionkow kompa
        int tempPawnNr = 0;
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if (board.getBoard()[i][j].isComp()) {
                    tempPawnNr++;
                }
            }
        }
        return tempPawnNr;
    }

    private void compCompulsoryBeat() {
        if (board.getBoard().length != 0) {
            for (int i = 0; i < board.getBoard().length; i++) { // przelatuje liste i sprawdzam dla kazdego pionka kompa czy uda sie uzyskac true z
                for (int j = 0; j < board.getBoard().length; j++) { // musowej metody bicia, jezeli tak to zmieniam stan na true - wasCompulsory dla kompa
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
            for (int j = 0; j < board.getBoard().length; j++) { // przelatuje po pionkach i sprawdzam czy sa to playery
                if (board.getBoard()[i][j].isKing() && board.compulsoryPlayerKingMove(i, j)) { // tu dla damki
                    wasCompulsoryForPlayer = true;
                } else if (board.getBoard()[i][j].isPlayer() && board.compulsoryPlayerMove(i, j)) { // jezeli player i dostane true z musowego bicia
                    wasCompulsoryForPlayer = true; // zmienia mi stan na true
                }
            }
        }
    }

    private void convertToSquareCords() { // zamiana danych od playera na cordy
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
        return list.get(getRandomNumber(list)); // pobiaram random pionka z listy na podstawie wylosowanej pozycji
    }
}
