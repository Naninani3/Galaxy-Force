import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TieMissile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TieMissile extends Actor
{
    /**
     * Act - do whatever the TieMissile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + 3);
        
        if (getY() == 832) 
        {
            getWorld().removeObject(this);
        }
    }
}
