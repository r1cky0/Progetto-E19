package flappyEntities.logic;

/**
 *   Componente logica per oggetti che hanno coordinate e velocità
 */
public abstract class GameElementLogicComponent implements LogicComponent {
    private double x;
    private double y;
    private double speedX;
    private double speedY;

    public GameElementLogicComponent(double x, double y, double speedX, double speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double getX(){
        return this.x;
    }
    public  double getY(){
        return this.y;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    /**
     * Esegue l'update delle coordinate x e y a seconda delle rispettive velocità
     * @param i intervallo di tempo trascorso
     */
    @Override
    public void update(double i) {
        x += speedX*i;
        y += speedY*i;
    }
}
