package ShopzoneServer.business;

import java.util.List;

import ShopzoneServer.api.RegistrazioneRequest;
import ShopzoneServer.domain.*;
import com.sun.org.apache.xpath.internal.operations.Neg;

public interface ShopzoneServerService {



	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException;

	List<Notizia> findAllNotizie() throws BusinessException;

	Notizia findNotiziaById(Long id) throws BusinessException;

	Negozio findNegozioById(Long id) throws BusinessException;

	List<Negozio> findAllNegozioByLuogo(String luogo) throws BusinessException;

	Notizia nuovaNotizia(Notizia notizia, Negozio negozio)throws BusinessException;

    List<Negozio> findAllNegoziPreferiti(Utente utente)throws BusinessException;

	Negozio nuovoNegozio(Negozio nuovoNegozio, Utente utente) throws BusinessException;

	void eliminaNegozio(long idNegozio , Utente utente) throws BusinessException;

	void modificaNegozio(Negozio negozio)throws BusinessException;

	void eliminaNotizia(long idNotizia, Negozio negozio) throws BusinessException;

	void modificaNotizia(Notizia notizia)throws BusinessException;
}
