package ShopzoneServer.api;

import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Notizia;

import java.util.Date;

public class NotiziaResponse {

    private Long id;
    private String titolo;
    private String decrizione;
    private String immagine;
    private Date dataPubblicazione;
    private Negozio pubblicatoDa;
    private Long numeroPiace;
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

    public Long getNumeroPiace() {
        return numeroPiace;
    }

    public void setNumeroPiace(Long numeroPiace) {
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
        this.dataPubblicazione = notizia.getDataPubblicazione();
        this.pubblicatoDa = notizia.getPubblicatoDa();
        this.numeroPiace = notizia.getId() * 13;
        if ((this.pubblicatoDa.getId() + this.id) % 2 == 0)
            this.piace = true;
        else {
            this.piace = false;
        }
    }
}
