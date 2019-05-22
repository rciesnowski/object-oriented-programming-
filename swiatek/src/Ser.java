import java.awt.*;
import java.util.Random;


public class Ser extends Organism {
    public Ser(int x, int y, Handler handler) {
        super(x, y, 0, handler);
    }
    public void reproduce() {
        Random k = new Random();
        if (k.nextInt()%55 == 0) handler.addOrganism(new Ser(k.nextInt(41)-1, k.nextInt(29)-1, handler));
    }
    @Override
    public void tick() {
        reproduce();
        Random r = new Random();
        if (r.nextInt()%100 == 0) handler.removeOrganism(this);
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(16*x, 16*y,16,16);
    }
}
