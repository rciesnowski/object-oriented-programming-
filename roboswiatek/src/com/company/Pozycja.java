package com.company;

public class Pozycja {
    private int x, y;
    Pozycja() {}
    Pozycja(int x, int y) {
        x(x);
        y(y);
    }
    public int x() { return x; }
    public void x(int wartosc) { this.x = wartosc; }
    public int y() { return y; }
    public void y(int wartosc) { this.y = wartosc; }

    public double dystans(Pozycja p){
        return Math.sqrt(Math.pow(p.x()-this.x(), 2)+Math.pow(p.y()-this.y(), 2));
    }
    public boolean tozsamosc(Pozycja p){
        return (p.x() == this.x() && p.y() == this.y());
    }
    @Override
    public String toString() {
        return "  (" + x + ", " + y + ")  ";
    }

}
