package Model.Tower;

import java.awt.*;

/**
 * Extends the Tower class and create features of FireTower Class
 *
 * @author Gökhan Taş
 * @date 24.12.2019
 */
public class FireTower extends Tower {

    /**
     * Constructor
     */
    public FireTower() {
        super("151");
        setFireTowerImage();
        setFireTowerSize();
    }

    /**
     * Sets the image of fire tower
     */
    public void setFireTowerImage() {

        if ( getLevel() == 1 ) {
            super.setImage( "/fireTower1.png" );
        }
        else if (getLevel() == 2) {
            super.setImage( "/fireTower2.png" );
        }
        else {
            super.setImage("/fireTower3.png");
        }
    }

    /**
     * Sets the size of fire tower
     */
    public void setFireTowerSize() {
        setSize(new Dimension(35, 50));
    }

    @Override
    public void upgradeTower() {
        super.upgradeTower();
        setFireTowerImage();
    }
}
