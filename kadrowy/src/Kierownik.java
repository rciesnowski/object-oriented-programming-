
public class Kierownik extends Pracownik {
	private double ryczalt;
	private int premia;
	private double bonus;
	private String tel;
	private int pok;
	private String dzial;

	public Kierownik(String imie, String nazwisko, int rokUr, double ryczalt, int premia, double bonus, String tel, int pok, String dzial) {
		super(imie, nazwisko, rokUr);
		this.setRyczalt(ryczalt);
		this.setPremia(premia);
		this.setBonus(bonus);
		this.setTel(tel);
		this.setpok(pok);
		this.setDzial(dzial);
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
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
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
	public String getDzial() {
		return dzial;
	}
	public void setDzial(String dzial) {
		this.dzial = dzial;
	}
	
	public double Pensja() {
		return this.getRyczalt()+(this.getRyczalt()*this.getPremia()/100)+this.getBonus();
	}
	
	@Override
	public String toString() {
		String pensja = "\nPensja:\t\t\t" + this.Pensja() + "zl";
		String spec = "\nRyczalt:\t\t" + this.getRyczalt() + "zl\nPremia:\t\t\t" + this.getPremia() + "%\nBonus:\t\t\t" + this.getBonus() + "zl\nTelefon:\t\t" + this.getTel() + "\nPokoj:\t\t\t" + this.getpok() + "\nDzial:\t\t\t" + this.getDzial();
		return super.toString() + spec + pensja;
	}
}
