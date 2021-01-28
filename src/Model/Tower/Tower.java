package Model.Tower;

import Model.Enemy.Enemy;
import Model.ModelManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Extends the rectangle class and create Tower classes' features
 *
 * @author Gökhan Taş
 * @date 24.12.2019
 */
public class Tower extends Rectangle{

    // Properties
    private String towerType;
    private int damage = 15;
    private int level = 1;
    private int range = 200;
    private BufferedImage towerImage;
    private String towerName;
    private String path;
    private Enemy target;
    private int timer;
    ArrayList<Enemy> enemyList;


    /**
     * Constructor
     * @param towerType
     */
    public Tower(String towerType) {
        this.towerType = towerType;
        setLevel(1);
        setRange(200);
        setDamage(damage);
        timer = 0;
        //setSize(new Dimension(40, 41));
    }

    // -----------------------------------Get Methods-----------------------------------------
    /**
     * Gets the tower type
     * @return towerType
     */
    public String getTowerType() {
        return towerType;
    }

    /**
     * Gets the tower level
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the range of the tower
     * @return range
     */
    public int getRange() {
        return range;
    }

    /**
     * Gets the damage of the tower
     * @return
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Gets the target for the tower
     * @return target
     */
    public Enemy getTarget() {
        return target;
    }

    /**
     * Gets the image of tower
     * @return towerImage
     */
    public BufferedImage getImage() {
        return towerImage;
    }

    /**
     * Gets the name of tower
     * @return towerName
     */
    public String getTowerName() {
        return towerName;
    }

    /**
     * Gets the timer for tower
     * @return timer
     */
    public int getTimer() {
        return timer;
    }


    // -----------------------------------Set Methods-----------------------------------------

    /**
     * Sets the damage of tower
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Sets the level of tower
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Sets the range of tower
     * @param range
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Sets the tower's name
     * @param towerName
     */
    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    /**
     * Sets the image of tower
     * @param path
     */
    public void setImage( String path )  {

        // Variable
        BufferedImage imageOfTower = null;
        this.path = path;
        try {
            //sets image to given picture path
            imageOfTower = ImageIO.read(getClass().getResourceAsStream(path));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // Sets the image to image of tower
        towerImage = imageOfTower;
    }

    /**
     * Sets the target for tower
     * @param target
     */
    public void setTarget(Enemy target) {
        this.target = target;
    }

    /**
     * Sets the timer
     * @param timer
     */
    public void setTimer(int timer) {
        this.timer = timer;
    }

    /**
     * Upgrades the tower by changing its level, range and damage
     */
    public void upgradeTower() {
        setLevel(getLevel() + 1);
        setRange(getRange() + 100);
        setDamage(getDamage() + 5);
    }

    /**
     * Checks whether there is an enemy in the range
     * @return boolean
     */
    public boolean checkIfInRange() {

        enemyList = ModelManager.getEnemyList();

        for(int t = 0 ; t < enemyList.size() ; t++) {
            if ( Math.pow( getRange(),2) > Math.pow(enemyList.get(t).getX()-getX(), 2) + Math.pow(enemyList.get(t).getY()- getY(), 2)) {
                setTarget( enemyList.get(t) );
                return true;
            }
        }
        System.out.println("nope");
        return false;
    }
}
