package ShopzoneServer.business;

import java.util.List;

import ShopzoneServer.api.NuovanotiziaRequest;
import ShopzoneServer.api.NuovoNegozioRequest;
import ShopzoneServer.api.RegistrazioneRequest;
import ShopzoneServer.domain.*;

public interface ShopzoneServerService {

	Negozio nuovoNegozio(NuovoNegozioRequest nuovoNegozioRequest) throws BusinessException;

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException;

	List<Notizia> findAllNotizie() throws BusinessException;

	Notizia findNotiziaById(Long id) throws BusinessException;

	Negozio findNegozioById(Long id) throws BusinessException;

	List<Negozio> findAllNegozioByLuogo(String luogo) throws BusinessException;

	Notizia nuovaNotizia(NuovanotiziaRequest nuovanotiziaRequest)throws BusinessException;

    List<Notizia> findAllNotiziePreferite(Utente utente)throws BusinessException;
}
