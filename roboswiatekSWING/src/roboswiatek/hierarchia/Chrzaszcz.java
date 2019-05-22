package roboswiatek.hierarchia;

import java.awt.*;

public class Chrzaszcz extends Zwierze {
    Chrzaszcz(){};
    Chrzaszcz(int zycie, char znak, int x, int y){
        super(zycie, znak, x, y);
    }

    @Override
    public void tick() {
        this.ruch();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(40*p.x(), 40*p.y(), 13, 13);
    }

    public Chrzaszcz(int zycie, int x, int y){
        this.zycie(zycie);
        this.p.x(x);
        this.p.y(y);
        this.znak('C');
    }
    public Chrzaszcz klon() {
        Chrzaszcz klon = new Chrzaszcz();
        //cloned.Animal a = super.clone();
        klon.zycie(this.zycie());
        klon.znak(this.znak());
        klon.Pozycja(this.p.x(), this.p.y());
        return klon;
    }

    public void start(){
        this.zycie(3);
        this.znak('C');
    }
    @Override
    public String toString() {
        return "Chrzaszcz\t| " + zycie() + " zycia\t| " + znak() +  "\n"+super.toString() ;
    }

}
