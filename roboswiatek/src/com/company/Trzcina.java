package com.company;

public class Trzcina extends Roslina {

    Trzcina(){};
    Trzcina(int zycie, char znak, int x, int y){
        super(zycie, znak, x, y);
    }

    public Trzcina klon() {
        Trzcina klon = new Trzcina();
        klon.zycie(this.zycie());
        klon.znak(this.znak());
        klon.Pozycja(this.p.x(), this.p.y());
        return klon;
    }
    public void start(){
        this.zycie(0);
        this.znak('T');
    }
}