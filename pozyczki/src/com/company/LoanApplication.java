package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;
import java.util.GregorianCalendar;

public class LoanApplication {
    private String firstName;
    private String surName;
    private String pesel;
    private String nip;
    private String bankAccountNumber;
    private Date dateOfBirth;
    private String gender;
    private boolean error;
    private int[] pes;

    public LoanApplication(String fN, String sN, String p, String n, String bAN, Date dOB, String g){
        setFirstName(fN);
        setSurName(sN);
        setPesel(p);
        setNip(n);
        setBankAccountNumber(bAN);
        setDateOfBirth(dOB);
        setGender(g);
    }

    public void setFirstName(String fN) {
        if ((fN != null) && (fN.length() > 1) && Character.isUpperCase(fN.charAt(0)) && fN.matches("[a-zA-Z]+")) this.firstName = fN;
        else {
            System.out.println("ERROR niepoprawne imię");
            this.error = true;
        }
    }

    public void setSurName(String sN) {
        if ((sN != null) && (sN.length() > 1) && Character.isUpperCase(sN.charAt(0)) && sN.matches("[a-zA-Z]+")) this.surName = sN;
        else {
            System.out.println("ERROR niepoprawne nazwisko");
            this.error = true;
        }
    }

    public void setPesel(String p) {
        boolean correct = false;
        if (p.length() == 11) {
            int[] tab = new int[p.length()];
            for(int i = 0; i < p.length(); i++) tab[i] = p.charAt(i) - '0';
            this.pes = tab;
            if ((tab[2]*10+tab[3])%20 < 13) correct = (9*tab[0]+7*tab[1]+3*tab[2]+tab[3]+9*tab[4]+7*tab[5]+3*tab[6]+tab[7]+9*tab[8]+7*tab[9])%10 == tab[10];
        }
        if (correct) this.pesel = p;
        else {
            System.out.println("ERROR niepoprawny PESEL");
            this.error = true;
        }
    }

    public void setNip(String n) {
        boolean correct = false;
        if (n.length() == 10) {
            int[] tab = new int[n.length()];
            for (int i = 0; i < n.length(); i++) tab[i] = n.charAt(i) - '0';
            correct = ((6*tab[0]+5*tab[1]+7*tab[2]+2*tab[3]+3*tab[4]+4*tab[5]+5*tab[6]+6*tab[7]+7*tab[8])%11 == tab[9]);
        }
        if (correct) this.nip = n;
        else {
            System.out.println("ERROR niepoprawny NIP");
            this.error = true;
        }
    }

    public void setBankAccountNumber(String bAN) {
        boolean correct = false;
        if (bAN.length() == 26) {
            int[] tab = new int[bAN.length()];
            for (int i = 0; i < bAN.length(); i++) tab[i] = bAN.charAt(i) - '0';
            correct = (3*tab[2]+9*tab[3]+7*tab[4]+tab[5]+3*tab[6]+9*tab[7]+7*tab[8]+tab[9])%10 == 0;
        }
        if (correct) this.bankAccountNumber = bAN;
        else {
            System.out.println("ERROR niepoprawny numer konta");
            this.error = true;
        }
    }

    public void setDateOfBirth(Date dOB) {
        boolean correct = false;

        LocalDate lD = dOB.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int y = lD.getYear(), m = lD.getMonthValue()-1, d = lD.getDayOfMonth();
        int dP = this.pes[4]*10+this.pes[5];
        int mP = this.pes[2]*10+this.pes[3];
        int yP = this.pes[0]*10+this.pes[1];

        if (dP == d && mP%20 == m) {
            switch((mP-m)/20){
                case 0: yP += 1900; break;
                case 1: yP += 2000; break;
                case 2: yP += 2100; break;
                case 3: yP += 2200; break;
                case 4: yP += 1800; break;
            }
            correct = (yP == y);
        }

        if (correct) this.dateOfBirth = new GregorianCalendar(y, m-1, d).getTime();
        else {
            System.out.println("ERROR niepoprawna data urodzenia");
            this.error = true;
        }
    }

    public void setGender(String g) {
        int p10 = this.pes[9];
        String gP = "E";
        switch (p10%2) {
            case 0: gP = "F"; break;
            case 1: gP = "M"; break;
        }
        if (g.equals(gP)) this.gender = g;
        else {
            System.out.println("ERROR niepoprawna płeć");
            this.error = true;
        }
    }

    @Override
    public String toString() {
        if (error) return "\nERROR niepoprawne dane, patrz wyżej\n";
        else return "\nPozyczkobiorca:\nimię " + firstName + " nazwisko " + surName + " pesel " + pesel + "\nnip " + nip
                + " nr konta " + bankAccountNumber + "\nplec " + gender + " data urodzenia "
                +  new SimpleDateFormat("yyyy/MM/dd").format(dateOfBirth) + "\n";
    }

    public static void main(String[] args) {
        Date d = new GregorianCalendar(1990, 1, 1).getTime();

        LoanApplication gosciu1 = new LoanApplication("Andrzej", "Haha", "90010181011",
                "0123456789", "00000000000000000000000000", d, "M");
        System.out.println(gosciu1);

        LoanApplication gosciu2 = new LoanApplication("2", "aha", "91010181011",
                "0123456799", "00000000001000000000000000", d, "F");
        System.out.println(gosciu2);
    }
}
