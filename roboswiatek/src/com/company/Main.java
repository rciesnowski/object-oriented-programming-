package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void drukowanko(Organizm[] w) {
        System.out.println("nowa sekunda:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                for (int n = 0; n < w.length; n++) {
                if (w[n] != null) if (i == w[n].p.x() && j == w[n].p.y()) System.out.print(w[n].znak() + "|");
                else System.out.print(" |");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {

        Pozycja p1= new Pozycja(3,4);
        Pozycja p2= new Pozycja(5,4);
        if(p1.equals(p2)) System.out.println("tag");

        Organizm[] wszystko = new Organizm[100];

        Chrzaszcz jacek = new Chrzaszcz(3, 5, 6);
        wszystko[0] = jacek;
        Chrzaszcz jacekJr = jacek.klon();
        wszystko[1] = jacekJr;
        drukowanko(wszystko);

        jacek.Pozycja(7, 2);
        jacekJr.ruch();
        drukowanko(wszystko);

        for (int t = 0; t < 20; t++) {
            jacek.ruch();
            jacekJr.ruch();
            drukowanko(wszystko);
        }

        /*for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if
                else System.out.print("\t|");
            }
            System.out.print("\n");
        }*/

    }

}