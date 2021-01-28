package Controller;
import Model.ModelManager;
import View.*;

/**
 * Class to control the game
 *
 * @author Osman Can Yıldız
 * @date 20.12.2019
 */
public class GameController {

    //Variables
    static private GameFrame gameFrame;
    static private ModelManager gameModel;

    static public MainMenuListener mainMenuListener;
    static public SessionListener sessionListener;

    /**
     * Constructor
     * @param gameFrame
     * @param gameModel
     */
    public GameController(GameFrame gameFrame, ModelManager gameModel){
        setViewAndModel(gameFrame, gameModel);
        setListeners();
    }

    /**
     * Sets the view and model
     * @param gameFrame
     * @param gameModel
     */
    public void setViewAndModel(GameFrame gameFrame, ModelManager gameModel)
    {
        this.gameFrame = gameFrame;
        this.gameModel = gameModel;
    }

    /**
     * Sets the main menu listeners
     */
    public void setListeners() {
        mainMenuListener = new MainMenuListener();
        GameController.gameFrame.addActionListenerMainMenu(mainMenuListener);

        sessionListener = new SessionListener();

    }

    /**
     * Gets the game frame
     * @return game frame
     */
    static public GameFrame getGameFrame(){
        return gameFrame;
    }

    /**
     * Returns the game model
     * @return game model
     */
    static public ModelManager getGameModel() {
        return gameModel;}
}
