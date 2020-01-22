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

        try{
            Utente utente= Utility.getUtente();
            for (Negozio negozio : negozi) {
                negozioResponse.add(new NegozioResponse(negozio, utente));
            }
            return negozioResponse;
        }
        catch(Exception e){
            System.out.println(e);
            for (Negozio negozio : negozi) {
                negozioResponse.add(new NegozioResponse(negozio));
            }
            return negozioResponse;
        }

    }

    @GetMapping("/{id}")
    public NegozioResponse findById(@PathVariable Long id) {
        NegozioResponse negozioResponse= new  NegozioResponse(service.findNegozioById(id));
        return negozioResponse;
    }

    @GetMapping("/home")
    public NegozioResponse home() {
        Long id = Utility.getUtente().getNegozio().getId();
        NegozioResponse negozioResponse= new  NegozioResponse(service.findNegozioById(id));
        return negozioResponse;
    }



    @PostMapping("/nuovo")
    public Negozio nuovoNegozio(@RequestBody Negozio nuovoNegozio, HttpServletResponse response) {
        Utente utente= Utility.getUtente();
        Negozio negozio = service.nuovoNegozio(nuovoNegozio,utente);
        return negozio;
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


