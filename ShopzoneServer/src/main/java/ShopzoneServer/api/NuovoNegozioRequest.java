package ShopzoneServer.api;

import java.io.Serializable;

public class NuovoNegozioRequest implements Serializable {
    private static final long serialVersionUID = -8445943548965154778L;

    private String nome;
    private String descrizione;
    private String orario;
    private String categoria;
    private String giorni;
    private String piva;
    private String immagine;
    private String luogo;

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getOrario() {
        return this.orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGiorni() {
        return this.giorni;
    }

    public void setGiorni(String giorni) {
        this.giorni = giorni;
    }

    public String getPiva() {
        return this.piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getImmagine() {
        return this.immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public NuovoNegozioRequest(String nome, String descrizione, String orario, String categoria, String giorni, String piva, String immagine, String luogo) {
        this.setNome(nome);
        this.setDescrizione(descrizione);
        this.setOrario(orario);
        this.setCategoria(categoria);
        this.setGiorni(giorni);
        this.setPiva(piva);
        this.setImmagine(immagine);
        this.setLuogo(luogo);
    }

}
