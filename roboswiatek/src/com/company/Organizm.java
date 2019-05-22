package com.company;

public class Organizm {
    private int zycie;
    private char znak;
    protected Pozycja p = new Pozycja();

    Organizm(){};
    Organizm(int zycie, char znak, int x, int y){
        zycie(zycie);
        zycie(zycie);
        p.x(x);
        p.y(y);
    }

    public int zycie() { return zycie; }
    public void zycie(int zycie) { this.zycie = zycie; }
    public char znak() { return znak; }
    public void znak(char znak) { this.znak = znak; }
    public Pozycja Pozycja() { return p; }
    public void Pozycja(int x, int y) {
        this.p.x(x);
        this.p.y(y);
    }

    @Override
    public String toString() {
        return  p.toString();
    }

}