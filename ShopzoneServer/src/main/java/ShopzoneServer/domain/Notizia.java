package ShopzoneServer.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @Lob
    @Column(name = "IMMAGINE")
    private byte[] immagine;


    @Column(name = "DATA_PUBBLICAZIONE")
    private Date dataPubblicazione;

    @ManyToOne
    @JoinColumn(name = "ID_NEGOZIO", nullable = false)
    @JsonBackReference
    private Negozio negozio;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "notiziePiaciute")
    private Set<Utente> piace = new HashSet<Utente>();


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

    public byte[] getImmagine() {
        return immagine;
    }

    public void setImmagine(byte[] immagine) {
        this.immagine = immagine;
    }

    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    public Set<Utente> getPiace() {
        return piace;
    }

    public void setPiace(Set<Utente> piace) {
        this.piace = piace;
    }

    public void addPiace(Utente utente) {
        this.piace.add(utente);
        //utente.getNotiziePiaciute().add(this);
    }

    public void removePiace(Utente utente) {

        this.piace.remove(utente);
        // utente.getNotiziePiaciute().remove(this);
    }


    @Override
    public String toString() {
        return "Notizia{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", immagine='" + immagine + '\'' +
                ", dataPubblicazione=" + dataPubblicazione +
                ", negozio=" + negozio +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notizia notizia = (Notizia) o;
        return Objects.equals(id, notizia.id) &&
                Objects.equals(titolo, notizia.titolo) &&
                Objects.equals(descrizione, notizia.descrizione) &&
                Objects.equals(immagine, notizia.immagine) &&
                Objects.equals(dataPubblicazione, notizia.dataPubblicazione) &&
                Objects.equals(negozio, notizia.negozio) &&
                Objects.equals(piace, notizia.piace);
    }

}
