package ShopzoneServer.common;



import ShopzoneServer.api.NegozioResponse;
import ShopzoneServer.api.NotiziaResponse;
import ShopzoneServer.common.spring.security.UserDetailsImpl;
import ShopzoneServer.domain.Negozio;
import ShopzoneServer.domain.Notizia;
import ShopzoneServer.domain.Utente;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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

	public static List<NotiziaResponse> notiziaResponse(List<Notizia> notizie) {
		List<NotiziaResponse> notizieResponse = new ArrayList<>();
		try{
			Utente utente= Utility.getUtente();
			for (Notizia notizia : notizie) {
				notizieResponse.add(new NotiziaResponse(notizia,utente));
			}
			return notizieResponse;
		}
		catch(Exception e){
			System.out.println(e);

			for (Notizia notizia : notizie) {
				notizieResponse.add(new NotiziaResponse(notizia));
			}
			return notizieResponse;
		}
	}
	public static List<NegozioResponse> negozioResponse(List<Negozio> negozi) {
		List<NegozioResponse>  negozioResponse= new ArrayList<>();
		try {
			Utente utente = Utility.getUtente();
			for (Negozio negozio : negozi) {
				negozioResponse.add(new NegozioResponse(negozio, utente));
			}
			return negozioResponse;
		} catch (Exception e) {
			System.out.println(e);

			for (Negozio negozio : negozi) {
				negozioResponse.add(new NegozioResponse(negozio));
			}
			return negozioResponse;
		}
	}
}
