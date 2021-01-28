package Model.Enemy;

import java.awt.*;

/**
 * Fire type of the enemy
 *
 * @author Sebahattin Utku Sezer
 * @date 25.12.2019
 */
public class FireEnemy extends Enemy{

    //Variables
    private int level;

    /**
     * Constructor
     * @param level
     */
    public FireEnemy(int level)
    {
        super(level);
        this.level = level;
        setEnemyType("fire");
        setFireEnemyImage();
        setFireEnemySize();
    }

    /**
     * Sets the image of the enemy according to its level
     */
    public void setFireEnemyImage() {

        if ( getLevel() == 1 ) {
            super.setImage( "/fireEnemy1.png" );
        }
        else {
            super.setImage( "/fireEnemy2.png" );
        }
    }

    /**
     * Sets the size of the enemy
     */
    public void setFireEnemySize() { setSize(new Dimension(69, 77)); }

}
