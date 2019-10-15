package ShopzoneServer.api;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import ShopzoneServer.domain.Negozio;
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
/*
    @PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
    public void addMember(@RequestBody Member member) {
        //code
    }*/

    @PostMapping
    public List<Negozio>  findByLuogo(@RequestBody SearchRequest searchRequest, HttpServletResponse response) {
        System.out.println("SONO QUI");
        System.out.println();
        ArrayList<Negozio> Negozi = (ArrayList<Negozio>) service.findAllNegozioByLuogo(searchRequest.getSearchinput());
        System.out.println(Negozi);
        return service.findAllNegozioByLuogo(searchRequest.getSearchinput());
    }

    @GetMapping("/{id}")
    public NotiziaResponse findById(@PathVariable Long id) {
        return new NotiziaResponse(service.findNotiziaById(id));
    }


   /* public Notizia findById(@PathVariable Long id) {
        return service.findNotiziaById(id);
    }*/

}
/*@PostMapping("/login")
	public UtenteResponse login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {
		// Effettuo l'autenticazione
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Genero Token e lo inserisco nell'header di risposta
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtTokenUtil.generateToken(userDetails);
		response.setHeader(tokenHeader, token);

		// Ritorno l'utente
		return new UtenteResponse(((UserDetailsImpl) userDetails).getUtente());
	}

	@PostMapping("/utente/updateprofilo")
	public UtenteResponse updateProfilo(@RequestBody Utente utente) {
		Utente nuovoUtente = myUnivaqService.updateProfilo(utente);
		return new UtenteResponse(nuovoUtente);
	}
	*/