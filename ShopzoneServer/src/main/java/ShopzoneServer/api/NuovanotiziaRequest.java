package ShopzoneServer.api;

import ShopzoneServer.domain.Negozio;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class NuovanotiziaRequest implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	private String titolo;
	private String descrizione;
	//private Timestamp data_pubblicazione;
	//private String immagine;
	//private Negozio id_negozio;

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



	public NuovanotiziaRequest(String titolo, String descrizione) {
		this.titolo = titolo;
		this.descrizione = descrizione;
/////
	}
}
