package ShopzoneServer.api;

import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Notizia;
import ShopzoneServer.domain.Utente;

import java.text.Format;
import java.text.SimpleDateFormat;


public class NotiziaResponse {

    private Long id;
    private String titolo;
    private String decrizione;
    private String immagine;
    private String dataPubblicazione;
    private String pubblicatoDa;
    private int numeroPiace;
    private boolean piace;

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

    public String getDecrizione() {
        return decrizione;
    }

    public void setDecrizione(String decrizione) {
        this.decrizione = decrizione;
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


    public String getPubblicatoDa() {
        return pubblicatoDa;
    }

    public void setPubblicatoDa(String pubblicatoDa) {
        this.pubblicatoDa = pubblicatoDa;
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
        this.decrizione = notizia.getDescrizione();
        this.immagine = notizia.getImmagine();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dataPubblicazione = formatter.format(notizia.getDataPubblicazione());
        this.pubblicatoDa = notizia.getNegozio().getNome();
        this.numeroPiace = notizia.getPiace().size();
    }

    public NotiziaResponse(Notizia notizia, Utente utente) {
        this.id = notizia.getId();
        this.titolo = notizia.getTitolo();
        this.decrizione = notizia.getDescrizione();
        this.immagine = notizia.getImmagine();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dataPubblicazione = formatter.format(notizia.getDataPubblicazione());
        this.pubblicatoDa = notizia.getNegozio().getNome();
        this.numeroPiace = notizia.getPiace().size();
        this.piace=notizia.getPiace().contains(utente); }
}
