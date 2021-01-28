package Model;

import Controller.PlayMusic;
import Model.Enemy.*;
import Model.Tower.Tower;
import Model.Tower.TowerFire;
import View.GameSceneView;

import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Do all calculations of other classes' insantances
 *
 * @author Gökhan Taş
 * @author Sebahattin Utku Sezer
 * @author Bedirhan Sakinoğlu
 * @date 25.12.2019
 */
public class ModelManager {

    //Variables
    static Player player;
    static private PlayMusic music;
    static private ArrayList<Tower> towerList;
    static private ArrayList<Enemy> enemyList;
    static private ArrayList<EarthEnemy> earthEnemyList;
    static private ArrayList<WaterEnemy> waterEnemyList;
    static private ArrayList<ElectricEnemy> electricEnemyList;
    static private ArrayList<PoisonEnemy> poisonEnemyList;
    static private ArrayList<FireEnemy> fireEnemyList;
    static public ArrayList<TowerFire> towerFireList;

    static private int waveSize = 5;
    static private int limiter = 0;

    /**
     * Constructor
     */
    public ModelManager() {
        setObjects();
    }


    /**
     * Creates the objects
     */
    public void setObjects() {
        player = GameSceneView.getPlayer();
        towerList = new ArrayList<>();
        earthEnemyList = new ArrayList<>();
        waterEnemyList = new ArrayList<>();
        fireEnemyList = new ArrayList<>();
        poisonEnemyList = new ArrayList<>();
        electricEnemyList = new ArrayList<>();
        enemyList = getEnemyList();
        towerList = GameSceneView.getListOfTowers();
        towerFireList = new ArrayList<>();

        music = GameSceneView.music;

    }

    /**
     * Creates and adds enemies to the specified list and limits the wave enemy number
     */
    public void addToEnemyList() {

        if ( limiter <= waveSize ) {

            String a = player.getType();

            if (a.equals("fire")) { //If enemy is fire

                if (fireEnemyList.size() >= waveSize) { //If wave is full
                    if (fireEnemyList.size() <= 0) {
                        increaseWave(); //Increases the level of the wave
                    }
                } else {
                    Enemy enemy = new FireEnemy(player.getLevel()); //Creates fire enemy
                    enemy.setSize(new Dimension(69, 77));
                    fireEnemyList.add((FireEnemy) enemy);
                    limiter++; //Increases the limiter to limit the wave number for after
                }
            } else if (a.equals("electric")) { //If wave is electric

                if (electricEnemyList.size() >= waveSize) { //If wave is full
                    if (electricEnemyList.size() <= 0) {
                        increaseWave(); //Increases the level of the wave
                    }
                } else {
                    Enemy enemy = new ElectricEnemy(player.getLevel()); //Creates electric enemy
                    enemy.setSize(new Dimension(69, 77));
                    electricEnemyList.add((ElectricEnemy) enemy);
                    limiter++; //Increases the limiter to limit the wave number for after
                }

            } else if (a.equals("earth")) { //If wave is earth

                if (earthEnemyList.size() >= waveSize) { //If wave is full
                    if (earthEnemyList.size() <= 0) {
                        increaseWave(); //Increases the level of the wave
                    }
                } else {
                    Enemy enemy = new EarthEnemy(player.getLevel()); //Creates electric enemy
                    enemy.setSize(new Dimension(69, 77));
                    earthEnemyList.add((EarthEnemy) enemy);
                    limiter++; //Increases the limiter to limit the wave number for after
                }

            } else if (a.equals("water")) { //If wave is water

                if (waterEnemyList.size() >= waveSize) { //If wave is full
                    if (waterEnemyList.size() <= 0) {
                        increaseWave(); //Increases the level of the wave
                    }
                } else {
                    Enemy enemy = new WaterEnemy(player.getLevel()); //Creates electric enemy
                    enemy.setSize(new Dimension(69, 77));
                    waterEnemyList.add((WaterEnemy) enemy);
                    limiter++; //Increases the limiter to limit the wave number for after
                }


            } else if (a.equals("poison")) { //If wave is poison

                if (poisonEnemyList.size() >= waveSize) { //If wave is full
                    if (poisonEnemyList.size() <= 0) {
                        increaseWave(); //Increases the level of the wave
                    }
                } else {
                    Enemy enemy = new PoisonEnemy(player.getLevel()); //Creates poison enemy
                    enemy.setSize(new Dimension(69, 77));
                    poisonEnemyList.add((PoisonEnemy) enemy);
                    limiter++; //Increases the limiter to limit the wave number for after
                }

            }
        }
        else { //Resets the limiter for the next wave
            limiter=0;
            increaseWave();
        }
    }

