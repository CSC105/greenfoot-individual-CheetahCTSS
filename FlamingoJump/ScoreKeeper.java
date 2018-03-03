import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreKeeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreKeeper extends Actor
{   
    GreenfootImage image = new GreenfootImage(100,10);
    /**
     * Act - do whatever the ScoreKeeper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public ScoreKeeper()
    {
        setImage(image);
    }
    
    public void act() 
    {
        image.clear();
        image.drawString(((flamingoWorld) getWorld()).height + " Points", 10,10);
        setImage(image);   
    }    
    
    
}
