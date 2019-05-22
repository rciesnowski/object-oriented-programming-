import java.awt.*;
import java.util.Random;

public abstract class Animal extends Organism {
    public int zycie;
    public Animal(int x, int y, int power, int zycie, Handler handler) {
        super(x, y, power, handler);
        this.zycie = zycie;
    }

    public void move(){
        Random k = new Random();
        this.setX(this.getX() + k.nextInt(3) - 1);
        if (this.getX() < 0) this.setX(39);
        else if (this.getX() >= 40) this.setX(0);
        this.setY(this.getY() + k.nextInt(3)- 1);
        if (this.getY() >= 28) this.setY(0);
        else if (this.getY() < 0) this.setY(27);
        zycie -= 1;
    }
    @Override
    public void tick() {
        if (this.zycie <= 0) handler.removeOrganism(this);
        else {
            //this.move();
            collision();
            reproduce();
        }
    }
    abstract public void reproduce();
    @Override
    public void render(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillOval(16*x, 16*y,16,16);
    }
}
