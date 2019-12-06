package ShopzoneServer.api;

import ShopzoneServer.domain.Negozio;

public class NegozioResponse {

    private Long id;
    private String nome;
    private String immagineprofilo;
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

    public String getImmagineprofilo() {
        return immagineprofilo;
    }

    public void setImmagineprofilo(String immagineprofilo) {
        this.immagineprofilo = immagineprofilo;
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
        this.immagineprofilo = negozio.getImmagineprofilo();
        double rnd = Math.random();
        if (rnd < 0.5) {
            this.preferito = true;
        } else {
            this.preferito = false;
        }
    }
}
