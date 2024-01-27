package draughtBoard;

public class DraughtsBoardObject {
    private String name;
    private boolean isAvailable;
    private boolean isPawn;
    private boolean isSquare;
    private boolean isPlayer;
    private boolean isComp;
    private boolean isKing;


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

    public boolean isPawn() {
        return isPawn;
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

    @Override
    public String toString() {
        return this.name;
    }
}
