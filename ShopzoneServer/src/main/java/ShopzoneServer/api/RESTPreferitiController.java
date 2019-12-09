package ShopzoneServer.api;

import ShopzoneServer.business.ShopzoneServerService;
import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Notizia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/preferiti")
public class RESTPreferitiController {

    @Autowired
    private ShopzoneServerService service;

    @GetMapping
   public List<NotiziaResponse> list() {
        long preferito=1;
        List<Notizia> notizie = service.findNotiziePreferite(service.findNegozioById(preferito));
        ArrayList<NotiziaResponse> notizieResponse = new ArrayList<>();
        for(Notizia notizia: notizie){
               notizieResponse.add(new NotiziaResponse(notizia));
        }
        return notizieResponse ;
    }
}
