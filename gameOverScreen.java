import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameOverScreen extends World
{
    int score;
    /**
     * Constructor for objects of class gameOverScreen.
     * 
     */
    public gameOverScreen(int finalScore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 833, 1); 
        score = finalScore;
        prepare();
        showText("Score: " + score, 300, 150);
        
    }
    
    private void prepare()
    {
        addObject(new RestartButton(), 300, 720);
    }
}
