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


    public void start() {


        System.out.println(BoardText.RULES);

        while (board.getNumberOfPlayerPawns() != 0 || board.getNumberOfCompPawns() != 0) {

//            board.printBoard();

            //częśc playera

//            tryToCompulsoryBeat(); // sprawdzam mozliwosc bicia dla playera
//            System.out.println(BoardText.PLAYER_INSTRUCTION_PAWN);
//            convertToPawnCords();
//            System.out.println(BoardText.PLAYER_INSTRUCTION_SQUARE);
//            convertToSquareCords();
//            board.playerMove(playerPawnRow, playerPawnColumn,playerSquareRow,playerSquareColumn);
//            board.printBoard();

            // kod dla ruchu komputera
            board.addIndexesToPawn(); //aktualizacja indexów dla pioknów
            List<DraughtsBoardObject> temp = board.getCompPawnsList(); //lista z pionkami kompa

            do {
                DraughtsBoardObject tempObjectForCords = getRandomPawn(temp);
                compPawnRow = tempObjectForCords.getX();
                compPawnColumn = tempObjectForCords.getY();
            } while (!board.compMove(compPawnRow, compPawnColumn));

            board.printBoard();


            convertToPawnCords();// zeby zatrzymac petle


        }


    }


    private void tryToCompulsoryBeat() { // sprawdzam mozliwosc bicia dla pionkow playera
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if (board.getBoard()[i][j].isPlayer()) {
                    board.compulsoryPlayerMove(i, j);
                }
            }
        }
    }

    private void convertToSquareCords() {
        String[] cords = scan.nextLine().split(",");
        playerSquareRow = Integer.parseInt(cords[0]);
        playerSquareColumn = Integer.parseInt(cords[1]);
    }

    private void convertToPawnCords() {
        String[] cords = scan.nextLine().split(",");
        playerPawnRow = Integer.parseInt(cords[0]);
        playerPawnColumn = Integer.parseInt(cords[1]);
    }

    private int getRandomNumber(List<DraughtsBoardObject> list) {
        Random random = new Random();
        return random.nextInt(list.size());
    }

    private DraughtsBoardObject getRandomPawn(List<DraughtsBoardObject> list) {
        return list.get(getRandomNumber(list));
    }

}
