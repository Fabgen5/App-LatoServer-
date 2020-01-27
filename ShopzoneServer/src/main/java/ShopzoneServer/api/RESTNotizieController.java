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

import javax.validation.Valid;


@RestController
@RequestMapping("/api/notizie")
public class RESTNotizieController {

    @Autowired
    private ShopzoneServerService service;

    @GetMapping
    public List<NotiziaResponse> list() {
        List<Notizia> notizie = service.findAllNotizie();
        return Utility.notiziaResponse(notizie);

    }


    @PostMapping("/aggiungi")
    public NotiziaResponse nuovaNotizia(@RequestBody NotiziaRequest notizia) {
        Negozio negozio = Utility.getUtente().getNegozio();
        Notizia nuovaNotizia = service.nuovaNotizia(notizia,negozio);
        return new NotiziaResponse(nuovaNotizia);
    }

    @DeleteMapping("/{id}")
    public void eliminaNotizia(@PathVariable(value= "id") long idNotizia ) {
        Notizia notizia = service.findNotiziaById(idNotizia);
        Utente utente = Utility.getUtente();
        if(utente.getNegozio().getId() == notizia.getNegozio().getId()){
            service.eliminaNotizia(idNotizia);
        }
    }

    @PutMapping("/{id}")
    public NotiziaResponse modificaNotizia(@PathVariable(value= "id") Long notiziaId, @Valid @RequestBody NotiziaRequest notizia) {
        Notizia notiziaModificata = service.modificaNotizia(notizia, notiziaId);
        return new NotiziaResponse(notiziaModificata);
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

    @PostMapping("/{id}/piace")
    public NotiziaResponse notiziaPiace(@PathVariable long id){
        Utente utente = Utility.getUtente();
        NotiziaResponse notiziaResponse = new NotiziaResponse(service.miPiace(id , utente.getId()), utente);
        return notiziaResponse;
    }

    @DeleteMapping("/{id}/piace")
    public NotiziaResponse notiziaRimuoviPiace(@PathVariable long id){
        Utente utente = Utility.getUtente();
        NotiziaResponse notiziaResponse = new NotiziaResponse(service.rimuoviPiace(id , utente.getId()), utente );
        return notiziaResponse;
    }


}


