package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class for settings frame
 *
 * @author Osman Can Yıldız
 * @date 01.12.2019
 */
public class SettingsView extends JPanel{

    //Variables
    private JButton goToMenu_button;
    private JToggleButton music_button;
    private JToggleButton sound_button;
    private Image goToMenu_img;
    private Image on_button_img;
    private Image off_button_img;
    private BufferedImage imageOfSettings;  //background image

    private static boolean musicFlag = true;
    private static boolean soundFlag = true;

    /**
     * Constructor
     */
    public SettingsView()
    {
        setLayout(new GridBagLayout());
        setComponents();
        addComponent();
    }

    /**
     * Sets the components
     */
    public void setComponents()
    {
        on_button_img = new ImageIcon(this.getClass().getResource("/on_button.png")).getImage();
        off_button_img = new ImageIcon(this.getClass().getResource("/off_button.png")).getImage();

        goToMenu_button = new JButton();
        goToMenu_button.setPreferredSize(new Dimension(199, 52));
        goToMenu_button.setName("Go To Menu");
        goToMenu_img = new ImageIcon(this.getClass().getResource("/goToMenu_button.png")).getImage();
        goToMenu_button.setIcon(new ImageIcon((goToMenu_img)));

        setLayout(null);
        goToMenu_button.setLayout(null);

        music_button = new JToggleButton();
        music_button.setPreferredSize(new Dimension(199, 52));
        music_button.setName("Music Button");
        music_button.setIcon(new ImageIcon((on_button_img)));
        music_button.addActionListener( new myListener());

        sound_button = new JToggleButton();
        sound_button.setPreferredSize(new Dimension(199, 52));
        sound_button.setName("Fire Sound Button");
        sound_button.setIcon(new ImageIcon((on_button_img)));
        sound_button.addActionListener( new myListener() );

        setImagesOfSettings(imageOfSettings, "/settings.jpg");
    }

    /**
     * Adds the components
     */
    public void addComponent()
    {

        goToMenu_button.setBounds(976, 688, 191, 50);
        music_button.setBounds(600, 400, 80, 80);
        sound_button.setBounds(600, 500, 80, 80);
        add(music_button);
        add(sound_button);
        add(goToMenu_button);

    }

    /**
     * Sets the image of settings frame
     * @param image
     * @param path
     */
    public void setImagesOfSettings(BufferedImage image, String path){
        try {
            //sets image to given picture path
            imageOfSettings = ImageIO.read(getClass().getResourceAsStream("/settings.jpg"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Adds action listeners
     * @param listener
     */
    public void addActionListenerMainMenu(ActionListener listener){
        music_button.addActionListener(listener);
        goToMenu_button.addActionListener(listener);
        sound_button.addActionListener(listener);
    }

    /**
     * Draws the components
     * @param g
     */
    @Override public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imageOfSettings, getX(), getY(),
                getSize().width, getSize().height, null);

    }

    /**
     * Gets the music flag
     * @return music flag
     */
    public static boolean getMusicFlag() {
        return musicFlag;
    }

    /**
     * Gets the sound flag
     * @return sound flag
     */
    public static boolean getSoundFlag() {
        return soundFlag;
    }

    /**
     * Inner class to determine the actions of settings' buttons
     *
     * @author Sebahattin Utku Sezer
     * @date 25.12.2019
     */
    class myListener implements ActionListener {

        /**
         * Button clikcs
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            //On-Off music button
            if( source.equals(music_button) ) {
                musicFlag = !musicFlag;
                if ( musicFlag ) {
                    GameSceneView.music.playMainMenu(); //plays music
                    music_button.setIcon(new ImageIcon((on_button_img)));
                }
                else {
                    GameSceneView.music.stopMainMenu(); //stops music
                    music_button.setIcon(new ImageIcon((off_button_img)));
                }
            }
            //On-Off sound button
            if( source.equals(sound_button) ) {
                soundFlag = !soundFlag;
                if ( soundFlag ) {
                    sound_button.setIcon(new ImageIcon((on_button_img)));
                }
                else {
                    sound_button.setIcon(new ImageIcon((off_button_img)));
                }
            }

        }
    }

}
