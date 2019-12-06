package ShopzoneServer.api;


import ShopzoneServer.domain.Negozio;
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
        System.out.println("negozio arrivato");
        Negozio nuovoNegozio = shopzoneServerService.nuovoNegozio(nuovoNegozioRequest);

        return nuovoNegozio;
    }

}


