import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flamingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamingo extends Actor
{
    float ySpeed, xSpeed;
    int x,y;
    boolean canMove;
    GreenfootImage left = new GreenfootImage("Flamingo-left.png");
    GreenfootImage right = new GreenfootImage("Flamingo-right.png");
    ground Ground = new ground();
    int scrollSpeed;
    int hits = 0;
    /**
     * Act - do whatever the Flamingo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Flamingo()
    {
        GreenfootImage images = getImage();
        images.scale(70,80);
        setImage(images);
        canMove = true;
    }
    
    public void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }
   
     public Flamingo(boolean moveable)
    {
        canMove = moveable;
    }
    
    public void act() 
    {
        x = getX();
        y = getY();

        ((flamingoWorld) getWorld()).doodleX = getX();

        if(((flamingoWorld) getWorld()).fall==false)
        {
            bounce();
        }
        if(canMove)
            keys();

        if(ySpeed>11)
            ySpeed = 10;

        setLocation(x+(int)xSpeed, y+(int)ySpeed);

        gravity();
        movement();

        if(canMove & y < 800)
            scrollUp();

        if(y>800)
            fall();

        ((flamingoWorld) getWorld()).height = hits;
        
        if(isTouching(ground2.class))
         Greenfoot.setWorld(new EndScreen());
        
        if(isTouching(ground.class))
        Greenfoot.playSound("jumpsound.mp3");
        
        if(isTouching(ground2.class))
        Greenfoot.playSound("deathsound.mp3");
    }    
    
    public void gravity()
    {
        ySpeed += 0.3f;
    }
    
     public void bounce()
    {
        ground Ground = (ground) getOneIntersectingObject(ground.class);
        if(Ground != null & ySpeed > 0)
        {
            ySpeed = -10;
            if(canMove & !Ground.hasBeenBounced)
            {
                Ground.hasBeenBounced=true;
                {
                    getWorld().addObject(new ground(), Greenfoot.getRandomNumber(600), 0);
                    getWorld().addObject(new ground(), Greenfoot.getRandomNumber(600), 70);
                }
            }
        }
    }
    
    public void keys()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            xSpeed += 0.25f;
            setImage(right);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            xSpeed -= 0.25f;
            setImage(left);
        }
        if(!Greenfoot.isKeyDown("left") & !Greenfoot.isKeyDown("right") & xSpeed != 0)
        {
            xSpeed = 0;
        }
    }
    
        public void movement()
    {
        if(x>600)
        {
            setLocation(0, getY());
        }
        if(x<0)
        {
            setLocation(600,getY());
        }
    }
    
    public void scrollUp()
    {
        if(y<=200 & y>100)
        {
            ((flamingoWorld) getWorld()).scrollSpeed = (int) -ySpeed;
            ((flamingoWorld) getWorld()).scroll = true;
            hits++;
        }
        else if(y<=100)
        {
            ((flamingoWorld) getWorld()).scrollSpeed = (int) -ySpeed*2;
            ((flamingoWorld) getWorld()).scroll = true;
            hits++;
        }

        else
        {
            ((flamingoWorld) getWorld()).scroll = false;
        }
    }
    
     public void fall()
    {
        ((flamingoWorld) getWorld()).fall = true;
        ((flamingoWorld) getWorld()).scrollSpeed = (int) -ySpeed;
    }
    
}
