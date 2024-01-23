package draughtBoard;

public class DraughtsBoardObject {
    private String name;
    private boolean isAvailable;
    private boolean isPawn;
    private boolean isSquare;
    private boolean isPlayer1;
    private boolean comp;
    private boolean isKing;
    private int x;
    private int y;


    public DraughtsBoardObject(String name, boolean isAvailable, boolean isPawn, boolean isSquare, boolean isPlayer1, boolean isPlayer2, int x, int y) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.isPawn = isPawn;
        this.isSquare = isSquare;
        this.isPlayer1 = isPlayer1;
        this.comp = isPlayer2;
        this.isKing = false;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
