package logic.gameElements;

import org.newdawn.slick.geom.Rectangle;

import static logic.gameConstants.GameConstants.PIPE_FREE_SPACE;
import static logic.gameConstants.GameConstants.PIPE_HEIGHT;
import static logic.gameConstants.GameConstants.PIPE_WIDTH;

public class StretchingPipe extends GameElement implements SolidElement{
    private final double speedX;
    private double speedY;
    private boolean passed;
    private double pipeSpace = PIPE_FREE_SPACE;

    public StretchingPipe(double x, double centerY, double speedX, double speedY){
        super(x, centerY);
        this.speedX = speedX;
        this.speedY = speedY;
        setX(x);
        setY(centerY);
        addHitboxShape(new Rectangle((float) x, (float) (centerY-PIPE_HEIGHT-pipeSpace/2d), (float)PIPE_WIDTH, (float) PIPE_HEIGHT));
        addHitboxShape(new Rectangle((float) x, (float) (centerY+pipeSpace/2d),  (float)PIPE_WIDTH, (float) PIPE_HEIGHT));
        passed = false;
    }

    @Override
    public void update(int delta) {
        setX(getX() - speedX*delta);
    }

    public void setPassed(boolean passed){
        this.passed = passed;
    }

    public boolean isPassed(){
        return passed;
    }

    public double getSpeedX() {
        return speedX;
    }

}