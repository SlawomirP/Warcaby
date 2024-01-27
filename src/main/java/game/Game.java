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

//        board.tempRemovePawn(3,4);
//        board.tempRemovePawn(3,6);
//        board.tempCompPawnAdd(4,5);
        board.printBoard();


        while (board.getNumberOfPlayerPawns() != 0 || board.getNumberOfCompPawns() != 0) {

            //częśc playera
            System.out.println("--------------- moj ruch");

            tryToCompulsoryBeat(); // sprawdzam mozliwosc bicia dla playera

            if(wasCompulsoryForPlayer){
                board.printBoard();}

            if(!wasCompulsoryForPlayer){
                System.out.println(BoardText.PLAYER_INSTRUCTION_PAWN);
                convertToPawnCords();
                System.out.println(BoardText.PLAYER_INSTRUCTION_SQUARE);
                convertToSquareCords();
                board.playerMove(playerPawnRow, playerPawnColumn,playerSquareRow,playerSquareColumn);
                board.printBoard();
            }

            wasCompulsoryForPlayer = false;

            System.out.println("---------------komp");

            // kod dla ruchu komputera
            board.addIndexesToPawn(); //aktualizacja indexów dla pioknów
            List<DraughtsBoardObject> temp = board.getCompPawnsList(); //lista z pionkami kompa

            for (int i = 0; i < board.getBoard().length; i++) {
                for (int j = 0; j < board.getBoard().length; j++) {
                    if (board.getBoard()[i][j].isComp() && board.compulsoryCompMove(i, j)){
                        wasCompulsoryForComp = true;
                    }
                }
            }
            if(wasCompulsoryForComp){
                board.printBoard();}

//            System.err.println("status wasCompulsory1: " + wasCompulsoryForComp);

            if (!wasCompulsoryForComp) {
                do {
                    getCordsRandomCompPawn(temp);
                } while (!board.compMove(compPawnRow, compPawnColumn));
                board.printBoard();
            }

            wasCompulsoryForComp = false;
//            System.err.println("status wasCompulsory2: " + wasCompulsoryForComp);



//            convertToPawnCords();// zeby zatrzymac petle


        }


    }

    private void getCordsRandomCompPawn(List<DraughtsBoardObject> temp) {
        DraughtsBoardObject tempObjectForCords = getRandomPawn(temp);
        compPawnRow = tempObjectForCords.getX();
        compPawnColumn = tempObjectForCords.getY();
    }


    private void tryToCompulsoryBeat() { // sprawdzam mozliwosc bicia dla pionkow playera
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if (board.getBoard()[i][j].isPlayer() && board.compulsoryPlayerMove(i,j)) {
                    wasCompulsoryForPlayer = true;
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