    /**
     * Creates new TowerFire specified for tower and adds to the list
     * @param tower
     */
    public void addToTowerFireList( Tower tower ) {

            TowerFire towerFire = new TowerFire(tower);
            towerFire.setTarget(tower.getTarget());
            towerFire.setDamage(tower.getDamage());
            towerFire.setLocation(tower.getLocation());
            towerFireList.add(towerFire);

    }

    /**
     * Increases the level of the wave
     */
    public void increaseWave(){
        waveSize++;
        GameSceneView.getPlayer().setLevel(GameSceneView.getPlayer().getLevel()+1);
        GameSceneView.setInfoLevel(player.getLevel());
        GameSceneView.getPlayer().setType();
        GameSceneView.setInfoType();

    }

    /**
     * Updates and checks the position of enemies
     */
    public void updatePositionOfEnemies(){
        checkIfEnemiesInTerritory();
        checkIfEnemyIsDead();
        setNewEnemyPosition();
    }

    /**
     * Updates the position of tower fire and checks if it touched to enemy
     */
    public void updatePositionOfTowerFire() {
        setNewTowerFirePosition();
        checkIfTowerFireTouchEnemy();
    }

    /**
     * Creates and returns the full enemy list
     * @return full enemy list
     */
    public static ArrayList<Enemy> getEnemyList(){
        ArrayList<Enemy> listOfEnemies = new ArrayList<>();

            for (int i = 0; i < earthEnemyList.size(); i++) {
                listOfEnemies.add(earthEnemyList.get(i));
             }

            for (int b = 0; b < waterEnemyList.size(); b++) {
                listOfEnemies.add(waterEnemyList.get(b));
              }

            for (int c = 0; c < fireEnemyList.size(); c++) {
                listOfEnemies.add(fireEnemyList.get(c));
            }

            for (int d = 0; d < poisonEnemyList.size(); d++) {
                listOfEnemies.add(poisonEnemyList.get(d));
             }

            for (int e = 0; e < electricEnemyList.size(); e++) {
                listOfEnemies.add(electricEnemyList.get(e));

            }
        return listOfEnemies;
    }

    /**
     * Gets tower fire list
     * @return tower fire list
     */
    public static ArrayList<TowerFire> getTowerFireList() {
        return towerFireList;
    }

    /**
     *
     */
    public void checkIfGameOver(){

        if (player.getHealth() <= 0) {
            GameSceneView.popGameOver();
        }
    }

