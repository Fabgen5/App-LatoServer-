package ShopzoneServer.domain;

import org.hibernate.internal.util.compare.ComparableComparator;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "negozio")
public class Negozio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NEGOZIO", nullable = false)
    private Long id;



    @Column(name = "CITTA", nullable = false, length = 255)
    private String citta;

    @Column(name = "VIA", nullable = false, length = 255)
    private String via;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "DESCRIZIONE", nullable = false, length = 255)
    private String descrizione;


    @Column(name = "IMMAGINEPROFILO", nullable = false, length = 255)
    private String immagineprofilo;

    @ManyToMany
    @JoinTable(
            name = "UTENTE_NEGOZIO_PREFERITO",
            joinColumns = @JoinColumn(name = "ID_NEGOZIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_UTENTE")
    )
    private Set<Utente> preferiti = new HashSet<Utente>();

    @OneToMany(cascade =CascadeType.ALL, mappedBy = "negozio", orphanRemoval = true)
    private List<Notizia> notizie = new LinkedList<Notizia>();

    public List<Notizia> getNotizie() {
        return notizie;
    }

    public void setNotizie(List<Notizia> notizie) {
        this.notizie = notizie;
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

    public Set<Utente> getPreferiti() {
        return preferiti;
    }

    public void setPreferiti(Set<Utente> preferiti) {
        this.preferiti = preferiti;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void addPreferenzaUtente(Utente utente){
        this.preferiti.add(utente);
        utente.getNegoziPreferiti().add(this);
    }

    public void removePreferenzaUtente(Utente utente){
        this.preferiti.remove(utente);
        utente.getNegoziPreferiti().remove(this);
    }

    public String getImmagineprofilo() {
        return immagineprofilo;
    }

    public void setImmagineprofilo(String immagineprofilo) {
        this.immagineprofilo = immagineprofilo;
    }

    public void addNotizia(Notizia notizia){
    notizie.add(notizia);
    notizia.setNegozio(this);
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }


    @Override
    public String toString() {
        return "Negozio{" +
                "id=" + id +
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
                Objects.equals(immagineprofilo, negozio.immagineprofilo) &&
                Objects.equals(preferiti, negozio.preferiti) &&
                Objects.equals(notizie, negozio.notizie);
    }

}
