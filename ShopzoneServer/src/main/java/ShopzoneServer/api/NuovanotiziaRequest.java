package ShopzoneServer.api;

import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.Negoziante;
import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Utente;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class NuovanotiziaRequest implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	private String titolo;
	private String descrizione;
	private Timestamp data_pubblicazione;
	private String immagine;
	private Negozio id_negozio;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Timestamp getData_pubblicazione() {
		return data_pubblicazione;
	}

	public void setData_pubblicazione(Timestamp data_pubblicazione) {
		this.data_pubblicazione = data_pubblicazione;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public Negozio getId_negozio() {
		return id_negozio;
	}

	public void setId_negozio(Negozio id_negozio) {
		this.id_negozio = id_negozio;
	}

	public NuovanotiziaRequest(String titolo, String descrizione) {
		this.setTitolo(titolo);
		this.setDescrizione(descrizione);
		Negoziante negoziante = (Negoziante) Utility.getUtente();
		this.setId_negozio(negoziante.getNegozio());
	}
}