    /**
     * Checks if enemies get in to territory and if they are, reduces the player's health
     */
    private void checkIfEnemiesInTerritory(){

        ListIterator<EarthEnemy> earthEnemyListIterator = earthEnemyList.listIterator();
        while ( earthEnemyListIterator.hasNext() ) {
            EarthEnemy earthCheck = earthEnemyListIterator.next();
            if ( earthCheck.getPosition().x > 1047 && earthCheck.getPosition().y > 624 ) {
                earthEnemyListIterator.remove();
                player.setHealth(player.getHealth()-5);
                GameSceneView.setInfoHealth(player.getHealth());
            }
        }

        ListIterator<WaterEnemy> waterEnemyListIterator = waterEnemyList.listIterator();
        while ( waterEnemyListIterator.hasNext() ) {
            WaterEnemy waterCheck = waterEnemyListIterator.next();
            if ( waterCheck.getPosition().x > 1047 && waterCheck.getPosition().y > 624 ) {
                waterEnemyListIterator.remove();
                player.setHealth(player.getHealth()-5);
                GameSceneView.setInfoHealth(player.getHealth());
            }
        }

        ListIterator<FireEnemy> fireEnemyListIterator = fireEnemyList.listIterator();
        while ( fireEnemyListIterator.hasNext() ) {
            FireEnemy fireCheck = fireEnemyListIterator.next();
            if ( fireCheck.getPosition().x > 1047 && fireCheck.getPosition().y > 624 ) {
                fireEnemyListIterator.remove();
                player.setHealth(player.getHealth()-5);
                GameSceneView.setInfoHealth(player.getHealth());
            }
        }

        ListIterator<PoisonEnemy> poisonEnemyListIterator = poisonEnemyList.listIterator();
        while ( poisonEnemyListIterator.hasNext() ) {
            PoisonEnemy poisonCheck = poisonEnemyListIterator.next();
            if (  poisonCheck.getPosition().x > 1047 && poisonCheck.getPosition().y > 624 ) {
                poisonEnemyListIterator.remove();
                player.setHealth(player.getHealth()-5);
                GameSceneView.setInfoHealth(player.getHealth());
            }
        }

        ListIterator<ElectricEnemy> electricEnemyListIterator = electricEnemyList.listIterator();
        while ( electricEnemyListIterator.hasNext() ) {
            ElectricEnemy electricCheck = electricEnemyListIterator.next();
            if (  electricCheck.getPosition().x > 1047 && electricCheck.getPosition().y > 624 ) {
                electricEnemyListIterator.remove();
                player.setHealth(player.getHealth()-5);
                GameSceneView.setInfoHealth(player.getHealth());
            }
        }
        checkIfGameOver();
    }

    /**
     * Checks the enemies's health and if they are dead removes the enemy and adds coin and score according to the level of the wave
     */
    private void checkIfEnemyIsDead(){

        //Checks the earth enemies
        ListIterator<EarthEnemy> earthEnemyListIterator = earthEnemyList.listIterator();
        while ( earthEnemyListIterator.hasNext() ) {
            EarthEnemy earthCheck = earthEnemyListIterator.next();
            if ( earthCheck.getHealth() <= 0 ) { //If enemy is dead
                View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() + 2);
                View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                View.GameSceneView.getPlayer().setScore(View.GameSceneView.getPlayer().getScore() + 10 * earthCheck.getLevel() );
                View.GameSceneView.getInfoScore().setText("" + View.GameSceneView.getPlayer().getScore());
                music.playEnemyDeath();
                earthEnemyListIterator.remove();
            }
        }

