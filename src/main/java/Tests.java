import draughtBoard.DraughtBoard;
import draughtBoard.DraughtsBoardObject;

import java.util.List;
import java.util.Random;

public class Tests {

    public static void main(String[] args) {

        Random random = new Random();

        DraughtBoard board = new DraughtBoard();
        board.addIndexesToPawn();
        List<DraughtsBoardObject> temp = board.getCompPawnsList();
        System.out.println("rozmiar listy" + temp.size());

        for (int i = 0; i < 150; i++) {
            System.out.print(getRandomNumber2() + "-");
        }
    }
    private static int getRandomNumber(List list){
        Random random = new Random();
        return random.nextInt(list.size() );
    }
    private static int getRandomNumber2() {
        Random random = new Random();
        return random.nextInt(2);
    }


}


