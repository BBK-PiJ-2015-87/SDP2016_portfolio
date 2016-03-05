/**
 * Created by Workstation on 05/03/16.
 */
public class GameImpl extends GameAbstractImpl {
    /**
     * Create a Game object.
     *
     * @param easy If easy is true the secret code will be
     *             revealed at all times when playing the game. If easy is
     *             false the secret code is not revealed until correctly guessed
     *             or the player runs out of turns.
     */
    public GameImpl(boolean easy) {
        super(easy);
    }

    /**
     * Run a one or more game sof mastermind, until the player
     * quits.
     */
    public void runGames() {

    }
}
