package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Class for game frame
 *
 * @author Osman Can Yıldız
 * @date 01.12.2019
 */
public class GameFrame extends JFrame {

    //Variables
    private JPanel cardPanel;  //to hold all the sub panels
    private CardLayout cardLayout = new CardLayout();

    private static Dimension dimension;  //for the size of the main frame


    private MainMenuView mainMenuView;
    private GameSceneView gameSceneView;  //panel on which the gameplay will tak place
    private CreditsView creditsView;
    private SettingsView settingsView;
    private HowToPlayView howToPlayView;

    /**
     * Constructor
     */
    public GameFrame(){

        this.setFocusable(true);

        //to define basic information about starting position of window on screen
        dimension = Toolkit.getDefaultToolkit().getScreenSize();

        this.setName("Elemental Tower Defense");
        this.setSize(1300,813);
        this.setResizable(false);

        //setting starting location of window on the screen
        this.setLocation(dimension.width/2 - this.getWidth()/2, dimension.height/2 - this.getHeight()/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);



        //initializing scene view panels

        mainMenuView = new MainMenuView();
        cardPanel.add(mainMenuView);

        gameSceneView = new GameSceneView();
        settingsView = new SettingsView();
        creditsView = new CreditsView();
        howToPlayView = new HowToPlayView();




        this.add(cardPanel);
        cardPanel.setVisible(true);


    }

    /**
     * Adds main menu action listeners
     * @param actionListenerMainMenu
     */
    public void addActionListenerMainMenu(ActionListener actionListenerMainMenu){
        mainMenuView.addActionListenerMainMenu(actionListenerMainMenu);
        settingsView.addActionListenerMainMenu(actionListenerMainMenu);
        creditsView.addActionListenerMainMenu(actionListenerMainMenu);
        howToPlayView.addActionListenerMainMenu(actionListenerMainMenu);
    }


    /**
     * Sets key listener to get key events from keyboard
     * @param keyListenerGame
     */
    public void addKeyListenerGame (KeyListener keyListenerGame)
    {
        this.addKeyListener(keyListenerGame);
    }

    /**
     * Starts the game session
     */
    public void startGameSession(){
        cardPanel.removeAll();
        cardPanel.add(gameSceneView);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    /**
     * Starts the main menu session
     */
    public void mainMenuSession(){
        cardPanel.removeAll();
        cardPanel.add(mainMenuView);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    /**
     * Starts the settings session
     */
    public void settingsSession(){
        cardPanel.removeAll();
        cardPanel.add(settingsView);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    /**
     * Starts the credits session
     */
    public void creditsSession(){
        cardPanel.removeAll();
        cardPanel.add(creditsView);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    /**
     * Starts the how to play session
     */
    public void howToPlaySession(){
        cardPanel.removeAll();
        cardPanel.add(howToPlayView);
        cardPanel.repaint();
        cardPanel.revalidate();
    }







    //getters
    public MainMenuView getMainMenuView(){return mainMenuView;}
    public GameSceneView getGameSceneView(){return gameSceneView;}
    public SettingsView getSettingsView(){return settingsView;}
    public CreditsView getCreditsView(){return creditsView;}
    public HowToPlayView getHowToPlayView(){return howToPlayView;}

}
