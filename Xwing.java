import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Xwing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Xwing extends Actor
{
    private int gunReloadTime;               
    private int reloadDelayCount;                           
    boolean notInvincible = true;
    boolean fireBoostOff = true;
    int counter = 0;
    int fireBoostCounter = 0;
    int fireCounter = 0;
    boolean speedBoostOff = true;
    int speedBoostCounter = 0;

    private static final int MAX_MISSILE_COUNT = 1;
    private static final int MISSILE_CREATE_DELAY = 500;       
    private int ammo = MAX_MISSILE_COUNT;
    private int delay = MISSILE_CREATE_DELAY;
    
    public void act()
    {
        checkKeys();
        touchingExtraLife();
        touchingFireRateBoost();
        touchingSpeedBoost();
        counter++;
        fireBoostCounter++;
        fireCounter++;
        speedBoostCounter++;
        shoot();
        createMissile();
        if (notInvincible == false)
        {
            if(counter % 200 == 0)
            {
                notInvincible = true;
            }
        }
        else
        {
           touchingAsteroids();
           touchingShips(); 
           damageFromTieLaser();
           damageFromSDLaser();
           damageFromTieMissile();
        }
        
        if (fireBoostCounter % 200 == 0)
        {
            fireBoostOff = true;
        }
        
        if (speedBoostCounter % 200 == 0)
        {
            speedBoostOff = true;
        }
        
        ((MyWorld)getWorld()).updateMissiles(ammo);
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (speedBoostOff == false)
        {
            if(Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(), getY()-7);
            }
            if (Greenfoot.isKeyDown("down")) 
            {
                setLocation(getX(), getY()+7);
            }   
            if(Greenfoot.isKeyDown("left")) 
            {
                setLocation(getX()-7, getY());
            }        
            if(Greenfoot.isKeyDown("right")) 
            {
                setLocation(getX()+7, getY());
            }
        }
        else
        {
            if(Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(), getY()-4);
            }
            if (Greenfoot.isKeyDown("down")) 
            {
                setLocation(getX(), getY()+4);
            }   
            if(Greenfoot.isKeyDown("left")) 
            {
                setLocation(getX()-4, getY());
            }        
            if(Greenfoot.isKeyDown("right")) 
            {
                setLocation(getX()+4, getY());
            }
        }
    }

    public void shoot()
    {
        if(Greenfoot.isKeyDown("space")) 
        {
            if (fireBoostOff == false)
            {
                if(fireCounter % 11 == 0)
                {
                    getWorld().addObject(new XLaser(), getX(), getY()); 
                    Greenfoot.playSound("EnergyGun.wav");
                }
            }
            else
            {
                if(fireCounter % 25 == 0)
                {
                    getWorld().addObject(new XLaser(), getX(), getY()); 
                    Greenfoot.playSound("EnergyGun.wav");
                }
            }
        }        
        
        if (Greenfoot.isKeyDown("w")) 
        {
            fireMissile();
        }
    }
    
    private void fireMissile()
    {
        if (ammo > 0 && getWorld().getObjects(Missile.class).isEmpty()) 
        {
            Missile missile = new Missile();
            getWorld().addObject(missile, getX(), getY() - 50);
            ammo--;
            delay = MISSILE_CREATE_DELAY; 
        }
    }
    
    private void createMissile() 
    {
        if (delay > 0) 
        {
            delay--;
        } 
        else 
        {
            if (ammo < MAX_MISSILE_COUNT) 
            {
                ammo++;
            }
            delay = MISSILE_CREATE_DELAY; 
        }
    }
    
    public int getMissileCount() 
    {
        return ammo;
    }
    
    private void touchingExtraLife()
    {    
        if (isTouching(ExtraLife.class))
        {
            ((MyWorld)getWorld()).updateLives(+1);
            removeTouching(ExtraLife.class);
        }
    }
    
    private void touchingFireRateBoost()
    {
        if (isTouching(FireRateBoost.class))
        {
            removeTouching(FireRateBoost.class);
            fireBoostOff = false;
            fireBoostCounter = 0;
        }
    }
    
    private void touchingSpeedBoost()
    {
        if (isTouching(SpeedBoost.class))
        {
            removeTouching(SpeedBoost.class);
            speedBoostOff = false;
            speedBoostCounter = 0;
        }
    }
    
    private void touchingAsteroids()
    {
        if (isTouching(Asteroids.class))
        {
            removeTouching(Asteroids.class);
            getWorld().addObject(new Explosion(), getX(), getY());
            ((MyWorld)getWorld()).updateLives(-1);
            notInvincible = false;
            counter = 0;
        }
    }
    
    private void touchingShips()
    {
        if (isTouching(TieFighter.class))
        {
            ((MyWorld)getWorld()).updateLives(-1);
            removeTouching(TieFighter.class);
            notInvincible = false;
            counter = 0;
        }
        
        if (isTouching(TieBomber.class))
        {
            ((MyWorld)getWorld()).updateLives(-2);
            notInvincible = false;
            counter = 0;
        }
        
        if (isTouching(StarDestroyer.class))
        {
            ((MyWorld)getWorld()).updateLives(-3);
            notInvincible = false;
            counter = 0;
        }
    }   
    
    private void damageFromTieLaser()
    {
        if (isTouching(TieLaser.class))
        {
            ((MyWorld)getWorld()).updateLives(-1);
            removeTouching(TieLaser.class);
            getWorld().addObject(new Explosion(), getX(), getY());
            notInvincible = false;
            counter = 0;
        }
    }
    
    private void damageFromTieMissile()
    {
        if (isTouching(TieMissile.class))
        {
            ((MyWorld)getWorld()).updateLives(-3);
            removeTouching(TieMissile.class);
            getWorld().addObject(new Explosion(), getX(), getY());
            notInvincible = false;
            counter = 0;
        }
    }
    
    private void damageFromSDLaser()
    {
        if (isTouching(SDLaser.class))
        {
            ((MyWorld)getWorld()).updateLives(-5);
            removeTouching(SDLaser.class);
            getWorld().addObject(new Explosion(), getX(), getY());
            notInvincible = false;
            counter = 0;
        }
    }
}