        //Checks the electric enemies
        ListIterator<ElectricEnemy> electricEnemyListIterator = electricEnemyList.listIterator();
        while ( electricEnemyListIterator.hasNext() ) {
            ElectricEnemy electricCheck = electricEnemyListIterator.next();
            if ( electricCheck.getHealth() <= 0 ) { //If enemy is dead
                View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() + 2);
                View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                View.GameSceneView.getPlayer().setScore(View.GameSceneView.getPlayer().getScore() + 10 * electricCheck.getLevel() );
                View.GameSceneView.getInfoScore().setText("" + View.GameSceneView.getPlayer().getScore());
                music.playEnemyDeath();
                electricEnemyListIterator.remove();
            }
        }

        //Checks the fire enemies
        ListIterator<FireEnemy> fireEnemyListIterator = fireEnemyList.listIterator();
        while ( fireEnemyListIterator.hasNext() ) {
            FireEnemy fireCheck = fireEnemyListIterator.next();
            if ( fireCheck.getHealth() <= 0 ) { //If enemy is dead
                View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() + 2);
                View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                View.GameSceneView.getPlayer().setScore(View.GameSceneView.getPlayer().getScore() + 10 * fireCheck.getLevel() );
                View.GameSceneView.getInfoScore().setText("" + View.GameSceneView.getPlayer().getScore());
                music.playEnemyDeath();
                fireEnemyListIterator.remove();
            }
        }

        //Checks the poison enemies
        ListIterator<PoisonEnemy> poisonEnemyListIterator = poisonEnemyList.listIterator();
        while ( poisonEnemyListIterator.hasNext() ) {
            PoisonEnemy poisonCheck = poisonEnemyListIterator.next();
            if ( poisonCheck.getHealth() <= 0 ) { //If enemy is dead
                View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() + 2);
                View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                View.GameSceneView.getPlayer().setScore(View.GameSceneView.getPlayer().getScore() + 10 * poisonCheck.getLevel());
                View.GameSceneView.getInfoScore().setText("" + View.GameSceneView.getPlayer().getScore());
                music.playEnemyDeath();
                poisonEnemyListIterator.remove();
            }
        }

        //Checks the water enemies
        ListIterator<WaterEnemy> waterEnemyListIterator = waterEnemyList.listIterator();
        while ( waterEnemyListIterator.hasNext() ) {
            WaterEnemy waterCheck = waterEnemyListIterator.next();
            if ( waterCheck.getHealth() <= 0 ) { //If enemy is dead
                View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() + 2);
                View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                View.GameSceneView.getPlayer().setScore(View.GameSceneView.getPlayer().getScore() + 10 * waterCheck.getLevel() );
                View.GameSceneView.getInfoScore().setText("" + View.GameSceneView.getPlayer().getScore());
                music.playEnemyDeath();
                waterEnemyListIterator.remove();
            }
        }

    }

    /**
     * Updates the position of all enemies
     */
    public void setNewEnemyPosition(){
        for (EarthEnemy enemy : earthEnemyList)
        {
            enemy.updateMovement();
        }
        for (WaterEnemy enemy : waterEnemyList)
        {
            enemy.updateMovement();
        }
        for (ElectricEnemy enemy : electricEnemyList)
        {
            enemy.updateMovement();
        }
        for (FireEnemy enemy : fireEnemyList)
        {
            enemy.updateMovement();
        }
        for (PoisonEnemy enemy : poisonEnemyList)
        {
            enemy.updateMovement();
        }
    }

    /**
     * Updates the towerFire's positions
     */
    public void setNewTowerFirePosition() {
        for ( TowerFire towerFire: towerFireList ) {
            towerFire.updateMovement();
        }
    }

    /**
     * Checks if towerFire's touches the enemy
     */
    public void checkIfTowerFireTouchEnemy() {

        ListIterator<TowerFire> towerFireListIterator = towerFireList.listIterator();
        while ( towerFireListIterator.hasNext() ) {
            TowerFire towerFireCheck = towerFireListIterator.next();
            //Checks the little circle around the enemy's center and if tower fire is in it, removes the health of the enemy
            if ( ( (towerFireCheck.getPosition().x < towerFireCheck.getTarget().getCenterX() + 20) && (towerFireCheck.getPosition().x > towerFireCheck.getTarget().getCenterX() - 20)) &&
                    (towerFireCheck.getPosition().y < towerFireCheck.getTarget().getCenterY() + 20) && (towerFireCheck.getPosition().y > towerFireCheck.getTarget().getCenterY() - 20) ) {
                towerFireCheck.getTarget().setHealth( towerFireCheck.getTarget().getHealth() - towerFireCheck.getDamage( towerFireCheck.getTarget() ) );
                towerFireListIterator.remove();
            }
        }

    }

    /**
     * Gets the earth enemy list
     * @return earth enemy list
     */
    public ArrayList<EarthEnemy> getEarthEnemyList(){ return earthEnemyList;}

    /**
     * Gets the water enemy list
     * @return water enemy list
     */
    public ArrayList<WaterEnemy> getWaterEnemyList(){ return waterEnemyList;}

    /**
     * Gets the electric enemy list
     * @return electric enemy list
     */
    public ArrayList<ElectricEnemy> getElectricEnemyList() {return electricEnemyList;}

    /**
     * Gets the poison enemy list
     * @return poison enemy list
     */
    public ArrayList<PoisonEnemy> getPoisonEnemyList() {return poisonEnemyList;}

    /**
     * Gets the fire enemy list
     * @return fire enemy list
     */
    public ArrayList<FireEnemy> getFireEnemyList() {return fireEnemyList;}

    /**
     * Gets the player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

}