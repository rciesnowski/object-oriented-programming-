
public class Pracownik {
	private String imie;
	private String nazwisko;
	private int rokUr;

    public Pracownik(String imie, String nazwisko, int rokUr) {
        this.setImie(imie);
        this.setNazwisko(nazwisko);
        this.setRokUr(rokUr);
    }

    public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getRokUr() {
		return rokUr;
	}
	public void setRokUr(int rokUr) {
		this.rokUr = rokUr;
	}

	@Override
	public String toString() {
		return "\nStanowisko:\t\t" + this.getClass().getSimpleName() + "\nImie:\t\t\t" + this.getImie() + "\nNazwisko:\t\t" + this.getNazwisko() + "\nRok urodzenia:\t" + this.getRokUr();
	}
}
