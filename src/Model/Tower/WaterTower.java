package Model.Tower;

import java.awt.*;

/**
 * Extends the Tower class and create features of WaterTower Class
 *
 * @author Gökhan Taş
 * @date 24.12.2019
 */
public class WaterTower extends Tower {

    /**
     * Constructor
     */
    public WaterTower() {
        super("169");
        setWaterTowerImage();
        setWaterTowerSize();
    }

    /**
     * Sets water tower's image
     */
    public void setWaterTowerImage() {

        if ( getLevel() == 1 ) {
            super.setImage( "/waterTower1.png" );
        }
        else if (getLevel() == 2) {
            super.setImage( "/waterTower2.png" );
        }
        else {
            super.setImage("/waterTower3.png");
        }
    }

    /**
     * Sets the size
     */
    public void setWaterTowerSize() {
        setSize(new Dimension(35, 50));
    }

    /**
     * Upgrades the tower
     */
    public void upgradeTower() {
        super.upgradeTower();
        setWaterTowerImage();
    }
}
