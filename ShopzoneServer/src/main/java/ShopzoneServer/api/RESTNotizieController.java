package ShopzoneServer.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShopzoneServer.business.ShopzoneServerService;
import ShopzoneServer.domain.Notizia;

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