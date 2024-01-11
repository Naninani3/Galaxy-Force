import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int score = 0;
    private int lives = 5;
    private int missiles = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 833, 1); 
        prepare();
        showText("Score: " + score, 100, 820);
        showText("Lives: " + lives, 550, 820);
        showText("Missiles: " + missiles, 540, 780);
        Explosion.initialiseImages();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        showText("Score: " + score, 100, 820);
        showText("Lives: " + lives, 550, 820);
        showText("Missiles: " + missiles, 540, 780);
        addObject(new Xwing(), 300, 761);
    }  
    
    public void act()
    {
        spawnPowerUps();
        spawnShips();
        spawnAsteroids();
    }
    
    public void spawnPowerUps()
    {
        if ((Math.random() * 1333 < 1))
        {
            addObject(new ExtraLife(), (int)(Math.random() * 600), 24);
        }
        
        if ((Math.random() * 1000 < 1))
        {
            addObject(new FireRateBoost(), (int)(Math.random() * 600), 24);
        }
        
        if ((Math.random() * 1000 < 1))
        {
            addObject(new SpeedBoost(), (int)(Math.random() * 600), 24);
        }
    }
    
    public void spawnShips()
    {
        if ((Math.random() * 150 < 1))
        {
            addObject(new TieFighter(), (int)(Math.random() * 600), 24);
        }
        
        if ((Math.random() * 950 < 1))
        {
            addObject(new TieBomber(), (int)(Math.random() * 600), 24);
        }
        
        if ((Math.random() * 1550 < 1))
        {
            addObject(new StarDestroyer(), (int)(Math.random() * 600), 24);
        }
    }
    
    public void spawnAsteroids()
    {
        if ((Math.random() * 100 < 1))
        {
            addObject(new Asteroids(), (int)(Math.random() * 600), 24);
        }
    }
    
    public void updateScore(int points)
    {
        score = score + points;
        showText("Score: " + score, 100, 820);
    }
    
    public void updateLives(int hearts)
    {
        lives = lives + hearts;
        showText("Lives: " + lives, 550, 820);
        if (lives<1)
        {
            Greenfoot.setWorld(new gameOverScreen(score));
        }
    }
    
    public void updateMissiles(int missiles)
    {
        showText("Missiles: " + missiles, 540, 780);
    }
}
