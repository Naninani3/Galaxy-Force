import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExtraLife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExtraLife extends Actor
{
    /**
     * Act - do whatever the ExtraLife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + 2);
        
        if (getY() == 832) 
        {
            getWorld().removeObject(this);
        }
    }
}
