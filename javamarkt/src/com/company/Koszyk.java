package com.company;
import java.util.ArrayList;
import java.util.Collections;

public class Koszyk {
    public ArrayList<Product> zakupy = new ArrayList<Product>();

    // wybieranie najtanszych/najdrozszych
    public void findCheap(){
        Collections.sort(zakupy, Product.PriceAsc);
        System.out.println("\nnajtanszy produkt: " + zakupy.get(0));
    }
    public void findCheap(int n){
        Collections.sort(zakupy, Product.PriceAsc);
        System.out.println("\n" + n + " najtanszych produktow: ");
        for(int i=0; i<n;i++) System.out.println(zakupy.get(i));
    }
    public void findExp(){
        Collections.sort(zakupy, Product.PriceDsc);
        System.out.println("\nnajdrozszy produkt: \n" + zakupy.get(0));
    }
    public void findExp(int n){
        Collections.sort(zakupy, Product.PriceDsc);
        for(int i=0; i<n; i++) System.out.println(zakupy.get(i));
    }

    // obliczanie sumy, aplikowanie znizek gratisow
    public String suma() {
        String druczek = "";
        double sum = 0, sum0 = 0;
        for(int i=0; i<zakupy.size(); i++) sum0+=zakupy.get(i).getPrice(); // suma bez znizek

        Product kubek = new Product("KUBEK Z DEDYKACJĄ FREE","000", 0.00);
        //Product d5 = new Product("5% DISCOUNT FOR >300","000", 0.00);
        for (int i = 0; i < zakupy.size(); i++) if (zakupy.get(i).code == "000") zakupy.remove(i);

        Collections.sort(zakupy, Product.PriceAsc);
        if (zakupy.size() == 3) {
            zakupy.get(0).setDiscountPrice(zakupy.get(0).getPrice()*0.70);
            //druczek += "30% DISCOUNT na najtanszy produkt\n";
        }
        else zakupy.get(0).setDiscountPrice(zakupy.get(0).getPrice());

        for(int i=0; i<zakupy.size(); i++) sum+=zakupy.get(i).getDiscountPrice(); // suma ze znizka 30%

        if (sum0 > 200.00) zakupy.add(kubek);
        if (sum0 > 300.00) {
            //d5.setDiscountPrice(-sum0*0.05);
            //zakupy.add(d5);
            druczek += "5% DISCOUNT\n";
            sum *= 0.95;
        }
        //for(int i=0; i<zakupy.size(); i++) sum+=zakupy.get(i).getDiscountPrice(); // podlicza sumę
        druczek += "Total: " + sum0 + "\tTotal (discount): " + sum;
        return druczek;
    }

    // wypisuje koszyk
    public void zawartosc() {
        System.out.println("\nZawartosc koszyka:");
        for(int i=0;i<zakupy.size();i++) System.out.println(zakupy.get(i));
    }

    // wypisuje koszyk + podlicza rachunek
    public void checkOut() {
        String druczek2 = suma();
        zawartosc();
        System.out.println(druczek2);
    }


    public static void main(String[] args) {
        Product apatia = new Product("Apatia z nuta marazmu", "001", 95.00);
        Product brud = new Product("Brud duszy i niepokój", "002", 170.00);
        Product czasy = new Product("Czasy niespokojne i złe", "003", 60.00);
        Product depresja = new Product("Depresja jesiennozimowa", "004", 90.00);
        Koszyk kosz = new Koszyk();

        kosz.zakupy.add(apatia);
        kosz.zakupy.add(brud);
        kosz.zakupy.add(czasy);
        kosz.checkOut();

        kosz.findExp();
        kosz.findCheap(2);

        kosz.zakupy.remove(czasy);
        kosz.checkOut();

        kosz.zakupy.remove(brud);
        kosz.checkOut();

        kosz.zakupy.add(depresja);
        kosz.zakupy.add(czasy);
        kosz.zakupy.add(depresja);
        kosz.checkOut();
    }
}