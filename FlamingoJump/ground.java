import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ground extends Actor
{   
    boolean hasBeenBounced;
    int xPos, yPos;
    /**
     * Act - do whatever the ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public ground()
    {
        hasBeenBounced=false;
    }
    
    public ground(boolean bouncable)
    {
        hasBeenBounced=true;
    }
    
    public void act() 
    {
       if(((flamingoWorld) getWorld()).scroll==true)
        {
            scroll(((flamingoWorld) getWorld()).scrollSpeed);
        }

        if(((flamingoWorld) getWorld()).fall==true)
        {
            fall(((flamingoWorld) getWorld()).scrollSpeed);
        }

        if(yPos < 0)
        {
            getWorld().removeObject(this);
            return;
        }
    }
    
     protected void addedToWorld(World world)
    {
        xPos = getX();
        yPos = getY();
    }
    
    public void scroll(int speed)
    {
        if(speed>0)
        {
            yPos = yPos + speed;
            setLocation(xPos, yPos);
        }
    }
    
    public void fall(int speed)
    {
        if(((flamingoWorld) getWorld()).ended==false)
        {
            yPos = yPos + speed;
            setLocation(xPos, yPos);
        }
    }
    
}
