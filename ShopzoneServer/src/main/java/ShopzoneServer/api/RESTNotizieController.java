package ShopzoneServer.api;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ShopzoneServer.business.ShopzoneServerService;
import ShopzoneServer.domain.Notizia;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/notizie")
public class RESTNotizieController {

    @Autowired
    private ShopzoneServerService service;

    @GetMapping
   public List<NotiziaResponse> list() {
        List<Notizia> notizie = service.findAllNotizie();
        ArrayList<NotiziaResponse> notizieResponse = new ArrayList<>();
        for(Notizia notizia: notizie){
               notizieResponse.add(new NotiziaResponse(notizia));
        }
        return notizieResponse ;
    }

    @PostMapping
    public Notizia createNotizia(@RequestBody Notizia notizia)  {
        Utente utente = Utility.getUtente();
        notizia.setNegozio

    }

    @PostMapping
    public List<Negozio>  findByLuogo(@RequestBody String luogo, HttpServletResponse response) {


        List<Negozio> negozi = service.findAllNegozioByLuogo(luogo);
        ArrayList<NegozioResponse> negozioResponse = new ArrayList<>();
        for(Negozio negozio: negozi){
            negozioResponse.add(new NegozioResponse(negozio));
        }
        return service.findAllNegozioByLuogo(luogo);
    }

    @GetMapping("/{id}")
    public NotiziaResponse findById(@PathVariable Long id) {
        return new NotiziaResponse(service.findNotiziaById(id));
    }

}
