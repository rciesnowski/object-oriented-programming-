import java.awt.*;
import java.util.Random;

public class Mysz extends Animal {
    public Mysz(int x, int y, Handler handler) {
        super(x, y, 2, 200, handler);
    }
    public void reproduce() {
        Random k = new Random();
        if (k.nextInt()%120 == 0) handler.addOrganism(new Mysz(this.getX()+k.nextInt(3) - 1, this.getY() + k.nextInt(3) - 1, handler));
    }
    @Override
    public void collision(){
        for(int i=0; i<handler.OrganismList.size(); i++){
            Organism tempOrg = handler.OrganismList.get(i);
            if (this.x == tempOrg.x && this.y == tempOrg.y) {
                if (this.getPower() > tempOrg.getPower()) {
                    handler.OrganismList.remove(tempOrg);
                    this.setPower(2*this.getPower()+60);
                }
                else if (this.getPower() == tempOrg.getPower()) this.move();
            }
        }
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillOval(16*x, 16*y,16,16);
    }
}
