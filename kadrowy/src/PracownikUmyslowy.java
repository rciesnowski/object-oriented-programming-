
public class PracownikUmyslowy extends Pracownik {
    private double ryczalt;
    private int premia;
    private String kierownik;
    private String tel;
    private int pok;

    public PracownikUmyslowy(String imie, String nazwisko, int rokUr, double ryczalt, int premia, String kierownik, String tel, int pok) {
        super(imie, nazwisko, rokUr);
        this.setRyczalt(ryczalt);
        this.setPremia(premia);
        this.setKierownik(kierownik);
        this.setTel(tel);
        this.setpok(pok);
    }

    public double getRyczalt() {
        return ryczalt;
    }

    public void setRyczalt(double ryczalt) {
        this.ryczalt = ryczalt;
    }

    public int getPremia() {
        return premia;
    }

    public void setPremia(int premia) {
        this.premia = premia;
    }

    public String getKierownik() {
        return kierownik;
    }

    public void setKierownik(String kierownik) {
        this.kierownik = kierownik;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getpok() {
        return pok;
    }

    public void setpok(int pok) {
        this.pok = pok;
    }

    public double Pensja() {
        return this.getRyczalt() + (this.getRyczalt() * this.getPremia() / 100);
    }

    @Override
    public String toString() {
        String pensja = "\nPremia:\t\t\t" + this.Pensja() + "zl";
        String spec = "\nRyczalt:\t\t" + this.getRyczalt() + "zl\nPremia:\t\t\t" + this.getPremia() + "%\nKierownik:\t\t" + this.getKierownik() + "\nTelefon:\t\t" + this.getTel() + "\nPokoj:\t\t\t" + this.getpok();
        return super.toString() + spec + pensja;
    }

}
