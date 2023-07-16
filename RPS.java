import java.util.Scanner;

public class RPS extends RPSAbstract {
    // Messages for the game.
    protected static final String GAME_NOT_IMPLEMENTED =
            "Game not yet implemented.";
    /**
     * Construct a new instance of RPS with the given possible moves.
     *
     * @param moves all possible moves in the game.
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            System.arraycopy(args, 0, moves, 0, args.length);
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);
    System.out.println(PROMPT_MOVE);
    while(in.hasNext()) {
        String playermove = in.next();
        if (playermove.equals(QUIT)) {
            game.displayStats();
            in.close();
            return;
        }
        else {
            game.playRPS(playermove, game.genCPUMove());
        }
        System.out.println(PROMPT_MOVE);
    }
        // While user does not input "q", play game
         // remove this

        // TODO: Insert the code to play the game.
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written
        // to do most of the work! And don't forget Javadoc.

        in.close();
    }

    @Override
    public int determineWinner(String playerMove, String cpuMove) {
        // TODO
        if(!isValidMove(cpuMove) || !isValidMove(playerMove)){
            return INVALID_INPUT_OUTCOME;
        }
        int playerIndex = 0;
        int cpuIndex = 0;
        for (int m = 0; m < possibleMoves.length; m++ ){
            if(cpuMove.equals(possibleMoves[m])){
                cpuIndex = m;
                break;
            }
        }
        for (int n = 0; n < possibleMoves.length; n++ ){
            if(playerMove.equals(possibleMoves[n])){
                playerIndex = n;
                break;
            }
        }
        if(playerIndex == cpuIndex){
            return TIE_OUTCOME;
        } 
        if(playerIndex == cpuIndex + 1 || (playerIndex == 0 && cpuIndex == possibleMoves.length - 1)){
            return CPU_WIN_OUTCOME;
        }
        if(cpuIndex == playerIndex + 1 || (cpuIndex == 0 && playerIndex == possibleMoves.length - 1)){
            return PLAYER_WIN_OUTCOME;
        }
        else {
            return TIE_OUTCOME;
        }
        
 // replace this when you implement the method
    }
}
