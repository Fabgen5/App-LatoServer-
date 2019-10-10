package ShopzoneServer.api;


import ShopzoneServer.domain.Negozio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShopzoneServer.business.ShopzoneServerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/negozio")
public class RESTNegozioController {

    @Autowired
    private ShopzoneServerService service;

   /* @GetMapping("/{id}")
    public Negozio findById(@PathVariable Long id) {
        return service.findNegozioById(id);
    }*/
   @GetMapping("/{id}")
   public List<Negozio>  findById(@PathVariable Long id) {
       String teramo = "teramo";

       ArrayList<Negozio> Negozi = (ArrayList<Negozio>) service.findAllNegozioByLuogo(teramo);
       System.out.println(Negozi);
       return service.findAllNegozioByLuogo(teramo);
   }
    /*@GetMapping("/{luogo}")
    public List<Negozio> findByLuogo(@PathVariable String luogo) {
        return service.findAllNegozioByLuogo(luogo);
    }*/

}
