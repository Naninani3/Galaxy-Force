import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TieFighter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TieFighter extends Actor
{
    int fireCounter = 0;
    /**
     * Act - do whatever the TieFighter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + 2);
        increasefireCounter();
        
        if (getY() == 832) 
        {
            ((MyWorld)getWorld()).updateScore(-75);
            getWorld().removeObject(this);
        }
        else if (getY() == 30) 
        {
            getWorld().addObject(new TieLaser(), getX(), getY()); 
        }
        
        if(fireCounter % 150 == 0)
        {
            getWorld().addObject(new TieLaser(), getX(), getY()); 
        }
    }
    
    public void increasefireCounter()
    {
        fireCounter = fireCounter + 1;
    }
}
