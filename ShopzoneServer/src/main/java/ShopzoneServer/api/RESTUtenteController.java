package ShopzoneServer.api;

import javax.servlet.http.HttpServletResponse;

import ShopzoneServer.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShopzoneServer.business.ShopzoneServerService;
import ShopzoneServer.common.spring.security.JWTTokenUtil;
import ShopzoneServer.common.spring.security.UserDetailsImpl;

@RestController
@RequestMapping("/api")
public class RESTUtenteController {

	@Value("${jwt.token.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private ShopzoneServerService shopzoneServerService;

	@PostMapping("/login")
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

	@PostMapping("/login/registrazione")
	public UtenteResponse nuovoUtente(@RequestBody RegistrazioneRequest registrazioneRequest, HttpServletResponse response) {
		System.out.println("arrivato");
		Utente nuovoUtente = shopzoneServerService.nuovoUtente(registrazioneRequest);
		System.out.println(nuovoUtente);
		return new UtenteResponse(nuovoUtente);
	}


	/*@PostMapping("/utente/updateprofilo")
	public UtenteResponse updateProfilo(@RequestBody Utente utente) {
		Utente nuovoUtente = shopzoneServerService.updateProfilo(utente);
		return new UtenteResponse(nuovoUtente);
	}
	*/
}
