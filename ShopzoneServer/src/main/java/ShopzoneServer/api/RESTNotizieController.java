package ShopzoneServer.api;

import java.util.ArrayList;
import java.util.List;

import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ShopzoneServer.business.ShopzoneServerService;
import ShopzoneServer.domain.Notizia;


@RestController
@RequestMapping("/api/notizie")
public class RESTNotizieController {

    @Autowired
    private ShopzoneServerService service;

    @GetMapping
    public List<NotiziaResponse> list() {
        try{
           Utente utente= Utility.getUtente();
            List<Notizia> notizie = service.findAllNotizie();
            ArrayList<NotiziaResponse> notizieResponse = new ArrayList<>();
            for (Notizia notizia : notizie) {
                notizieResponse.add(new NotiziaResponse(notizia,utente));
            }
            return notizieResponse;
        }
        catch(Exception e){
            System.out.println(e);
            List<Notizia> notizie = service.findAllNotizie();
            ArrayList<NotiziaResponse> notizieResponse = new ArrayList<>();
            for (Notizia notizia : notizie) {
                notizieResponse.add(new NotiziaResponse(notizia));
            }
            return notizieResponse;
        }

    }

    @PostMapping("/aggiungi")
    public Notizia nuovaNotizia(@RequestBody NuovanotiziaRequest nuovanotiziaRequest) {
        System.out.println("sono qui");
        Notizia nuovaNotizia = service.nuovaNotizia(nuovanotiziaRequest);
        return nuovaNotizia;
    }

    @GetMapping("/{id}")
    public NotiziaResponse findById(@PathVariable Long id) {
        return new NotiziaResponse(service.findNotiziaById(id));
    }



}


