
public class Zarzad extends Pracownik {
	private double ryczalt;
	private String asystent;
	private int spotkania;

	public Zarzad(String imie, String nazwisko, int rokUr, double ryczalt, String asystent, int spotkania) {
		super(imie, nazwisko, rokUr);
		this.setRyczalt(ryczalt);
		this.setAsystent(asystent);
		this.setSpotkania(spotkania);
	}

	public double getRyczalt() {
		return ryczalt;
	}
	public void setRyczalt(double ryczalt) {
		this.ryczalt = ryczalt;
	}
	public String getAsystent() {
		return asystent;
	}
	public void setAsystent(String asystent) {
		this.asystent = asystent;
	}
	public int getSpotkania() {
		return spotkania;
	}
	public void setSpotkania(int spotkania) {
		this.spotkania = spotkania;
	}
	
	public double Pensja() {
		return this.getRyczalt()+this.getSpotkania()*500;
	}
	
	@Override
	public String toString() {
		String pensja = "\nPensja:\t\t\t" + this.Pensja() + "zl";
		String spec = "\nRyczalt:\t\t" + this.getRyczalt() + "zl\nAsystent:\t\t" + this.getAsystent() + "\nObecnoœci:\t\t" + this.getSpotkania();
		return super.toString() + spec + pensja;
	}
	
}
