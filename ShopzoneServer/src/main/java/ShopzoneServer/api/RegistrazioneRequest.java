package ShopzoneServer.api;

import java.io.Serializable;

public class RegistrazioneRequest implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String password;

	public RegistrazioneRequest() {
		super();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegistrazioneRequest(String nome, String cognome, String email, String username, String password) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
		this.setUsername(username);
		this.setPassword(password);
	}
}
