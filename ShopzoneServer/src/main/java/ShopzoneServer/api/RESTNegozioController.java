package ShopzoneServer.api;


import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import ShopzoneServer.business.ShopzoneServerService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/negozio")
public class RESTNegozioController {

    @Autowired
    private ShopzoneServerService shopzoneServerService;

    @GetMapping("/{id}")
    public Negozio findById(@PathVariable Long id) {
        return shopzoneServerService.findNegozioById(id);
    }

    @PostMapping("/nuovo")
    public Negozio nuovoNegozio(@RequestBody NuovoNegozioRequest nuovoNegozioRequest, HttpServletResponse response) {
        Utente utente= Utility.getUtente();
        System.out.println(utente);

        Negozio nuovoNegozio = shopzoneServerService.nuovoNegozio(nuovoNegozioRequest);

        return nuovoNegozio;
    }

}


