import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);

        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
            Greenfoot.setWorld(new flamingoWorld());
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        StartGround startground = new StartGround();
        addObject(startground,216,343);
        StartFla startfla = new StartFla();
        addObject(startfla,211,257);
        startground.setLocation(188,329);
        startfla.setLocation(174,249);
        startfla.setLocation(184,248);
    }
}
