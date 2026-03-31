package biblioteka;

import java.util.Objects;

public class Autor {
	private String ime;
	private String prezime;
	
	public Autor() {
	}
	
	public Autor(String ime, String prezime) {
		this.setIme(ime);
		this.setPrezime(prezime);
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		if (ime == null) {
			throw new NullPointerException("IME NE SME BITI NULL");
		}
		if (ime.isEmpty()) {
			throw new IllegalArgumentException("IME NE SME BITI PRAZNO");
		}
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		if (prezime == null) {
			throw new NullPointerException("PREZIME NE SME BITI NULL");
		}
		if (prezime.isEmpty()) {
			throw new IllegalArgumentException("PREZIME NE SME BITI PRAZNO");
		}
		this.prezime = prezime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ime, prezime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(ime, other.ime) && Objects.equals(prezime, other.prezime);
	}

	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}
	
	

}
