package ShopzoneServer.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("negoziante")
public class Negoziante extends Utente {


    @ManyToOne
    @JoinColumn(name = "ID_NEGOZIO", nullable = true)
    private Negozio negozio;

    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

}
