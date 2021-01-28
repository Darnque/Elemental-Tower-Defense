    package View;

    import Controller.MyListener;
import Controller.PlayMusic;
import Model.Enemy.*;
import Model.Player;
import Model.Tower.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

    /**
     * Extends the JPanel and contains features for game scenes
     *
     * @author Gökhan Taş
     * @author Bedirhan Sakinoğlu
     * @date 25.12.2019
     */
    public class GameSceneView extends JPanel {

        //Variables
        static private JPanel gamePanel;  //panel on which the actual game will take place

        static private Player player;
        static private boolean flag = true;
        static private BufferedImage gameSceneBackgroundImage;

        static private BufferedImage towerEarth;
        static private BufferedImage towerElectric;
        static private BufferedImage towerFire;
        static private BufferedImage towerWater;
        static private BufferedImage towerPoison;
        static public PlayMusic music;

        static private JButton tile;
        static private JButton target;

        static private boolean checkWater;
        static private boolean checkFire;
        static private boolean checkEarth;
        static private boolean checkElectric;
        static private boolean checkPoison;

        static private JButton infoHealth;
        static private JButton infoCoin;
        static private JButton infoLevel;
        static private JButton infoScore;
        static private JButton infoType;

        static private ArrayList<Enemy> enemyList;
        static private ArrayList<JButton> tileList;

        static private ArrayList<Tower> listOfTowers;

        static private ArrayList<TowerFire> listOfTowerFire;

        static private ArrayList<EarthEnemy> listOfEarthEnemies;
        static private ArrayList<FireEnemy> listOfFireEnemies;
        static private ArrayList<WaterEnemy> listOfWaterEnemies;
        static private ArrayList<PoisonEnemy> listOfPoisonEnemies;
        static private ArrayList<ElectricEnemy> listOfElectricEnemies;

        static private ArrayList<TowerFire> getListOfTowerFire;
        static private ArrayList<String>listOfClickedButtons = new ArrayList<>();

        /**
         * Constructor
         */
        public GameSceneView() {
            player = new Player();
            setLayout(new BorderLayout());
            setImage();
            setComponents();
            addComponents();

            setBackground(new Color(41, 37, 37));
            //setOpaque(false);
        }

        // -----------------------------------Set Methods-----------------------------------------
        public void setComponents() {
            tileList = new ArrayList<>();
            gamePanel = new JPanel(new GridLayout(11, 17, 10, 5));
            gamePanel.setOpaque(false);

            ActionListener listener = new MyListener();

            for (int i = 0; i < 187; i++) {
                tile = new JButton();
                tile.setName(i + "");
                tileList.add(tile);

                // 16 = health, 33 = level, 50 = coin, 67 = enemy type, 84 = score,
                if (i == 16 ) {
                    infoHealth = tile;
                    infoHealth.setText("" + player.getHealth());
                    infoHealth.setForeground(Color.WHITE);
                    infoHealth.setBackground(new Color(67, 51, 17));
                    infoHealth.setVisible(true);
                    gamePanel.add(infoHealth);
                    validate();
                }
                else if(i == 33) {
                    infoLevel = tile;
                    infoLevel.setText("" + player.getLevel());
                    infoLevel.setForeground(Color.WHITE);
                    infoLevel.setBackground(new Color(67, 51, 17));
                    infoLevel.setVisible(true);
                    gamePanel.add(infoLevel);
                    validate();
                }
                else if(i == 50) {
                    infoCoin = tile;
                    infoCoin.setText("" + player.getCoins());
                    infoCoin.setForeground(Color.WHITE);
                    infoCoin.setBackground(new Color(67, 51, 17));
                    infoCoin.setVisible(true);
                    gamePanel.add(infoCoin);
                    validate();
                }
                else if(i == 67) {
                    infoType = tile;
                    infoType.setText("" + player.getType());
                    infoType.setForeground(Color.WHITE);
                    infoType.setBackground(new Color(67, 51, 17));
                    infoType.setVisible(true);
                    gamePanel.add(infoType);
                    validate();
                }
                else if(i == 84) {
                    infoScore = tile;
                    infoScore.setText("" + player.getScore());
                    infoScore.setForeground(Color.WHITE);
                    infoScore.setBackground(new Color(67, 51, 17));
                    infoScore.setVisible(true);
                    gamePanel.add(infoScore);
                    validate();
                }
                else {
                    tile.setOpaque(false);
                    tile.setContentAreaFilled(false);
                    tile.setBorderPainted(false);
                    gamePanel.add(tile);

                    if( (i >= 0 && i <= 14) || ( i >= 170 && i <= 184 ) ) {
                        tile.addActionListener(listener);
                    }

                    else if ( i > 150 && ( i%17 == 15 || i%17 == 16 ) ){
                        tile.addActionListener(listener);
                    }

                    else if( i%17 == 16 ){}

                    else if( (i%17)%2 == 0 ){

                        if( i >= 17 && i <= 29 && i%4 == 1 ){}
                        else if( i >= 155 && i <= 167 && i%4 == 3 ){}

                        else {
                            tile.addActionListener(listener);
                        }
                    }
                }
            }

            // Initialize the lists
            listOfEarthEnemies = new ArrayList<>();
            listOfElectricEnemies = new ArrayList<>();
            listOfPoisonEnemies = new ArrayList<>();
            listOfWaterEnemies = new ArrayList<>();
            listOfFireEnemies = new ArrayList<>();
            listOfTowerFire = new ArrayList<>();

            // Adds the musics
            music = new PlayMusic();
            music.playMainMenu();

            // Initialize the list of towers
            listOfTowers = new ArrayList<Tower>();
        }

        /**
         * Sets the health of player
         * @param health
         */
        public static void setInfoHealth( int health ) {
            infoHealth.setText( "" + health );
        }

        /**
         * Sets the level of game which indicates the stage of the game
         * @param level
         */
        public static void setInfoLevel( int level ) {
            infoLevel.setText(""+level);
        }

        /**
         * Sets the type of enemy wave
         */
        public static void setInfoType() {
            infoType.setText(player.getType());
        }

        /**
         * Sets the images of instances
         */
        public void setImage() {
            try {
                //sets image to given picture path
                gameSceneBackgroundImage = ImageIO.read(getClass().getResourceAsStream("/backgroundtest.jpg"));
                towerEarth = ImageIO.read(getClass().getResourceAsStream("/earthTower1.png"));
                towerFire = ImageIO.read(getClass().getResourceAsStream("/fireTower1.png"));
                towerPoison = ImageIO.read(getClass().getResourceAsStream("/poisonTower1.png"));
                towerWater= ImageIO.read(getClass().getResourceAsStream("/waterTower1.png"));
                towerElectric = ImageIO.read(getClass().getResourceAsStream("/electricTower1.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Sets the checkWater
         * @param checkWater
         */
        public static void setCheckWater(boolean checkWater) {
            GameSceneView.checkWater = checkWater;
        }

        /**
         * Sets checkFire
         * @param checkFire
         */
        public static void setCheckFire(boolean checkFire) {
            GameSceneView.checkFire = checkFire;
        }

        /**
         * Sets the checkEarth
         * @param checkEarth
         */
        public static void setCheckEarth(boolean checkEarth) {
            GameSceneView.checkEarth = checkEarth;
        }

        /**
         * Sets the checkElectric
         * @param checkElectric
         */
        public static void setCheckElectric(boolean checkElectric) {
            GameSceneView.checkElectric = checkElectric;
        }

        /**
         * Sets the checkPoison
         * @param checkPoison
         */
        public static void setCheckPoison(boolean checkPoison) {
            GameSceneView.checkPoison = checkPoison;
        }

        /**
         * Sets the target button
         * @param target
         */
        public static void setTarget(JButton target) {
            GameSceneView.target = target;
        }

        // -----------------------------------Get Methods-----------------------------------------
        /**
         * Gets the player to reach information
         * @return player
         */
        public static Player getPlayer() {
            return player;
        }

        /**
         * Gets the flag
         * @return flag
         */
        public static boolean getFlag() {
            return flag;
        }

        /**
         * Gets the coins
         * @return infoCoin
         */
        public static JButton getInfoCoin() {
            return infoCoin;
        }

        /**
         * Gets the score
         * @return infoScore
         */
        public static JButton getInfoScore() {
            return infoScore;
        }

        /**
         * Gets the list of clicked buttons
         * @return listOfClickedButtons
         */
        public static ArrayList<String> getListOfClickedButtons() {
            return listOfClickedButtons;
        }

        /**
         * Gets the tiles in the list
         * @return tileList
         */
        public static ArrayList<JButton> getTileList() {
            return tileList;
        }

        /**
         * Gets the towers in the list
         * @return listOfTowers
         */
        public static ArrayList<Tower> getListOfTowers() {
            return listOfTowers;
        }

        //---------------------Other Methods------------------------------------------------

        /**
         * Displays the message at the end of the game
         */
        public static void popGameOver(){
            if ( SettingsView.getMusicFlag() ) {
                music.stopBattle();
            }
            music.playGameOver();
            JOptionPane.showMessageDialog(null, "Game Is Over! Your Score: " + player.getScore(),
                    "GameOver!", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        /**
         * Updates the earth enemy list
         * @param listOfEarthEnemies
         */
        public void updateListOfEarthEnemies(ArrayList<EarthEnemy> listOfEarthEnemies) {
            GameSceneView.listOfEarthEnemies = listOfEarthEnemies;
        }

        /**
         * Updates the water enemy list
         * @param listOfWaterEnemies
         */
        public void updateListOfWaterEnemies(ArrayList<WaterEnemy> listOfWaterEnemies) {
            GameSceneView.listOfWaterEnemies = listOfWaterEnemies;
        }

        /**
         * Updates the fire enemy list
         * @param listOfFireEnemies
         */
        public void updateListOfFireEnemies(ArrayList<FireEnemy> listOfFireEnemies) {
            GameSceneView.listOfFireEnemies = listOfFireEnemies;
        }

        /**
         * Updates the poison enemy list
         * @param listOfPoisonEnemies
         */
        public void updateListOfPoisonEnemies(ArrayList<PoisonEnemy> listOfPoisonEnemies) {
            GameSceneView.listOfPoisonEnemies = listOfPoisonEnemies;
        }

        /**
         * Updates the electric enemy list
         * @param listOfElectricEnemies
         */
        public void updateListOfElectricEnemies(ArrayList<ElectricEnemy> listOfElectricEnemies) {
            GameSceneView.listOfElectricEnemies = listOfElectricEnemies;
        }

        /**
         * Updates the fire of tower's list
         * @param towerFire
         */
        public void updateListOfTowerFire( ArrayList<TowerFire> towerFire ) {
            GameSceneView.listOfTowerFire = towerFire;
        }

        /**
         * Adds the components to game panel
         */
        public void addComponents() {

            add(gamePanel);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

             // Variables
             PoisonTower poisonTower;
             ElectricTower electricTower;
             FireTower fireTower;
             WaterTower waterTower;
             EarthTower earthTower;

            g.drawImage(gameSceneBackgroundImage, getX(), getY(), getSize().width, getSize().height, null);

            // Drawing images of towers at bottom right corner
            g.drawImage(towerEarth, 1235, 570, 30, 55, null );
            g.drawImage(towerElectric, 1160, 715, 30, 55, null );
            g.drawImage(towerFire, 1160, 570, 30, 55, null );
            g.drawImage(towerPoison, 1160, 645, 30, 55, null );
            g.drawImage(towerWater, 1235, 645, 30, 55, null);

            // If statement to check adding poisonTower
            if(checkPoison == true) {
                poisonTower = new PoisonTower();
                poisonTower.setLocation(target.getX(), target.getY());
                poisonTower.setTowerName(target.getName());
                //listOfPoisonTower.add(poisonTower);
                listOfTowers.add(poisonTower);
                checkPoison = false;
            }

            // If statement to check adding waterTower
            else if(checkWater == true) {
                waterTower = new WaterTower();
                waterTower.setLocation(target.getX(), target.getY());
                waterTower.setTowerName(target.getName());
                //listOfWaterTower.add(waterTower);
                listOfTowers.add(waterTower);
                checkWater = false;
            }

            // If statement to check adding fireTower
            else if(checkFire == true) {
                fireTower = new FireTower();
                fireTower.setLocation(target.getX(), target.getY());
                fireTower.setTowerName(target.getName());
                //listOfFireTower.add(fireTower);
                listOfTowers.add(fireTower);
                checkFire = false;
            }

            // If statement to check adding earthTower
            else if(checkEarth == true) {
                earthTower = new EarthTower();
                earthTower.setLocation(target.getX(), target.getY());
                earthTower.setTowerName(target.getName());
                //listOfEarthTower.add(earthTower);
                listOfTowers.add(earthTower);
                checkEarth = false;
            }

            // If statement to check adding electricTower
            else if(checkElectric == true) {
                electricTower = new ElectricTower();
                electricTower.setLocation(target.getX(), target.getY());
                electricTower.setTowerName(target.getName());
                //listOfElectricTower.add(electricTower);
                listOfTowers.add(electricTower);
                checkElectric = false;
            }

            //-------------------------------For Loops to draw all enemies----------------------------------
            for (EarthEnemy enemies : listOfEarthEnemies) {
                g.drawImage(enemies.getImage(), enemies.getLocation().x, enemies.getLocation().y,
                        enemies.getSize().width, enemies.getSize().height, null);
            }
            for (WaterEnemy enemies : listOfWaterEnemies) {
                g.drawImage(enemies.getImage(), enemies.getLocation().x, enemies.getLocation().y,
                        enemies.getSize().width, enemies.getSize().height, null);
            }
            for (ElectricEnemy enemies : listOfElectricEnemies) {
                g.drawImage(enemies.getImage(), enemies.getLocation().x, enemies.getLocation().y,
                        enemies.getSize().width, enemies.getSize().height, null);
            }
            for (PoisonEnemy enemies : listOfPoisonEnemies) {
                g.drawImage(enemies.getImage(), enemies.getLocation().x, enemies.getLocation().y,
                        enemies.getSize().width, enemies.getSize().height, null);
            }
            for (FireEnemy enemies : listOfFireEnemies) {
                g.drawImage(enemies.getImage(), enemies.getLocation().x, enemies.getLocation().y,
                        enemies.getSize().width, enemies.getSize().height, null);
            }

            //-------------------------------For Loops to draw all towers----------------------------------
            for (Tower towers: listOfTowers) {
                g.drawImage(towers.getImage(), towers.getLocation().x + 20, towers.getLocation().y,
                        towers.getSize().width, towers.getSize().height, null);
            }

            //-------------------------------For Loops to draw all fire of towers----------------------------------
            for( TowerFire towerFire: listOfTowerFire ) {
                g.drawImage(towerFire.getImage(), towerFire.getLocation().x, towerFire.getLocation().y,
                        towerFire.getSize().width, towerFire.getSize().height, null);
            }

            repaint();
            validate();
        }
    }