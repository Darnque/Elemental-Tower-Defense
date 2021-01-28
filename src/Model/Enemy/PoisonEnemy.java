package Model.Enemy;

import java.awt.*;

/**
 * Poison type of the enemy
 *
 * @author Sebahattin Utku Sezer
 * @date 25.12.2019
 */
public class PoisonEnemy extends Enemy{

    //Variables
    private int level;

    /**
     * Constructor
     * @param level
     */
    public PoisonEnemy( int level ) {
        super( level );
        this.level = level;
        setEnemyType( "poison" );
        setPoisonEnemyImage();
        setPoisonEnemySize();
    }

    /**
     * Sets the image of the enemy according to its level
     */
    public void setPoisonEnemyImage() {

        if ( level == 1 ) {
            super.setImage( "/poisonEnemy1.png" );
        }
        else {
            super.setImage( "/poisonEnemy2.png" );
        }
    }

    /**
     * Sets the size of the enemy
     */
    public void setPoisonEnemySize() { setSize(new Dimension(69, 77) ); }

}
