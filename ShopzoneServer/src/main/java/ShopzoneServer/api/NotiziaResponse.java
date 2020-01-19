package ShopzoneServer.api;

import ShopzoneServer.domain.Notizia;
import ShopzoneServer.domain.Utente;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Base64;


public class NotiziaResponse {

    private Long id;
    private String titolo;
    private String decrizione;
    private String immagine;
    private String dataPubblicazione;
    private String nomeNegozio;
    private long idNegozio;
    private String immagineNegozio;
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

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public void setNomeNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
    }

    public long getIdNegozio() {
        return idNegozio;
    }

    public void setIdNegozio(long idNegozio) {
        this.idNegozio = idNegozio;
    }

    public String getImmagineNegozio() {
        return immagineNegozio;
    }

    public void setImmagineNegozio(String immagineNegozio) {
        this.immagineNegozio = immagineNegozio;
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
        this.immagine = Base64.getEncoder().encodeToString( notizia.getImmagine());
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dataPubblicazione = formatter.format(notizia.getDataPubblicazione());
        this.nomeNegozio = notizia.getNegozio().getNome();
        this.idNegozio= notizia.getNegozio().getId();
        this.immagineNegozio = Base64.getEncoder().encodeToString( notizia.getNegozio().getImmagineprofilo());
        this.numeroPiace = notizia.getPiace().size();
    }

    public NotiziaResponse(Notizia notizia, Utente utente) {
        this.id = notizia.getId();
        this.titolo = notizia.getTitolo();
        this.decrizione = notizia.getDescrizione();
        this.immagine =Base64.getEncoder().encodeToString(  notizia.getImmagine());
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dataPubblicazione = formatter.format(notizia.getDataPubblicazione());
        this.nomeNegozio = notizia.getNegozio().getNome();
        this.idNegozio= notizia.getNegozio().getId();
        this.immagineNegozio = Base64.getEncoder().encodeToString( notizia.getNegozio().getImmagineprofilo());
        this.numeroPiace = notizia.getPiace().size();
        this.piace=notizia.getPiace().contains(utente); }
}
