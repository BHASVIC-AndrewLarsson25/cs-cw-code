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

    private void levelTwo()
    {
        addObject(
            new Platform(900, 40),
            450,
            580
        );

        addObject(
            new Platform(170, 25),
            200,
            470
        );

        addObject(
            new Platform(170, 25),
            450,
            370
        );

        addObject(
            new Platform(170, 25),
            700,
            270
        );

        addObject(
            new Enemy(),
            200,
            430
        );

        addObject(
            new SpecialEnemy(),
            450,
            330
        );

        addObject(
            new Enemy(),
            700,
            230
        );
    }

    private void levelThree()
    {
        addObject(
            new Platform(900, 40),
            450,
            580
        );

        // Tall wall for wall jumping
        addObject(
            new Platform(40, 250),
            350,
            440
        );

        addObject(
            new Platform(220, 25),
            500,
            300
        );

        addObject(
            new Platform(220, 25),
            750,
            200
        );

        addObject(
            new SpecialEnemy(),
            500,
            260
        );

        addObject(
            new SpecialEnemy(),
            750,
            160
        );
    }

    private void checkLevelComplete()
    {
        if(!levelStarted)
        {
            return;
        }

        //for this version a level is completed when all enemies have been defeated
        if(getObjects(Enemy.class).isEmpty())
        {
            nextLevel();
        }
    }

    private void nextLevel()
    {
        GameSettings.currentLevel++;

        GameSettings.saveLevel();

        Greenfoot.setWorld(
            new GameWorld(
                GameSettings.currentLevel
            )
        );
    }

    private void checkPause()
    {
        String key = Greenfoot.getKey();
    
        if("escape".equals(key))
        {
            Greenfoot.setWorld(new SettingsScreen(this)
            );
        }
    }
}