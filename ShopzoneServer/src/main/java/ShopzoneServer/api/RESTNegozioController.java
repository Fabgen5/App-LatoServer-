package ShopzoneServer.api;


import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import ShopzoneServer.business.ShopzoneServerService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/negozio")
public class RESTNegozioController {

    @Autowired
    private ShopzoneServerService service;


    @GetMapping
    public List<NegozioResponse> findByLuogo(@RequestParam String citta){
        List<Negozio> negozi = service.findAllNegozioByLuogo(citta);
        ArrayList<NegozioResponse> negozioResponse = new ArrayList<>();
        for (Negozio negozio : negozi) {
            negozioResponse.add(new NegozioResponse(negozio));
        }
        return negozioResponse;
    }

    @GetMapping("/{id}")
    public Negozio findById(@PathVariable Long id) {
        return service.findNegozioById(id);
    }

    @PostMapping("/nuovo")
    public Negozio nuovoNegozio(@RequestBody NuovoNegozioRequest nuovoNegozioRequest, HttpServletResponse response) {
        Utente utente= Utility.getUtente();
        System.out.println(utente);

        Negozio nuovoNegozio = service.nuovoNegozio(nuovoNegozioRequest);

        return nuovoNegozio;
    }

    @GetMapping("/preferiti")
    public List<NegozioResponse> listaPreferiti() {
        Utente utente = Utility.getUtente();
        List<Negozio> negozi = service.findAllNegoziPreferiti(utente);
        ArrayList<NegozioResponse> negozioResponse = new ArrayList<>();
        for ( Negozio negozio : negozi ) {
            negozioResponse.add(new NegozioResponse(negozio,utente));
        }
        return negozioResponse;
    }

}


