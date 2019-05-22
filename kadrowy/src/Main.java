public class Main {
    public static void main(String[] args) {
        Kierownik kier = new Kierownik("Anna","Zamojska",1985,5700.0,20,800.0,"649546833",13,"HR");
        System.out.println(kier);
        Zarzad zarz = new Zarzad("Adam","Zdrujski",1989,6200.0,"Zuzanna Allent",14);
        System.out.println(zarz);
        PracownikUmyslowy um = new PracownikUmyslowy("Alicja","Zoll",1994,4100.0,15,"Zdzislaw Adebski","649546833",14);
        System.out.println(um);
        PracownikFizyczny fiz = new PracownikFizyczny("Antoni","Zechter",1993,16.0,120,12,"Zofia Appandarowska","Sprz¹tanko");
        System.out.println(fiz);
        Praktykant prakt = new Praktykant("Abraham","Zerda",1997,"Zbigniew Adamowicz",false);
        System.out.println(prakt);
        Praktykant prakt2 = new Praktykant("Ada","Zuch",1999,"Zuzanna Allent",true);
        System.out.println(prakt2);
    }
}
