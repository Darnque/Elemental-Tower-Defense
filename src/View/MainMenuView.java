package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class for main menu frame
 *
 * @author Osman Can Yıldız
 * @date 01.12.2019
 */
public class MainMenuView extends JPanel {

    //Variables
    private JButton startButton;
    private JButton howToPlayButton;
    private JButton quitButton;
    private JButton settingsButton;
    private JButton creditsButton;

    //Images
    private Image startImg;
    private Image howToPlayImg;
    private Image settingsImg;
    private Image creditsImg;
    private Image quitImg;

    private BufferedImage imageOfMenu;  //background image

    /**
     * Constructor
     */
    public MainMenuView(){

        setLayout(null);

        setComponents();
        addComponents();
        setImagesOfMenu(imageOfMenu, "/menu.jpg");

    }

    /**
     * Sets the components
     */
    public void setComponents(){

        startButton = new JButton();
        startButton.setPreferredSize(new Dimension(199, 52));
        startButton.setName("Play");
        startImg = new ImageIcon(this.getClass().getResource("/play_button.png")).getImage();
        startButton.setIcon(new ImageIcon((startImg)));
        startButton.setLayout(null);

        howToPlayButton= new JButton();
        howToPlayButton.setName("How To Play");
        howToPlayImg = new ImageIcon(this.getClass().getResource("/howToPlay_button.png")).getImage();
        howToPlayButton.setIcon(new ImageIcon((howToPlayImg)));
        howToPlayButton.setLayout(null);

        settingsButton = new JButton();
        settingsButton.setName("Settings");
        settingsImg = new ImageIcon(this.getClass().getResource("/settings_button.png")).getImage();
        settingsButton.setIcon(new ImageIcon((settingsImg)));
        settingsButton.setLayout(null);

        creditsButton = new JButton();
        creditsButton.setName("Credits");
        creditsImg = new ImageIcon(this.getClass().getResource("/credits_button.png")).getImage();
        creditsButton.setIcon(new ImageIcon((creditsImg)));
        creditsButton.setLayout(null);

        quitButton = new JButton();
        quitButton.setName("Quit");
        quitImg = new ImageIcon(this.getClass().getResource("/quit_button.png")).getImage();
        quitButton.setIcon(new ImageIcon((quitImg)));
        quitButton.setLayout(null);


    }

    /**
     * Adds the Components
     */
    public void addComponents(){

        startButton.setBounds(556, 300, 167, 56);
        howToPlayButton.setBounds(556, 399, 167, 56);
        settingsButton.setBounds(556, 486, 167, 56);
        creditsButton.setBounds(556, 574, 167, 56);
        quitButton.setBounds(555, 660, 167, 56);

        add(startButton);
        add(howToPlayButton);
        add(settingsButton);
        add(creditsButton);
        add(quitButton);
    }

    /**
     * Adds the action listeners
     * @param listener
     */
    public void addActionListenerMainMenu(ActionListener listener){
        startButton.addActionListener(listener);
        howToPlayButton.addActionListener(listener);
        settingsButton.addActionListener(listener);
        creditsButton.addActionListener(listener);
        quitButton.addActionListener(listener);
    }

    /**
     * Sets the images of main menu
     * @param image
     * @param path
     */
    public void setImagesOfMenu(BufferedImage image, String path){
        try {
            //sets image to given picture path
            imageOfMenu = ImageIO.read(getClass().getResourceAsStream("/menu.jpg"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Paints the components
     * @param g
     */
    @Override public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imageOfMenu, getX(), getY(),
                getSize().width, getSize().height, null);

    }


}
