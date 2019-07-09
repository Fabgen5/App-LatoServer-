package it.univaq.disim.mobile.myunivaq.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "notizie")
public class Notizia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_NOTIZIA", nullable = false)
	private Long id;

	@Column(name = "TITOLO", nullable = false, length = 255)
	private String titolo;

	@Column(name = "DESCRIZIONE", nullable = false, length = 255)
	private String descrizione;

	@Column(name = "IMMAGINE", nullable = false, length = 255)
	private String immagine;


	@Column(name = "DATA_PUBBLICAZIONE", nullable = false)
	private Date dataPubblicazione;

	@ManyToOne
	@JoinColumn(name = "ID_NEGOZIO", nullable = false)
	private Negozio pubblicatoDa;


	@ManyToMany
	@JoinTable(name="UTENTE_NOTIZIA",
			joinColumns={@JoinColumn(name="ID_NOTIZIA")},
			inverseJoinColumns={@JoinColumn(name="ID_UTENTE")})
	private Set<Utente> utentePiace = new HashSet<>();


	@ManyToOne
	@JoinColumn(name = "ID_TIPOLOGIA_NOTIZIA", nullable = false)
	private TipologiaNotizia tipologia;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public Negozio getPubblicatoDa() {
		return pubblicatoDa;
	}

	public void setPubblicatoDa(Negozio pubblicatoDa) {
		this.pubblicatoDa = pubblicatoDa;
	}

	public TipologiaNotizia getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaNotizia tipologia) {
		this.tipologia = tipologia;
	}

	public Set<Utente> getUtentePiace() {
		return utentePiace;
	}

	public void setUtentePiace(Set<Utente> utentePiace) {
		this.utentePiace = utentePiace;
	}

}
