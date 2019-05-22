import java.awt.*;
import java.util.Random;

public class Wirus extends Organism {
    public Wirus(int x, int y, Handler handler) {
        super(x, y, 3, handler);
    }
    @Override
    public void collision(){
        for(int i=0; i<handler.OrganismList.size(); i++){
            Organism tempOrg = handler.OrganismList.get(i);
            if (this.x == tempOrg.x && this.y == tempOrg.y) {
                if (this.getPower() > tempOrg.getPower()) handler.OrganismList.remove(tempOrg);
                else if (this.getPower() == tempOrg.getPower()) this.move();
            }
        }
    }
    @Override
    public void tick() {
        this.collision();
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(16*x, 16*y,16,16);
    }
}

