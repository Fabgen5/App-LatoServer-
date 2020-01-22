package ShopzoneServer.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

@Entity
@Table(name = "utenti")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UTENTE", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "COGNOME", nullable = false, length = 255)
    private String cognome;

    @Column(name = "USERNAME", nullable = false, length = 16, updatable = false, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "EMAIL", nullable = false, length = 255)
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UTENTE_NOTIZIA_PIACE",
            joinColumns = {@JoinColumn(name = "ID_UTENTE")},
            inverseJoinColumns = {@JoinColumn(name = "ID_NOTIZIA")})
    private Set<Notizia> notiziePiaciute = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "preferiti")
    private Set<Negozio> negoziPreferiti = new HashSet<Negozio>();


    @ManyToOne
    @JoinColumn(name = "ID_NEGOZIO", nullable = true)
    private Negozio negozio;

    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Set<Negozio> getNegoziPreferiti() {
        return negoziPreferiti;
    }

    public void setNegoziPreferiti(Set<Negozio> negoziPreferiti) {
        this.negoziPreferiti = negoziPreferiti;
    }


    public Set<Notizia> getNotiziePiaciute() {
        return notiziePiaciute;
    }

    public void setNotiziePiaciute(Set<Notizia> notiziePiaciute) {
        this.notiziePiaciute = notiziePiaciute;
    }

    public void addNotiziaPiaciuta(Notizia notizia) {
        this.notiziePiaciute.add(notizia);
        notizia.getPiace().add(this);
    }

    public void removeNotiziaPiaciuta(Notizia notizia) {
        this.notiziePiaciute.remove(notizia);
        notizia.getPiace().remove(this);
    }


    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(id, utente.id) &&
                Objects.equals(nome, utente.nome) &&
                Objects.equals(cognome, utente.cognome) &&
                Objects.equals(username, utente.username) &&
                Objects.equals(email, utente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, username, email);
    }
}
