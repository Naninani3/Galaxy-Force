import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Actor
{
    private static final int BLAST_VOLUME = 90;
    private static final int EXPLOSION_VOLUME = 100;
    private static final int SPEED = 5;
    private static final int MAX_EXPLOSION_FRAME = 24;
    private static final int EXPLOSION_SIZE = 380;
    
    private int explosionFrame = 0;
    private boolean explosionSoundPlayed = false;
    
    public Missile() 
    {
        playBlastSound();
    }
    
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shoot();
    }

    public void shoot() 
    {
        if (isAtEdge()) 
        {
            getWorld().removeObject(this);
        } 
        else 
        {
            if (isTouching(TieFighter.class) || isTouching(TieBomber.class) || 
                isTouching(StarDestroyer.class) || isTouching(Asteroids.class)) 
            {
                explode();
            } 
            else 
            {
                setLocation(getX(), getY()-SPEED);
            }
        }
    }
    
    private void explode() 
    {
        
        GreenfootImage frame;
        
        if (explosionFrame > MAX_EXPLOSION_FRAME) 
        {
            explosionFrame = 0;
            killEnemies();
            getWorld().removeObject(this);
        }
               
        frame = new GreenfootImage("Missile/explosion/" + String.format("%02d", explosionFrame) + ".png");
        frame.scale(EXPLOSION_SIZE, EXPLOSION_SIZE);
        setImage(frame);

        if (!explosionSoundPlayed)
        {
            playExplosionSound();
            explosionSoundPlayed = true;
        }
        
        explosionFrame++;
    }
    
    private void killEnemies() 
    {
        MyWorld myWorld = (MyWorld) getWorld();
        
        List<TieFighter> tieFighters = getObjectsInRange(EXPLOSION_SIZE/2, TieFighter.class);
        for (TieFighter tieFighter : tieFighters) 
        {
            myWorld.removeObject(tieFighter);
        }
        
        List<TieBomber> tieBombers = getObjectsInRange(EXPLOSION_SIZE/2, TieBomber.class);
        for (TieBomber tieBomber : tieBombers) 
        {
            myWorld.removeObject(tieBomber);
        }
        
        List<StarDestroyer> starDestroyers = getObjectsInRange(EXPLOSION_SIZE/2, StarDestroyer.class);
        for (StarDestroyer starDestroyer : starDestroyers) 
        {
            myWorld.removeObject(starDestroyer);
        }
        
        List<Asteroids> asteroids = getObjectsInRange(EXPLOSION_SIZE/2, Asteroids.class);
        for (Asteroids asteroid : asteroids) 
        {
            myWorld.removeObject(asteroid);
        }
    }
    
    private void playBlastSound()
    {
        GreenfootSound music = new GreenfootSound("Bomb/blast.mp3");
        music.setVolume(BLAST_VOLUME);
        music.play();
    }
    
    private void playExplosionSound()
    {
        GreenfootSound music = new GreenfootSound("Bomb/explosion.mp3");
        music.setVolume(EXPLOSION_VOLUME);
        music.play();
    }
}
