import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StarDestroyer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StarDestroyer extends Actor
{
    int fireCounter = 0;
    private int SDLives = 6;
    /**
     * Act - do whatever the StarDestroyer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + 1);
        increasefireCounter();
        loseLives();
        
        if (getY() == 30) 
        {
            getWorld().addObject(new SDLaser(), getX(), getY()); 
        }
        
        if(fireCounter % 400 == 0)
        {
            getWorld().addObject(new SDLaser(), getX(), getY()); 
        }
        
        if (SDLives < 1)
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
    
    public void increasefireCounter()
    {
        fireCounter = fireCounter + 1;
    }
    
    private void loseLives()
    {
        if (isTouching(XLaser.class))
        {
            removeTouching(XLaser.class);
            SDLives = SDLives - 1; 
        }
    }
    
    private void destroy()
    {
        if (getY() == 832) 
        {
            ((MyWorld)getWorld()).updateScore(-200);
            getWorld().removeObject(this);
        }
    }
}
