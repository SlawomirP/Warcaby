package comments;

public class BoardText {

    public static final String PLAYER_MARK ="  O  " ;
    public static final String PLAYER_KING_MARK =" |O| " ;
    public static final String COMP_MARK ="  X  " ;
    public static final String COMP_KING_MARK =" |X| " ;
    public static final String EMPTY_SQUARE ="     " ;
    public static final String AVAILABLE_SQUARE ="|   |" ;
    public static final String NOT_ALLOWED_OPERATION ="This operation is not allowed";
    public static final String RULES ="Zasady gry w warcaby to:\n" +
            "--- w tej wersji grę rozpczyna gracz - Twoje pionki to -> 0 ---\n" +
            "- granie na ciemnych polach planszy do warcabów\n" +
            "- celem jest zbicie wszystkich pionków przeciwnika\n" +
            "- piony poruszają się do przodu tylko o jedno pole po przekątnej\n" +
            "- zbicie odbywa się po przekątnej przeskakując przez pionek przeciwnika na puste pole\n" +
            "- podczas jednego ruchu tym samym pionkiem można zbić więcej niż jeden pion\n" +
            "- po dojściu pionu do ostatniego rzędu na planszy do warcabów po stronie przeciwnika staje się on damką\n" +
            "- damkom przysługuje możliwość poruszania o dowolną liczbę pól po przekątnej\n";


    public static final String PLAYER_INSTRUCTION_PAWN = "Enter the coordinates of the pawn and confirm with \"Enter\" - (X,Y -> e.g. 6,1)";
    public static final String PLAYER_INSTRUCTION_SQUARE = "Enter the coordinates of the square on which you want to place the pawn and confirm with \"Enter\" - (X,Y -> e.g. 6,5)";
    public static final String NO_MOVE_AVAILABLE = "Comp has no available moves.";
}
