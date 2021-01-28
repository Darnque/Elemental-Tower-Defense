package Model.Tower;

import java.awt.*;

/**
 * Extends the Tower class and create features of ElectricTower Class
 *
 * @author Gökhan Taş
 * @date 24.12.2019
 */
public class ElectricTower extends Tower {

    /**
     * Constructor
     */
    public ElectricTower() {
        super("185");
        super.setRange(250);
        super.setDamage(10);
        setElectricTowerImage();
        setElectricTowerSize();
    }

    /**
     * Sets the image of electric tower
     */
    public void setElectricTowerImage() {

        if ( getLevel() == 1 ) {
            super.setImage( "/electricTower1.png" );
        }
        else if (getLevel() == 2) {
            super.setImage( "/electricTower2.png" );
        }
        else {
            super.setImage("/electricTower3.png");
        }
    }

    /**
     * Sets the size of tower
     */
    public void setElectricTowerSize() {
        setSize(new Dimension(35, 50));
    }

    @Override
    public void upgradeTower() {
        super.upgradeTower();
        setElectricTowerImage();
    }
}
