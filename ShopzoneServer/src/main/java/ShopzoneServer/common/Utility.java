package ShopzoneServer.common;

import ShopzoneServer.domain.Utente;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ShopzoneServer.common.spring.security.UserDetailsImpl;

public class Utility {

	public static Utente getUtente() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
			return userDetailsImpl.getUtente();

		} else {
			return null;
		}
		
	}
}
