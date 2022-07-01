package dominio;

public class Valutazione {
	private int manubri;
	private String usernameCliente;
	private String usernameAllenatore;
	
	public Valutazione(int m, String c, String a) {
		this.manubri = m;
		this.usernameAllenatore = a;
		this.usernameCliente = c;
	}

	public int getManubri() {
		return manubri;
	}

	public void setManubri(int manubri) {
		this.manubri = manubri;
	}

	public String getUsernameCliente() {
		return usernameCliente;
	}

	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}

	public String getUsernameAllenatore() {
		return usernameAllenatore;
	}

	public void setUsernameAllenatore(String usernameAllenatore) {
		this.usernameAllenatore = usernameAllenatore;
	}

}
