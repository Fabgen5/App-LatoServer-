package it.univaq.disim.mobile.myunivaq.api;

import it.univaq.disim.mobile.myunivaq.domain.Docente;
import it.univaq.disim.mobile.myunivaq.domain.Negoziante;
import it.univaq.disim.mobile.myunivaq.domain.Utente;

public class UtenteResponse {

	private String username;
	private String nome;
	private String cognome;
	private String email;
	private String matricola;
	private String ruolo;
	private String telefono;

	public UtenteResponse(Utente utente) {
		this.nome = utente.getNome();
		this.cognome = utente.getCognome();
		this.username = utente.getUsername();
		this.email = utente.getEmail();
		if (utente instanceof Negoziante) {
			this.ruolo = "negoziante";
		} else {
			this.ruolo = "base";
		}
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

}
