import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class XLaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class XLaser extends Actor
{
    /**
     * Act - do whatever the XLaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() - 6);
        destroy();
    }
    
    private void destroy()
    {
        if (isTouching(TieFighter.class))
        {
            removeTouching(TieFighter.class);
            getWorld().addObject(new Explosion(), getX(), getY());
            ((MyWorld)getWorld()).updateScore(+100);
            getWorld().removeObject(this);
        }
        else if (isTouching(Asteroids.class))
        {
            removeTouching(Asteroids.class);
            getWorld().addObject(new Explosion(), getX(), getY());
            ((MyWorld)getWorld()).updateScore(+25);
             getWorld().removeObject(this);
        }
        else if (getY() == 0) 
        {
            getWorld().removeObject(this);
        }
    }
    
    }
