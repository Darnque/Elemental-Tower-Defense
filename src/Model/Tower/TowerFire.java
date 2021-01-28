package Model.Tower;

import Model.Enemy.Enemy;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Extends the rectangle class and create TowerFire classes futures
 *
 * @author Bedirhan Sakinoğlu
 * @date 24.12.2019
 */
public class TowerFire extends Rectangle{

    private int speed;
    private int damage;
    private String type;
    private BufferedImage image;
    private Enemy target;
    private double deltaX;
    private double deltaY;
    private Tower tower;

    /**
     * Constructor
     * @param tower
     */
    public TowerFire( Tower tower ) {
        setSpeed(15);
        type = tower.getTowerType();
        damage = tower.getDamage();
        setImage(image);
        this.tower = tower;
        setSize(15,15);
        setLocation( tower.getLocation().x + 100, tower.getLocation().y + 60 );
    }
    // -----------------------------------Get Methods-----------------------------------------

    /**
     * Gets the speed of fire
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets the image of fire
     * @return image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Gets damage according to tower's and enemy's element
     * @param target
     * @return damage
     */
    public int getDamage( Enemy target ) {

        //earthTower = 152, electricTower = 185, fireTower = 151, poisonTower = 168, waterTower = 169;

        // Adjust waterTower damage
        if( tower.getTowerType().equals("169") ){
            if( target.getEnemyType().equals("fire" )){
                return damage * 2;
            }
            else if( target.getEnemyType().equals("poison" ) ) {
                return damage / 2;
            }
        }

        // Adjust fireTower damage
        else if( tower.getTowerType().equals("151" ) ){
            if( target.getEnemyType().equals("water" ) ){
                return damage / 2 ;
            }
            else if( target.getEnemyType().equals("earth" ) ) {
                return damage * 2;
            }
        }

        // Adjust electricTower damage
        else if( tower.getTowerType().equals("185" ) ){
            if( target.getEnemyType().equals("earth" ) ){
                return damage / 2 ;
            }
            else if( target.getEnemyType().equals("water" ) ) {
                return damage * 2;
            }
        }

        // Adjust poisonTower damage
        else if( tower.getTowerType().equals("168" ) ) {
            if (target.getEnemyType().equals("water") ) {
                return damage / 2;
            } else if (target.getEnemyType().equals("fire") ) {
                return damage * 2;
            }
        }

        // Adjust earthTower damage
        else if( tower.getTowerType().equals("152" ) ){
            if( target.getEnemyType().equals("electric" ) ){
                return damage / 2 ;
            }
            else if( target.getEnemyType().equals("poison" ) ) {
                return damage * 2;
            }
        }

        return damage;
    }

    /**
     * Gets x location of the fire
     * @return x
     */
    public double getX(){
        return x;
    }

    /**
     * Gets y location of the fire
     * @return y
     */
    public double getY(){
        return y;
    }

    /**
     * Gets the position of fire
     * @return getLocation
     */
    public Point getPosition() { return getLocation(); }

    /**
     * Gets the target of fire
     * @return target
     */
    public Enemy getTarget() {
        return target;
    }

    // -----------------------------------Set Methods-----------------------------------------

    /**
     * Sets speed of fire
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Sets the damage of fire
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Sets the target of fire
     * @param target
     */
    public void setTarget(Enemy target) {
        this.target = target;
    }

    /**
     * Sets the image of fire
     * @param image
     */
    public void setImage(BufferedImage image) {

        // Variable
        BufferedImage imageOfTowerFire = null;
        try {
            //sets image to given picture path
            imageOfTowerFire = ImageIO.read(getClass().getResourceAsStream("/tower_laser.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // Sets the image to image of tower
        this.image = imageOfTowerFire;
    }

    /**
     * Updates the position of towerFire object
     */
    public void updateMovement()
    {
        determineDeltas();
        //takes into consideration factor step for X and Y axis
        int stepX = (int)(getSpeed()* deltaX);
        int stepY = (int)(getSpeed()* deltaY);

        //calculate new position
        int xLoc = this.getLocation().x + stepX;
        int yLoc = this.getLocation().y + stepY;

        System.out.println( tower.getLocation().x  + "  " +  tower.getLocation().y  );
        //sets new position
        this.setLocation( xLoc , yLoc );
    }

    /**
     * Calculates the direction that fire will go
     */
    public void determineDeltas()
    {
        deltaX = (target.getCenterX() - this.getLocation().x)/( Math.abs(target.getCenterX() - this.getLocation().x) + Math.abs(target.getCenterY() - this.getLocation().y) );
        deltaY = (target.getCenterY() - this.getLocation().y)/( Math.abs(target.getCenterX() - this.getLocation().x) + Math.abs(target.getCenterY() - this.getLocation().y) );
    }
}
