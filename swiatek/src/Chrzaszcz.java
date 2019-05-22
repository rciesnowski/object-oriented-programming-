import java.awt.*;
import java.util.Random;

public class Chrzaszcz extends Animal {
    public Chrzaszcz(int x, int y, Handler handler) {
        super(x, y, 1, 110, handler);
    }
    public void reproduce() {
        Random k = new Random();
        if ((this.zycie > 30) && (k.nextInt()%60== 0)) handler.addOrganism(new Chrzaszcz(this.getX()+k.nextInt(3) - 1, this.getY() + k.nextInt(3) - 1, handler));
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(16*x, 16*y,16,16);
    }
}
