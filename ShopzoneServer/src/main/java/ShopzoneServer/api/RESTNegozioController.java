package ShopzoneServer.api;


import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Notizia;
import ShopzoneServer.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import ShopzoneServer.business.ShopzoneServerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/negozio")
public class RESTNegozioController {

    @Autowired
    private ShopzoneServerService service;


    @GetMapping
    public List<NegozioResponse> findByLuogo(@RequestParam String citta) {
        List<Negozio> negozi = service.findAllNegozioByLuogo(citta);

        return Utility.negozioResponse(negozi);


    }

    @GetMapping("/{id}")
    public NegozioResponse findById(@PathVariable Long id) {
        NegozioResponse negozioResponse = new NegozioResponse(service.findNegozioById(id));
        return negozioResponse;
    }

    @GetMapping("/{id}/notizie")
    public List<NotiziaResponse> list(@PathVariable Long id) {
        List<Notizia> notizie = service.findAllNotizieNegozio(id);
        return Utility.notiziaResponse(notizie);
    }


    @GetMapping("/home")
    public NegozioResponse home() {
        Long id = Utility.getUtente().getNegozio().getId();
        Negozio negozio = service.findNegozioById(id);
        NegozioResponse negozioResponse = new NegozioResponse(negozio);
        return negozioResponse;
    }

    @PostMapping("/aggiungi")
    public NegozioResponse nuovoNegozio(@RequestBody NegozioRequest nuovoNegozio) {
        Utente utente= Utility.getUtente();
        Negozio negozio = service.nuovoNegozio(nuovoNegozio,utente);
        return new NegozioResponse(negozio);
    }

    @PutMapping("/aggiungi/{id}")
        public NegozioResponse modificaNegozio(@PathVariable(value= "id") Long negozioId,@Valid @RequestBody NegozioRequest negozio){
        Negozio negozioModificato = service.modificaNegozio(negozio, negozioId);
        return new NegozioResponse(negozioModificato);
    }


    @GetMapping("/preferiti")
    public List<NegozioResponse> listaPreferiti() {
        Utente utente = Utility.getUtente();
        List<Negozio> negozi = service.findAllNegoziPreferiti(utente);
        ArrayList<NegozioResponse> negozioResponse = new ArrayList<>();
        for (Negozio negozio : negozi) {
            negozioResponse.add(new NegozioResponse(negozio, utente));
        }
        return negozioResponse;
    }


}


