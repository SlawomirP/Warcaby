import draughtBoard.DraughtBoard;

public class Tests {

    public static void main(String[] args) {

        DraughtBoard b = new DraughtBoard();

        b.printBoard();

        System.out.println("---------------------------");

        b.tempAdd(5,4);

        b.printBoard();
        b.playerMove(6,1,5,2);

        b.printBoard();
//        System.out.println("---------------------------");
//
//        b.playerMove(5,2,6,1);
//
//        b.printBoard();

//        b.playerMove(5,2,6,1);
//
//        b.printBoard();
    }

}
