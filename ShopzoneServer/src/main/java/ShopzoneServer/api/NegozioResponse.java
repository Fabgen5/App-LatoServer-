package ShopzoneServer.api;

import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Utente;

import java.util.Base64;

public class NegozioResponse {

    private Long id;
    private String nome;
    private String descrizione;
    private String citta;
    private String via;
    private String immagineprofilo;
    private int preferenze;
    private boolean preferito;

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

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getImmagineprofilo() {
        return immagineprofilo;
    }

    public void setImmagineprofilo(String immagineprofilo) {
        this.immagineprofilo = immagineprofilo;
    }

    public int getPreferenze() {
        return preferenze;
    }

    public void setPreferenze(int preferenze) {
        this.preferenze = preferenze;
    }

    public boolean isPreferito() {
        return preferito;
    }

    public void setPreferito(boolean preferito) {
        this.preferito = preferito;
    }

    public NegozioResponse(Negozio negozio) {
        this.id = negozio.getId();
        this.nome = negozio.getNome();
        this.descrizione = negozio.getDescrizione();
        this.citta = negozio.getCitta();
        this.via = negozio.getVia();

        this.immagineprofilo = Base64.getEncoder().encodeToString( negozio.getImmagineprofilo());

        this.preferenze = negozio.getPreferiti().size();
    }

    public NegozioResponse(Negozio negozio, Utente utente) {
        this.id = negozio.getId();
        this.nome = negozio.getNome();
        this.descrizione = negozio.getDescrizione();
        this.citta = negozio.getCitta();
        this.via = negozio.getVia();
        this.immagineprofilo = Base64.getEncoder().encodeToString( negozio.getImmagineprofilo());
        this.preferenze = negozio.getPreferiti().size();
        this.preferito=negozio.getPreferiti().contains(utente);
    }
}
