package Model.Tower;

import java.awt.*;

/**
 * Extends the Tower class and create features of PoisonTower Class
 *
 * @author Gökhan Taş
 * @date 24.12.2019
 */
public class PoisonTower extends Tower {

    /**
     * Constructor
     */
    public PoisonTower() {
        super("168");
        setPoisonTowerImage();
        setPoisonTowerSize();
    }

    /**
     * Sets the image of poison tower
     */
    public void setPoisonTowerImage() {

        if (getLevel() == 1) {
            super.setImage("/poisonTower1.png");
        } else if (getLevel() == 2) {
            super.setImage("/poisonTower2.png");
        } else {
            super.setImage("/poisonTower3.png");
        }
    }

    /**
     * Sets the size of poison tower
     */
    public void setPoisonTowerSize() {
        setSize(new Dimension(35, 50));
    }

    @Override
    public void upgradeTower() {
        super.upgradeTower();
        setPoisonTowerImage();
    }
}
