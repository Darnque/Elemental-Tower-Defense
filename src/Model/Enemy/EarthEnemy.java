package Model.Enemy;

import java.awt.*;

/**
 * Earth type of the enemy
 *
 * @author Sebahattin Utku Sezer
 * @date 25.12.2019
 */
public class EarthEnemy extends Enemy {

    //Variables
    private int level;

    /**
     * Constructor
     * @param level
     */
    public EarthEnemy( int level ) {
        super( level );
        this.level = level;
        setEnemyType( "earth" );
        setEarthEnemyImage();
        setEarthEnemySize();
    }

    /**
     * Sets the image of the enemy according to its level
     */
    public void setEarthEnemyImage() {

        if (getLevel() == 1) {
            super.setImage("/earthEnemy1.png");

        } else {
            super.setImage("/earthEnemy2.png");
        }
    }

    /**
     * Sets the size of the enemy
     */
    public void setEarthEnemySize() { setSize(new Dimension(69, 77)); }

}
