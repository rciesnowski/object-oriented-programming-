package com.company;
import java.util.Comparator;

public class Product {
    public String name;
    public String code;
    public double price;
    public double discountPrice;

    public Product(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.discountPrice = price;
    }

    public String toString() {
        if(discountPrice != price) return name + "\tCode: " + code + "\t||\tDiscount price: " + discountPrice;
        else return name + "\tCode: " + code + "\t||\tPrice: " + price;
    }

    public String getName() {
        return name;
    }
    public void setName(String n) {
        this.name = n;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(double d) {
        this.discountPrice = d;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double p) {
        this.price = p;
    }

    public static Comparator<Product> NameAsc = new Comparator<Product>() {
        public int compare(Product a, Product b) {
            return a.name.compareTo(b.name);
        }
    };

    public static Comparator<Product> NameDsc = new Comparator<Product>() {
        public int compare(Product a, Product b) {
            return b.name.compareTo(a.name);
        }
    };

    public static Comparator<Product> PriceAsc = new Comparator<Product>() {
        public int compare(Product a, Product b) {
            double priceA = a.getPrice();
            double priceB = b.getPrice();
            return (int) (priceA-priceB);
        }
    };

    public static Comparator<Product> PriceDsc = new Comparator<Product>() {
        public int compare(Product a, Product b) {
            double priceA = a.getPrice();
            double priceB = b.getPrice();
            return (int) (priceB-priceA);
        }
    };
}