package Model.Enemy;

import java.awt.*;

/**
 * Electric type of the enemy
 *
 * @author Sebahattin Utku Sezer
 * @date 25.12.2019
 */
public class ElectricEnemy extends Enemy{

    //Variables
    private int level;

    /**
     * Constructor
     * @param level
     */
    public ElectricEnemy( int level ) {
        super(level);
        this.level = level;
        setEnemyType( "electric" );
        setElectricEnemyImage();
        setElectricEnemySize();
    }

    /**
     * Sets the image of the enemy according to its level
     */
    public void setElectricEnemyImage() {

        if ( getLevel() == 1 ) {
            super.setImage( "/electricEnemy1.png" );
        }
        else {
            super.setImage( "/electricEnemy2.png" );
        }
    }

    /**
     * Sets the size of the enemy
     */
    public void setElectricEnemySize() { setSize( new Dimension(69, 77) ); }

}
