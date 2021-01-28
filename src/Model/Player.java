package Model;

public class Player {
    /**
     * Creates the player who plays the game
     *
     * @author Sebahattin Utku Sezer
     * @date 25.12.2019
     */

    //Variables
    private int health;
    private int score;
    private int coins;
    private int level;
    private String type;

    /**
     * Constructor
     */
    public Player(){
        health = 40;
        score = 0;
        coins = 20;
        level = 1;
        setType();
    }

    /**
     * Sets the type randomly
     */
    public void setType(){
        int a = (int)( Math.random() * 5 );

        if ( a==0 ) type = "earth";
        else if ( a==1 ) type = "fire";
        else if ( a==2 ) type = "electric";
        else if ( a==3 ) type = "poison";
        else if ( a==4 ) type = "water";
    }

    /**
     * Sets the health
     * @param health
     */
    public void setHealth( int health ) {
        this.health = health;
    }

    /**
     * Sets the score
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Sets the coins
     * @param coins
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * Sets the level
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the health
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the coins
     * @return coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Gets the level
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the type
     * @return type
     */
    public String getType() {
        return type;
    }
}
