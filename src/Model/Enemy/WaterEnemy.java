package Model.Enemy;

import java.awt.*;

/**
 * Poison type of the enemy
 *
 * @author Sebahattin Utku Sezer
 * @date 25.12.2019
 */
public class WaterEnemy extends Enemy{

    //Variables
    private int level;

    /**
     * Constructor
     * @param level
     */
    public WaterEnemy( int level ) {
        super(level);
        this.level = level;
        setEnemyType("water");
        setWaterEnemyImage();
        setWaterEnemySize();
    }

    /**
     * Sets the image of the enemy according to its level
     */
    public void setWaterEnemyImage() {

        if ( level == 1 ) {
            super.setImage( "/waterEnemy1.png" );
        }
        else {
            super.setImage( "/waterEnemy2.png" );
        }
    }

    /**
     * Sets the size of the enemy
     */
    public void setWaterEnemySize() { setSize(new Dimension(69, 77)); }

}
