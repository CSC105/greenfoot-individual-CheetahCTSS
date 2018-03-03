import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class flamingoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flamingoWorld extends World
{
    int scrollSpeed;
    boolean scroll;
    boolean fall;
    boolean ended;

    int height = 0;
    int doodleX;
    /**
     * Constructor for objects of class flamingoWorld.
     * 
     */
    public flamingoWorld()
    {   
        super(600, 800, 1);
        setPaintOrder(ScoreKeeper.class, Flamingo.class, ground.class);
        fall = false;
        prepare();
    }
    
    public void act()
    {
      if(fall)
        {
         end();
        }  
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ground ground = new ground();
        addObject(ground,69,283);
        ground.setLocation(60,281);
        ground ground2 = new ground();
        addObject(ground2,190,290);
        ground ground3 = new ground();
        addObject(ground3,364,295);
        ground ground4 = new ground();
        addObject(ground4,495,324);
        ground2.setLocation(185,281);
        ground3.setLocation(310,280);
        ground4.setLocation(435,281);
        ground ground5 = new ground();
        addObject(ground5,566,289);
        ground5.setLocation(560,282);
        ground ground6 = new ground();
        addObject(ground6,82,469);
        ground ground7 = new ground();
        addObject(ground7,421,566);
        ground ground8 = new ground();
        addObject(ground8,156,693);
        ground ground9 = new ground();
        addObject(ground9,483,423);
        Flamingo flamingo = new Flamingo();
        addObject(flamingo,350,123);
        flamingo.setLocation(286,174);
        ground2 ground22 = new ground2();
        addObject(ground22,64,799);
        ground22.setLocation(61,792);
        ground2 ground23 = new ground2();
        addObject(ground23,190,799);
        ground23.setLocation(183,792);
        ground2 ground24 = new ground2();
        addObject(ground24,312,799);
        ground24.setLocation(304,792);
        ground2 ground25 = new ground2();
        addObject(ground25,498,751);
        ground25.setLocation(426,792);
        ground2 ground26 = new ground2();
        addObject(ground26,588,703);
        ground26.setLocation(547,792);
        ScoreKeeper scorekeeper = new ScoreKeeper();
        addObject(scorekeeper,477,30);
    }
    
    public void end()
    {
      Greenfoot.setWorld(new EndScreen());
    }
}
