import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartingScreen extends World
{

    /**
     * Constructor for objects of class StartingScreen.
     * 
     */
    public StartingScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 833, 1); 
        prepare();
    }
    
    private void prepare()
    {
        addObject(new StartButton(), 300, 720);
        addObject(new Instructions(), 300, 400);
        addObject(new Title(), 300, 150);
        addObject(new MissileInstruction(), 300, 550);
    }
}
