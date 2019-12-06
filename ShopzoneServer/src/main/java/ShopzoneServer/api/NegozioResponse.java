package ShopzoneServer.api;

import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Notizia;

import java.util.Date;

public class NegozioResponse {

    private Long id;
    private String nome;
    private String immagineprofilo;
    private boolean preferito;



    public NegozioResponse(Negozio negozio) {
        this.id = negozio.getId();
        this.nome = negozio.getNome();
        this.immagineprofilo = negozio.getImmagineprofilo();
        double rnd= Math.random();
        if(rnd< 0.5 ){

            this.preferito = true;
        }else{
            this.preferito = false;
        }
    }
}
