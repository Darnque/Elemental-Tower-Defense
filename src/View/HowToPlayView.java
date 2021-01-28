package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class for how to play frame
 *
 * @author Osman Can Yıldız
 * @date 01.12.2019
 */
public class HowToPlayView extends JPanel{

    //Variables
    private JButton goToMenu_button;
    private Image goToMenu_img;
    private BufferedImage imageOfHowToPlay;  //background image

    /**
     * Constructor
     */
    public HowToPlayView() {
        setComponents();
        addComponent();
    }

    /**
     * Creates the components
     */
    public void setComponents()
    {
        // go to menu button
        goToMenu_button = new JButton();
        goToMenu_button.setPreferredSize(new Dimension(199, 52));
        goToMenu_button.setName("Go To Menu");
        goToMenu_img = new ImageIcon(this.getClass().getResource("/goToMenu_button.png")).getImage();
        goToMenu_button.setIcon(new ImageIcon((goToMenu_img)));

        setLayout(null);
        goToMenu_button.setLayout(null);

        setImagesOfHowToPlay(imageOfHowToPlay, "/howToPlay.jpg");
    }

    /**
     * Adds the components
     */
    public void addComponent()
    {
        add(goToMenu_button);
        goToMenu_button.setBounds(976, 688, 191, 50);
    }

    /**
     * Sets the images of how to play frame
     * @param image
     * @param path
     */
    public void setImagesOfHowToPlay(BufferedImage image, String path){
        try {
            //sets image to given picture path
            imageOfHowToPlay = ImageIO.read(getClass().getResourceAsStream("/howToPlay.jpg"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Adds action listener to how to play frame
     * @param listener
     */
    public void addActionListenerMainMenu(ActionListener listener){
        goToMenu_button.addActionListener(listener);
    }

    /**
     * Paints the components
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imageOfHowToPlay, getX(), getY(),
                getSize().width, getSize().height, null);

    }
}
