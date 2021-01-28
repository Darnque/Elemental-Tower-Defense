package Model.Enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Extends Rectangle and determines enemies properties
 *
 * @author Sebahattin Utku Sezer
 * @date 23.12.2019
 */
public class Enemy extends Rectangle {

    //Variables
    private int health;
    private int speed;
    private String enemyType;
    private BufferedImage enemyImage;
    private int level;

    /**
     * Constructor
     * @param level
     */
    public Enemy( int level )
    {
        setSpeed( 50 + level );
        setHealth( 15 + ( 5 * level ) );
        setSpawnLocation(35,71);
        this.level = level;
    }
    // -----------------------------------Get Methods-----------------------------------------

    /**
     * Gets health of the enemy
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets speed of the enemy
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets level of the enemy
     * @return level
     */
    public int getLevel() { return level; }

    /**
     * Gets type of the enemy
     * @return enemy type
     */
    public String getEnemyType() {
        return enemyType;
    }

    /**
     * Gets position of enemy
     * @return point of position
     */
    public Point getPosition() { return getLocation(); }

    /**
     * Gets the Image
     * @return image
     */
    public BufferedImage getImage() { return enemyImage;}



    // -----------------------------------Set Methods-----------------------------------------

    /**
     * Sets the image of the enemy
     * @param path
     */
    public void setImage( String path ) {

        //Image variable
        BufferedImage image = null;

        try {
            //Gets the image from the path
            image = ImageIO.read(getClass().getResourceAsStream( path ) );
        }
        catch ( IOException e ){
            e.printStackTrace();
        }
        //Sets the image
        enemyImage = image;
    }

    /**
     * Sets the health
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets the level
     * @param level
     */
    public void setLevel( int level) {this.level = level;}

    /**
     * Sets the enemy type
     * @param type
     */
    public void setEnemyType(String type){enemyType = type;}

    /**
     * Sets the speed
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //////////////////////////////////////////////////////////methods////////////////////////////////////////////////////////////

    /**
     * Sets the spawn location
     * @param x
     * @param y
     */
    public void setSpawnLocation( int x, int y ) {
        this.setLocation( x, y );
    }

    /**
     * Sets the new position of the enemy
     * @param x
     * @param y
     */
    public void setNewPosition(int x, int y) {
        setLocation( x, y );
    }


    /**
     * Updates the movement of the enemy along the map
     */
    public void updateMovement() {


        if ( this.getLocation().x <= 80 && this.getLocation().y <= 71 ) {
            this.setNewPosition( ( this.getLocation().x + this.speed ), this.getLocation().y );
        }
        else if ( ( this.getLocation().x > 80 && this.getLocation().x < 160) && this.getLocation().y <= 625 ) {
            this.setNewPosition( ( this.getLocation().x ), this.getLocation().y + this.speed );
        }
        else if ( this.getLocation().x <= 230 && (this.getLocation().y >= 625  ) ) {
            this.setNewPosition( ( this.getLocation().x + this.speed ), this.getLocation().y );
        }
        else if ( (this.getLocation().x > 230 && this.getLocation().x < 320) && this.getLocation().y > 71  ) {
            this.setNewPosition( this.getLocation().x, ( this.getLocation().y - this.speed ) );
        }
        else if ( this.getLocation().x <= 387 && this.getLocation().y <= 71 ) {
            this.setNewPosition( ( this.getLocation().x + this.speed ), this.getLocation().y );
        }
        else if ( (this.getLocation().x > 387 && this.getLocation().x < 490) && this.getLocation().y <= 625 ) {
            this.setNewPosition( ( this.getLocation().x ), this.getLocation().y + this.speed );
        }
        else if ( this.getLocation().x <= 530 && this.getLocation().y >= 625 ) {
            this.setNewPosition( ( this.getLocation().x + this.speed ), this.getLocation().y );
        }
        else if ( (this.getLocation().x > 530 && this.getLocation().x < 635 ) && this.getLocation().y > 71 ) {
            this.setNewPosition( ( this.getLocation().x ), this.getLocation().y - this.speed );
        }
        else if ( this.getLocation().x <= 675 && this.getLocation().y <= 71 ) {
            this.setNewPosition( ( this.getLocation().x + this.speed ), this.getLocation().y );
        }
        else if ( ( this.getLocation().x > 675 && this.getLocation().x < 795 ) && this.getLocation().y <= 625 ) {
            this.setNewPosition( ( this.getLocation().x ), this.getLocation().y + this.speed );
        }
        else if ( this.getLocation().x <= 835 && this.getLocation().y >= 625 ) {
            this.setNewPosition( ( this.getLocation().x + this.speed ), this.getLocation().y );
        }
        else if ( (this.getLocation().x > 835 && this.getLocation().x < 950) && this.getLocation().y >= 72 ) {
            this.setNewPosition( ( this.getLocation().x ), this.getLocation().y - this.speed );
        }
        else if ( this.getLocation().x <= 985 && this.getLocation().y <= 71 ) {
            this.setNewPosition( ( this.getLocation().x + this.speed ), this.getLocation().y );
        }
        else if ( this.getLocation().x > 985 && this.getLocation().y <= 625 ) {
            this.setNewPosition( ( this.getLocation().x ), this.getLocation().y + this.speed );
        }
        else if ( this.getLocation().x <= 1048 && this.getLocation().y >= 625 ) {
            this.setNewPosition( ( this.getLocation().x + this.speed ), this.getLocation().y );
        }


    }


}

