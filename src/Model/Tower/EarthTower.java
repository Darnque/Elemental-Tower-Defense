package Model.Tower;

import java.awt.*;

/**
 * Extends the Tower class and create features of EarthTower Class
 *
 * @author Gökhan Taş
 * @date 24.12.2019
 */
public class EarthTower extends Tower {

    /**
     * Constructor
     */
    public EarthTower() {
        super("152");
        setEarthTowerImage();
        setEarthTowerSize();
    }

    /**
     * Sets the image of earth tower
     */
    public void setEarthTowerImage() {

        if ( getLevel() == 1 ) {
            super.setImage( "/earthTower1.png" );
        }
        else if (getLevel() == 2) {
            super.setImage( "/earthTower2.png" );
        }
        else {
            super.setImage("/earthTower3.png");
        }
    }

    /**
     * Sets the size of tower
     */
    public void setEarthTowerSize() {
        setSize(new Dimension(35, 50));
    }

    @Override
    public void upgradeTower() {
        super.upgradeTower();
        setEarthTowerImage();
    }
}
