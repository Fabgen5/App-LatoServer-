package ShopzoneServer.business;

import java.util.List;

import ShopzoneServer.api.RegistrazioneRequest;
import ShopzoneServer.domain.*;

public interface ShopzoneServerService {



	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException;

	List<Notizia> findAllNotizie() throws BusinessException;

	Notizia findNotiziaById(Long id) throws BusinessException;

	Negozio findNegozioById(Long id) throws BusinessException;

	List<Negozio> findAllNegozioByLuogo(String luogo) throws BusinessException;

}
