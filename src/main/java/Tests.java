import draughtBoard.DraughtBoard;

public class Tests {

    public static void main(String[] args) {

        DraughtBoard b = new DraughtBoard();

        b.printBoard();

        System.out.println("--------------po dodaniu-------------");

        b.tempRemovePawn(2,1);
        b.tempCompPawnAdd(5,4);
        b.tempCompPawnAdd(3,2);

        b.printBoard();

        System.out.println("--------------po biciu-------------");

        b.compulsoryPlayerMove(6,5);

        b.printBoard();


//
//        b.playerMove(5,2,6,1);
//
//        b.printBoard();

//        b.playerMove(5,2,6,1);
//
//        b.printBoard();
    }

}
