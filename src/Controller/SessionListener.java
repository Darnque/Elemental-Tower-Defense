package Controller;

import Model.ModelManager;
import Model.Player;
import Model.Tower.Tower;
import View.GameSceneView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Updates the location of every objects in every frame
 *
 * @author Sebahattin Utku Sezer
 * @date 25.12.2019
 */
public class SessionListener implements ActionListener {

    //Variables
    private ModelManager modelManager;
    private GameSceneView gameSceneView;
    private Player player;

    private PlayMusic music;

    private int timeEnemySpawn = 0; //timer for enemies to spawn

    private Timer timer; //General timer

    /**
     * Constructor
     */
    public SessionListener(){
        setVariables();
    }

    /**
     * Creates objects
     */
    public void setVariables(){
        player = GameController.getGameModel().getPlayer();

        modelManager = GameController.getGameModel();
        gameSceneView = GameController.getGameFrame().getGameSceneView();

        music = GameSceneView.music;

        timer = new Timer(30, this );

    }

    /**
     * Sets the timer
     * @param startTimer
     */
    public void setTimer(boolean startTimer){

        //turn on/off timer
        if (startTimer == true) {
            timer.start();
        }
        else {
            timer.stop();
        }
    }

    /**
     * Spawns enemies according to the wave's type and timer
     */
    public void enemySpawn() {
        //spawns new enemy and resets time of spawn,
            if (player.getType().equals("fire")) {
                if (timeEnemySpawn > 2000) {
                    modelManager.addToEnemyList();
                    gameSceneView.updateListOfFireEnemies(modelManager.getFireEnemyList());
                    timeEnemySpawn = 0;
                }
            } else if (player.getType().equals("earth")) {
                if (timeEnemySpawn > 2000) {
                    modelManager.addToEnemyList();
                    gameSceneView.updateListOfEarthEnemies(modelManager.getEarthEnemyList());
                    timeEnemySpawn = 0;
                }
            } else if (player.getType().equals("electric")) {
                if (timeEnemySpawn > 2000) {
                    modelManager.addToEnemyList();
                    gameSceneView.updateListOfElectricEnemies(modelManager.getElectricEnemyList());
                    timeEnemySpawn = 0;
                }
            } else if (player.getType().equals("poison")) {
                 if (timeEnemySpawn > 2000) {
                    modelManager.addToEnemyList();
                    gameSceneView.updateListOfPoisonEnemies(modelManager.getPoisonEnemyList());
                 timeEnemySpawn = 0;
                }
            } else if (player.getType().equals("water")) {
                if (timeEnemySpawn > 2000) {
                    modelManager.addToEnemyList();
                    gameSceneView.updateListOfWaterEnemies(modelManager.getWaterEnemyList());
                    timeEnemySpawn = 0;
                }
            }
    }

    /**
     * Spawns TowerFire objects for every towers separately by looking to their timer
     */
    public void towerFireSpawn() {

        for( Tower tower: GameSceneView.getListOfTowers() ){ //Checks every tower

                if (tower.checkIfInRange()) { //Checks if enemy in range

                    if ( tower.getTimer() > 1000) { //Checks the timers and creates tower fires
                        if ( tower.getTowerType().equals("169") ) {
                            music.playWaterTower();
                        }
                        else if( tower.getTowerType().equals("168") ) {
                            music.playPoisonTower();
                        }
                        else if( tower.getTowerType().equals("151") ) {
                            music.playFireTower();
                        }
                        else if( tower.getTowerType().equals("185") ) {
                            music.playElectricTower();
                        }
                        else if( tower.getTowerType().equals("152") ) {
                            music.playEarthTower();
                        }
                        modelManager.addToTowerFireList(tower);
                        gameSceneView.updateListOfTowerFire(modelManager.getTowerFireList());
                        tower.setTimer(0);
                    }
                }
        }
    }

    /**
     * Updates all clocks and adds delays for enemies and towers
     */
    public void updateClocks(){
        timeEnemySpawn += timer.getDelay();
        for ( Tower tower: GameSceneView.getListOfTowers() ){
            tower.setTimer( tower.getTimer() + timer.getDelay() );
        }
    }

    /**
     * Updates everything on the screen
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        enemySpawn();
        towerFireSpawn();
        setPositionOfObjects();
        gameSceneView.repaint();
        updateClocks();
    }

    /**
     * Updates the position of every objects
     */
    public void setPositionOfObjects(){

        modelManager.updatePositionOfEnemies();
        modelManager.updatePositionOfTowerFire();
    }
}
