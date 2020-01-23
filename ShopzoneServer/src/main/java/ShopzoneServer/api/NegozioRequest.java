package ShopzoneServer.api;

public class NegozioRequest {

    private String nome;
    private String descrizione;
    private String citta;
    private String via;
    private String immagineprofilo;

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

    public NegozioRequest(String nome, String descrizione, String citta, String via, String immagineprofilo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.citta = citta;
        this.via = via;
        this.immagineprofilo = immagineprofilo;
    }
}
