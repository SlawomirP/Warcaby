import draughtBoard.DraughtBoard;
import draughtBoard.DraughtsBoardObject;

import java.util.List;
import java.util.Random;

public class Tests {

    public static void main(String[] args) {

//        int [] test = new int[10];
//        for (int i = 0; i < test.length; i++) {
//            test [i] = i + 1;
//        }
//
//        // pętla do przerwania
//        for (int i = 0; i < test.length; i++) {
//            if (test[i] == 5) {
//                break; // Przerwanie pętli, gdy wartość w tablicy równa się 5
//            }
//            System.out.println(test[i]);
//        }


        System.out.println(test(7,8,1,2));


















    }
    public static boolean test(int pawnRow, int pawnColumn, int squareRow, int squareColumn) {
        return ((pawnRow>squareRow && pawnColumn>squareColumn) || (pawnRow>squareRow && pawnColumn<squareColumn) || (pawnRow<squareRow && pawnColumn>squareColumn) || (pawnRow<squareRow && pawnColumn<squareColumn));

    }

//        Random random = new Random();
//
//        DraughtBoard board = new DraughtBoard();
//        board.addIndexesToPawn();
//        List<DraughtsBoardObject> temp = board.getCompPawnsList();
//        System.out.println("rozmiar listy" + temp.size());
//
//        for (int i = 0; i < 150; i++) {
//            System.out.print(getRandomNumber2() + "-");
//        }
//    }
//    private static int getRandomNumber(List list){
//        Random random = new Random();
//        return random.nextInt(list.size() );
//    }
//    private static int getRandomNumber2() {
//        Random random = new Random();
//        return random.nextInt(2);
//    }


}


