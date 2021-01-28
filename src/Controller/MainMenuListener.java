package Controller;

import View.GameSceneView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for Main Menu's listener
 *
 * @author Osman Can Yıldız
 * @date 01.12.2019
 */
public class MainMenuListener implements ActionListener {

    //Variables
    static private PlayMusic music = GameSceneView.music;

    @Override
    public void actionPerformed(ActionEvent e) {
        //gets name of clicked button
        String clickedButton = ((Component) e.getSource()).getName();

        //starts game after START GAME button clicked
        if (clickedButton == "Play")
        {

            GameController.getGameFrame().startGameSession();
            music.stopMainMenu();
            music.playBattle();
            GameController.sessionListener.setTimer(true);

        }
        else if (clickedButton == "How To Play")
        {
            GameController.getGameFrame().howToPlaySession();
            GameController.sessionListener.setTimer(false);
        }
        else if (clickedButton == "Settings")
        {
            GameController.getGameFrame().settingsSession();
            GameController.sessionListener.setTimer(false);
        }
        else if (clickedButton == "Credits")
        {
            GameController.getGameFrame().creditsSession();
            GameController.sessionListener.setTimer(false);
        }
        else if (clickedButton == "Go To Menu")
        {
            GameController.getGameFrame().mainMenuSession();
            GameController.sessionListener.setTimer(false);
        }
        //exits after QUIT button clicked
        else if (clickedButton == "Quit")
        {
            System.exit(0);
        }

    }
}
