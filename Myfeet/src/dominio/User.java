package dominio;

public abstract class User extends Account{
	
	private String nome;
	private String cognome;
	private UserState userState;
	
	public User(String username, String nome, String cognome) {
		super(username);
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setUserState(UserState u) {
		this.userState = u;
	}
	
	public UserState getUserState() {
		return this.userState;
	}
	
}
