import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TieLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TieLaser extends Actor
{
    /**
     * Act - do whatever the TieLaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        setLocation(getX(), getY() + 5);
        
        if (getY() == 832) 
        {
            getWorld().removeObject(this);
        }
    }
    

}
