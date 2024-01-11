import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TieBomber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TieBomber extends Actor
{
    private int bomberLives = 3;
    int fireCounter = 0;

    /**
     * Act - do whatever the TieBomber wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + 1);
        loseLives();
        increasefireCounter();
        shoot();
        
        if (getY() == 30) 
        {
            getWorld().addObject(new TieMissile(), getX(), getY()); 
        }
        
        if (bomberLives < 1)
        {
            getWorld().addObject(new Explosion(), getX(), getY());
            ((MyWorld)getWorld()).updateScore(+300);
            removeTouching(XLaser.class);
            getWorld().removeObject(this);
        }
        else 
        {
            destroy();
        }
    }
    
    private void shoot()
    {
        if(fireCounter % 230 == 0)
        {
            getWorld().addObject(new TieMissile(), getX(), getY()); 
        }
    }
    
    private void loseLives()
    {
        if (isTouching(XLaser.class))
        {
            removeTouching(XLaser.class);
            bomberLives = bomberLives - 1; 
        }
    }
    
    private void destroy()
    {
        if (getY() == 832) 
        {
            ((MyWorld)getWorld()).updateScore(-130);
            getWorld().removeObject(this);
        }
    }
    
    public void increasefireCounter()
    {
        fireCounter = fireCounter + 1;
    }
    
    
}
