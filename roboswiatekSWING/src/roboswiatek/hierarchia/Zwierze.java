package roboswiatek.hierarchia;
import java.util.Random;

public abstract class Zwierze extends Organizm {
    private Random r = new Random();
    Zwierze(){};
    Zwierze(int zycie, char znak, int x, int y){
        super(zycie, znak, x, y);
    }

    public void ruch(){
        this.p.x(this.p.x()+r.nextInt(3)-1);
        this.p.y(this.p.y()+r.nextInt(3)-1);
    }

    @Override
    public String toString() {
        return super.toString();
    }

	/*public Zwierze klon(){
		Zwierze klon = new Zwierze(this.zycie(), this.znak(), this.p.x(), this.p.y() );
		return klon;
	}*/
}