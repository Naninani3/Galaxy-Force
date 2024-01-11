import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroids here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroids extends Actor
{
    private int size;
    
    public Asteroids()
    {
        
    }
    
    /**
     * Act - do whatever the Asteroids wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + 1);
        
        if (getY() == 832) 
        {
            ((MyWorld)getWorld()).updateScore(-15);
            getWorld().removeObject(this);
        }
    }
}
