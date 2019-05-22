import java.awt.*;
import java.util.Random;

public abstract class Organism {
    public int x;
    public int y;
    public int power;
    public Handler handler;

    private Organism() {};
    public Organism(int x, int y, int power, Handler handler) {
        this.x = x;
        this.y = y;
        this.power = power;
        this.handler= handler;
    }

    public void collision(){
        for(int i=0; i<handler.OrganismList.size(); i++){
            Organism tempOrg = handler.OrganismList.get(i);
            if (this.x == tempOrg.x && this.y == tempOrg.y) {
                if (this.getPower() > tempOrg.getPower()) {
                    handler.OrganismList.remove(tempOrg);
                    this.setPower(this.getPower()+30);
                }
                else if (this.getPower() == tempOrg.getPower()) this.move();
            }
        }
    }
    public void move(){
        Random k = new Random();
        this.setX(this.getX() + k.nextInt(3) - 1);
        if (this.getX() < 0) this.setX(39);
        else if (this.getX() >= 40) this.setX(0);
        this.setY(this.getY() + k.nextInt(3)- 1);
        if (this.getY() >= 28) this.setY(0);
        else if (this.getY() < 0) this.setY(27);
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getPower() { return power; }
    public void setPower(int power) { this.power = power; }
}
