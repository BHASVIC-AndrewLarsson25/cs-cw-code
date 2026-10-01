import greenfoot.*;

public class Platform extends Actor
{
    public Platform(int width, int height)
    {
        //load the platform image
        GreenfootImage image = new GreenfootImage("platform1.png");

        //resize it to the size given in GameWorld
        image.scale(width, height);

        setImage(image);
    }
}