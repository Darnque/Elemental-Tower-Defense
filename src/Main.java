import Controller.*;
import Model.ModelManager;
import View.*;

/**
 * Main class for the project
 * @author Osmancan Yıldız
 * @date 01.12.2019
 */
public class Main {

    public static GameFrame gameFrame = new GameFrame();
    public static ModelManager modelManager = new ModelManager();

    public static void main(String[] args){

        GameController gameController = new GameController(gameFrame, modelManager);
        gameFrame.setVisible(true);
    }
}
