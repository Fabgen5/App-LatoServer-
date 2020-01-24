package ShopzoneServer.api;

import ShopzoneServer.domain.Notizia;
import ShopzoneServer.domain.Utente;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Base64;


public class NotiziaResponse {

    private Long id;
    private String titolo;
    private String descrizione;
    private String immagine;
    private String dataPubblicazione;
    private int numeroPiace;
    private boolean piace;
    private NegozioResponse negozio;


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

    public void setDescrizione(String decrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(String dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public NegozioResponse getNegozioResponse() {
        return negozio;
    }

    public void setNegozioResponse(NegozioResponse negozioResponse) {
        this.negozio = negozioResponse;
    }

    public int getNumeroPiace() {
        return numeroPiace;
    }

    public void setNumeroPiace(int numeroPiace) {
        this.numeroPiace = numeroPiace;
    }

    public boolean isPiace() {
        return piace;
    }

    public void setPiace(boolean piace) {
        this.piace = piace;
    }

    public NotiziaResponse(Notizia notizia) {
        this.id = notizia.getId();
        this.titolo = notizia.getTitolo();
        this.descrizione = notizia.getDescrizione();
        this.immagine = Base64.getEncoder().encodeToString( notizia.getImmagine());
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dataPubblicazione = formatter.format(notizia.getDataPubblicazione());

        this.setNegozioResponse(new NegozioResponse(notizia.getNegozio()));
        this.numeroPiace = notizia.getPiace().size();
    }

    public NotiziaResponse(Notizia notizia, Utente utente) {
        this.id = notizia.getId();
        this.titolo = notizia.getTitolo();
        this.descrizione = notizia.getDescrizione();
        this.immagine =Base64.getEncoder().encodeToString(notizia.getImmagine());
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dataPubblicazione = formatter.format(notizia.getDataPubblicazione());

        this.setNegozioResponse(new NegozioResponse(notizia.getNegozio()));


        this.numeroPiace = notizia.getPiace().size();
        this.piace=notizia.getPiace().contains(utente); }
}
