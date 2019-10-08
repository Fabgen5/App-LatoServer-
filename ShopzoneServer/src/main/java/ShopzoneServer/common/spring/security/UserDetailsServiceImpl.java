package ShopzoneServer.common.spring.security;

import ShopzoneServer.business.ShopzoneServerService;
import ShopzoneServer.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ShopzoneServerService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utente utente = service.findUtenteByUsername(username);
		if (utente == null) {
			throw new UsernameNotFoundException("utente inesistente");
		}
		return new UserDetailsImpl(utente);

	}

}
