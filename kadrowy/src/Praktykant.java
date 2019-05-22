
public class Praktykant extends Pracownik {
	private String opiekun;
	private boolean stypendium;

	public Praktykant(String imie, String nazwisko, int rokUr, String opiekun, boolean stypendium) {
		super(imie, nazwisko, rokUr);
		this.setOpiekun(opiekun);
		this.setStypendium(stypendium);
	}

	public String getOpiekun() {
		return opiekun;
	}
	public void setOpiekun(String opiekun) {
		this.opiekun = opiekun;
	}
	public boolean isStypendium() {
		return stypendium;
	}
	public void setStypendium(boolean stypendium) {
		this.stypendium = stypendium;
	}

	public double Pensja() {
		if(this.isStypendium()) return 1100.0;
		else return 0;
	}
	
	@Override
	public String toString() {
		String styp = "Nie";
		if(this.isStypendium()) styp = "Tak";
		String pensja = "\nPensja:\t\t\t" + this.Pensja() + "zl";
		String spec = "\nOpiekun:\t\t" + this.getOpiekun() + "\nStypendium:\t\t" + styp;
		return super.toString() + spec + pensja;
	}
}
