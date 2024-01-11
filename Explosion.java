import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.*;

/**
 * An explosion. It starts by expanding and then collapsing. 
 * The explosion will explode other obejcts that the explosion intersects.
 * 
 * @author 
 * @version 
 */
public class Explosion extends Actor
{
    private final static int IMAGE_COUNT = 8;
    private static GreenfootImage[] images;
    private int imageNo = 0;
    private int increment = 1;

    public Explosion() 
    {
        initialiseImages();
        setImage(images[0]);        
        Greenfoot.playSound("Explosion.wav");
    }    
    
    public synchronized static void initialiseImages() 
    {
        if (images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("Explo3.png");
            int maxSize = baseImage.getWidth();
            int delta = maxSize / IMAGE_COUNT;
            int size = 0;
            images = new GreenfootImage[IMAGE_COUNT];
            for (int i=0; i < IMAGE_COUNT; i++) 
            {
                size = size + delta;
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    public void act()
    { 
        setImage(images[imageNo]);

        imageNo += increment;
        if (imageNo >= IMAGE_COUNT) 
        {
            increment = -increment;
            imageNo += increment;
        }
        
        if (imageNo < 0) 
        {
            getWorld().removeObject(this);
        }
    }
}