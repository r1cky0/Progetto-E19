package graphics;

import logic.gameElements.Bird;
import logic.gameElements.Coin;
import logic.gameElements.Heart;
import logic.gameElements.Pipe;
import org.newdawn.slick.*;

import static logic.gameConstants.GameConstants.*;


public class SpriteDrawer{
    private Image birdImage;
    private Image coinImage;
    private Image heartImage;
    private Image lowerPipeImage;
    private Image upperPipeImage;
    private Image backgroundSingle;
    private Image backgroundMulti;
    private SpriteSheet coinSheet;
    private Animation coinAnimation;
    private SpriteSheet heartSheet;
    private Animation heartAnimation;
    private int screenWidth;
    private int screenHeight;

    public SpriteDrawer(int screenWidth, int screenHeight){
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        System.out.println(screenWidth + " " + screenHeight);
        try {
            backgroundSingle = new Image("res/cimitero.png").getScaledCopy(screenWidth/2,screenHeight);
            birdImage = new Image("res/bird.png").getScaledCopy((int)BIRD_SIZE*screenWidth, (int)BIRD_SIZE*screenHeight);
            heartImage = new Image("res/heart_full.png").getScaledCopy((int)HEART_SIZE*screenWidth, (int)HEART_SIZE*screenHeight);
            coinImage = new Image("res/onecoin.png").getScaledCopy((int)COIN_SIZE*screenWidth, (int)COIN_SIZE*screenHeight);
            lowerPipeImage= new Image("res/pipe.png").getScaledCopy((int)PIPE_WIDTH*screenWidth, (int)(PIPE_WIDTH*PIPE_WIDTH_HEIGHT_PROPORTION*screenHeight));
            upperPipeImage= lowerPipeImage.getFlippedCopy(false, true);

            coinSheet = new SpriteSheet("res/Coin.png",32,32);
            coinAnimation = new Animation(coinSheet,100);

            heartSheet = new SpriteSheet("res/Items_Heart.png", 32, 32);
            heartAnimation = new Animation(heartSheet, 100);

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    public void drawBackgroundSingle(Graphics graphics){
        graphics.drawImage(backgroundSingle,screenWidth/4,0);
    }

    public void drawBird(Bird bird, Graphics graphics){
        graphics.drawImage(birdImage, (float)bird.getX(),(float)bird.getY());
    }

    public void drawCoin(Coin coin, Graphics graphics){
        graphics.drawImage(coinImage, (float)coin.getX(),(float)coin.getY());
    }

    public void drawHeart(Heart heart, Graphics graphics){
        graphics.drawImage(heartImage, (float)heart.getX(),(float)heart.getY());
    }

    public void drawPipe(Pipe pipe, Graphics graphics){
        graphics.drawImage(lowerPipeImage, (float)pipe.getX(), (float)pipe.getY());
        graphics.drawImage(upperPipeImage, (float)pipe.getX(), (float)pipe.getY());
    }
}

        /* PIPE
        width= WIDTH_PROPORION * container.getWidth();
         height= width* WIDTH_HEIGHT_PROPORTION;
         x=sfasamento;
         y=center;
         upperShape= new Rectangle(x, y-height-0.5f*FREE_SPACE_PROPORTION*container.getHeight(), width, height);
         lowerShape= new Rectangle(x, y+0.5f*FREE_SPACE_PROPORTION*container.getHeight(), width, height);*/