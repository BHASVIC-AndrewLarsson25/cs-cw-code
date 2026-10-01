import greenfoot.*;

public class GameWorld extends World
{
    private static final int screenWidth = 1000;
    private static final int screenHeight = 600;
    
    private int level;

    private boolean levelStarted = false;

    public GameWorld()
    {
        this(GameSettings.currentLevel);
    }

    public GameWorld(int level)
    {
        //create a new world with 1000x600 cells with a cell size of 1x1 pixels
        super(screenWidth, screenHeight, 1);

        this.level = level;

        GameSettings.currentLevel = level;

        buildLevel();

        levelStarted = true;
    }

    public void act()
    {
        checkPause();

        checkLevelComplete();
    }

    private void buildLevel()
    {
        // Player
        //addObject(new Player(),100,450);

        if(level == 1)
        {
            levelOne();
        }
        else if(level == 2)
        {
            levelTwo();
        }
        else if(level == 3)
        {
            levelThree();
        }
        else
        {
            Greenfoot.setWorld(new EndScreen(true));
        }
    }

    private void levelOne()
    {
        //floor
        addObject(new Platform(screenWidth, 40),screenWidth/2,580);

        addObject(new Platform(200, 25),250,450);
        addObject(new Platform(200, 25),600,350);

        addObject(new Enemy(),250,410);
        addObject(new Enemy(),600,310);
    }
