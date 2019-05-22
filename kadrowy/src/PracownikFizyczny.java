
public class PracownikFizyczny extends Pracownik {
	private double stawkaGodzinowa;
	private int godziny;
	private int nadgodziny;
	private String kierownik;
	private String info;

	public PracownikFizyczny(String imie, String nazwisko, int rokUr, double stawkaGodzinowa, int godziny, int nadgodziny, String kierownik, String info) {
		super(imie, nazwisko, rokUr);
		this.setStawkaGodzinowa(stawkaGodzinowa);
		this.setGodziny(godziny);
		this.setNadgodziny(nadgodziny);
		this.setKierownik(kierownik);
		this.setInfo(info);
	}
	
	public double getStawkaGodzinowa() {
		return stawkaGodzinowa;
	}
	public void setStawkaGodzinowa(double stawkaGodzinowa) {
		this.stawkaGodzinowa = stawkaGodzinowa;
	}
	public int getGodziny() {
		return godziny;
	}
	public void setGodziny(int godziny) {
		this.godziny = godziny;
	}
	public int getNadgodziny() {
		return nadgodziny;
	}
	public void setNadgodziny(int nadgodziny) {
		this.nadgodziny = nadgodziny;
	}
	public String getKierownik() {
		return kierownik;
	}
	public void setKierownik(String kierownik) {
		this.kierownik = kierownik;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public double Pensja() {
		return (this.getStawkaGodzinowa()*this.getGodziny())+(1.5*this.getStawkaGodzinowa()*this.getNadgodziny());
	}
	
	@Override
	public String toString() {
		String pensja = "\nPensja:\t\t\t" + this.Pensja() + "zl";
		String spec = "\nStawka:\t\t\t" + this.getStawkaGodzinowa() + "zl/h\nGodziny:\t\t" + this.getGodziny() + "\nNadgodziny:\t\t" + this.getNadgodziny() + "\nKierownik:\t\t" + this.getKierownik() + "\nUmiejetnosci:\t" + this.getInfo();
		return super.toString() + spec + pensja;
	}
	
}
