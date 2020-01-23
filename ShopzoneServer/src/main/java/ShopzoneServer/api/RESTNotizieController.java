package ShopzoneServer.api;

import java.util.ArrayList;
import java.util.List;

import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ShopzoneServer.business.ShopzoneServerService;
import ShopzoneServer.domain.Notizia;

import javax.rmi.CORBA.Util;


@RestController
@RequestMapping("/api/notizie")
public class RESTNotizieController {

    @Autowired
    private ShopzoneServerService service;

    @GetMapping
    public List<NotiziaResponse> list() {
        List<Notizia> notizie = service.findAllNotizie();
        ArrayList<NotiziaResponse> notizieResponse = new ArrayList<>();
        try{
           Utente utente= Utility.getUtente();
            for (Notizia notizia : notizie) {
                notizieResponse.add(new NotiziaResponse(notizia,utente));
            }
            return notizieResponse;
        }
        catch(Exception e){
            System.out.println(e);

            for (Notizia notizia : notizie) {
                notizieResponse.add(new NotiziaResponse(notizia));
            }
            return notizieResponse;
        }

    }


    @PostMapping("/aggiungi")
    public NotiziaResponse nuovaNotizia(@RequestBody NotiziaRequest notizia) {
        Negozio negozio = Utility.getUtente().getNegozio();
        Notizia nuovaNotizia = service.nuovaNotizia(notizia,negozio);
        return new NotiziaResponse(nuovaNotizia);
    }

    @GetMapping("/{id}")
    public NotiziaResponse findById(@PathVariable Long id) {
        try{
            Utente utente= Utility.getUtente();
            return new NotiziaResponse(service.findNotiziaById(id),utente);
        }
        catch(Exception e){
            return new NotiziaResponse(service.findNotiziaById(id));
        }

    }

    @PutMapping("/{id}/{piace}")
    public void miPiace(@PathVariable long id,@PathVariable int piace){
        Utente utente= Utility.getUtente();
        service.miPiace(id, piace, utente);
    }


    @DeleteMapping("/{id}")
    public void eliminaNotizia(@PathVariable long idNotizia ) {
        Negozio negozio = Utility.getUtente().getNegozio();
        service.eliminaNotizia(idNotizia , negozio);
    }

    @PutMapping
    public void modificaNotizia(@RequestBody Notizia notizia) {
        service.modificaNotizia(notizia);
    }

}


