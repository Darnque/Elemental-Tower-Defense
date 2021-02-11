package Controller;


import View.SettingsView;

import javax.sound.sampled.*;
import java.io.*;

/**
 * Class to play music
 *
 * @author Sebahattin Utku Sezer
 * @date 25.12.2019
 */
public class PlayMusic {

    //Variables
    private Clip mainMenu;
    private Clip battle;
    private Clip enemyDeath;
    private Clip waterTower;
    private Clip poisonTower;
    private Clip fireTower;
    private Clip earthTower;
    private Clip electricTower;
    private Clip gameOver;

    /**
     * Constructor
     */
    public PlayMusic() {

    }

    /**
     * Plays main menu theme
     */
    public void playMainMenu() {
        if ( SettingsView.getMusicFlag() ) {
            try {
                mainMenu = AudioSystem.getClip();
                mainMenu.open(AudioSystem.getAudioInputStream(new File("sounds/main_menu_theme.wav")));
                mainMenu.start();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Stops main menu theme
     */
    public void stopMainMenu(){
        mainMenu.stop();
    }

    /**
     * Plays battle theme randomly
     */
    public void playBattle() {
        if ( SettingsView.getMusicFlag() ) {
            try {
                battle = AudioSystem.getClip();
                int a = (int) (Math.random() * 2);
                if (a == 0) {
                    battle.open(AudioSystem.getAudioInputStream(new File("sounds/battle_1.wav")));
                } else {
                    battle.open(AudioSystem.getAudioInputStream(new File("sounds/battle_2.wav")));
                }
                battle.start();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Stops battle theme
     */
    public void stopBattle(){
        battle.stop();
    }

    /**
     * Plays enemy death sound randomly
     */
    public void playEnemyDeath(){
        if ( SettingsView.getSoundFlag() ) {
            try {
                enemyDeath = AudioSystem.getClip();
                int a = (int) (Math.random() * 4);
                if (a == 0) {
                    enemyDeath.open(AudioSystem.getAudioInputStream(new File("sounds/enemy_death_1.wav")));
                } else if (a == 1) {
                    enemyDeath.open(AudioSystem.getAudioInputStream(new File("sounds/enemy_death_2.wav")));
                } else if (a == 2) {
                    enemyDeath.open(AudioSystem.getAudioInputStream(new File("sounds/enemy_death_3.wav")));
                } else {
                    enemyDeath.open(AudioSystem.getAudioInputStream(new File("sounds/enemy_death_4.wav")));
                }
                enemyDeath.start();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Plays water tower sound
     */
    public void playWaterTower() {
        if ( SettingsView.getSoundFlag() ) {
            try {
                waterTower = AudioSystem.getClip();
                waterTower.open(AudioSystem.getAudioInputStream(new File("sounds/water_twr_attack.wav")));
                waterTower.start();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Plays fire tower sound
     */
    public void playFireTower() {
        if ( SettingsView.getSoundFlag() ) {
            try {
                fireTower = AudioSystem.getClip();
                fireTower.open(AudioSystem.getAudioInputStream(new File("sounds/fire_twr_attack.wav")));
                fireTower.start();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Plays earth tower sound
     */
    public void playEarthTower() {
        if (SettingsView.getSoundFlag()){
            try {
                earthTower = AudioSystem.getClip();
                earthTower.open(AudioSystem.getAudioInputStream(new File("sounds/earth_twr_attack.wav")));
                earthTower.start();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Plays poison tower sound
     */
    public void playPoisonTower() {
        if ( SettingsView.getSoundFlag() ) {
            try {
                poisonTower = AudioSystem.getClip();
                poisonTower.open(AudioSystem.getAudioInputStream(new File("sounds/poison_twr_attack.wav")));
                poisonTower.start();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Plays electric tower sound
     */
    public void playElectricTower() {
        if ( SettingsView.getSoundFlag() ) {
            try {
                electricTower = AudioSystem.getClip();
                electricTower.open(AudioSystem.getAudioInputStream(new File("sounds/electric_twr_attack.wav")));
                electricTower.start();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Plays the game over
     */
    public void playGameOver() {
        try {
            gameOver = AudioSystem.getClip();
            gameOver.open(AudioSystem.getAudioInputStream(new File("sounds/game_over.wav")));
            gameOver.start();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
