package draughtBoard;

public class DraughtsBoardObject {
    private String name;
    private boolean isAvailable;
    private boolean isPawn;
    private boolean isSquare;
    private boolean isPlayer;
    private boolean isComp;
    private boolean isKing;

    private int x;
    private int y;

    public DraughtsBoardObject(String name, boolean isAvailable, boolean isPawn, boolean isSquare, boolean isPlayer, boolean isComp) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.isPawn = isPawn;
        this.isSquare = isSquare;
        this.isPlayer = isPlayer;
        this.isComp = isComp;
        this.isKing = false;
    }

    public void setIsPawn(boolean pawn) {
        isPawn = pawn;
    }

    public void setIsSquare(boolean square) {
        isSquare = square;
    }

    public boolean isSquare() {
        return isSquare;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public boolean isComp() {
        return isComp;
    }

    public void setIsPlayer(boolean player) {
        isPlayer = player;
    }

    public void setIsComp(boolean comp) {
        this.isComp = comp;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    // tymczasowe do usuniecia

    public String getInfoPionka() {
        return this.name + " " + "(" + this.x + ", " + this.y + ")";
    }
}
