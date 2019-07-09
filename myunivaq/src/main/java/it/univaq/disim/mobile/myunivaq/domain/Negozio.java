package it.univaq.disim.mobile.myunivaq.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "negozio")
public class Negozio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NEGOZIO", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "DESCRIZIONE", nullable = false, length = 255)
    private String descrizione;

    @Column(name = "ORARIO", nullable = false, length = 255)
    private String orario;

    @Column(name = "CATEGORIA", nullable = false, length = 255)
    private String categoria;

    @Column(name = "GIORNIAPERTURA", nullable = false, length = 255)
    private String giorniapertura;

    @Column(name = "PIVA", nullable = false, length = 255)
    private String piva;



    @Column(name = "IMMAGINEPROFILO", nullable = false, length = 255)
    private String immagineprofilo;

    public String getImmagineprofilo() {
        return immagineprofilo;
    }

    public void setImmagineprofilo(String immagineprofilo) {
        this.immagineprofilo = immagineprofilo;
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

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGiorniapertura() {
        return giorniapertura;
    }

    public void setGiorniapertura(String giorniapertura) {
        this.giorniapertura = giorniapertura;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

}
