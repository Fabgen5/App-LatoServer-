package ShopzoneServer.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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

    @Column(name = "IMMAGINE", length = 255)
    private String immagine;


    @Column(name = "DATA_PUBBLICAZIONE")
    private Date dataPubblicazione;

    @ManyToOne
    @JoinColumn(name = "ID_NEGOZIO", nullable = false)
    private Negozio negozio;


    @ManyToMany(mappedBy = "notiziepreferite")
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
