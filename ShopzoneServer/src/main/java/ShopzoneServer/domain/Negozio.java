package ShopzoneServer.domain;

import ShopzoneServer.api.NegozioRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.internal.util.compare.ComparableComparator;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "negozio")
public class Negozio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NEGOZIO", nullable = false)
    private Long id;


    @Column(name = "CITTA", nullable = false, length = 255)
    private String citta;

    @Column(name = "VIA", nullable = false, length = 255)
    private String via;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "DESCRIZIONE", nullable = false, length = 255)
    private String descrizione;

    @Lob
    @Column(name = "IMMAGINEPROFILO", nullable = false)
    private byte[] immagineprofilo;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "UTENTE_NEGOZIO_PREFERITO",
            joinColumns = @JoinColumn(name = "ID_NEGOZIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_UTENTE")
    )
    private Set<Utente> preferiti = new HashSet<Utente>();

    @OneToMany(mappedBy = "negozio")
    @JsonManagedReference
    private Set<Notizia> notizie = new HashSet<Notizia>();

    public Negozio(NegozioRequest nuovo) {
        this.setNome(nuovo.getNome());
        this.setDescrizione(nuovo.getDescrizione());
        this.setCitta(nuovo.getCitta());
        this.setVia(nuovo.getVia());
        this.setImmagineprofilo(Base64.getDecoder().decode(nuovo.getImmagineprofilo()));
    }

    public Negozio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public byte[] getImmagineprofilo() {
        return immagineprofilo;
    }

    public void setImmagineprofilo(byte[] immagineprofilo) {
        this.immagineprofilo = immagineprofilo;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Set<Notizia> getNotizie() {
        return notizie;
    }

    public void setNotizie(Set<Notizia> notizie) {
        this.notizie = notizie;
    }

    public Set<Utente> getPreferiti() {
        return preferiti;
    }

    public void setPreferiti(Set<Utente> preferiti) {
        this.preferiti = preferiti;
    }

    @Override
    public String toString() {
        return "Negozio{" +
                "id=" + id +
                ", citta='" + citta + '\'' +
                ", via='" + via + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Negozio negozio = (Negozio) o;
        return Objects.equals(id, negozio.id) &&
                Objects.equals(citta, negozio.citta) &&
                Objects.equals(via, negozio.via) &&
                Objects.equals(nome, negozio.nome) &&
                Objects.equals(descrizione, negozio.descrizione) &&
                Objects.equals(immagineprofilo, negozio.immagineprofilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, citta, via, nome, descrizione, immagineprofilo);
    }
}