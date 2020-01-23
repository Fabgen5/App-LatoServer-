package ShopzoneServer.business;

import java.util.List;

import ShopzoneServer.api.NegozioRequest;
import ShopzoneServer.api.NotiziaRequest;
import ShopzoneServer.api.NotiziaResponse;
import ShopzoneServer.api.RegistrazioneRequest;
import ShopzoneServer.domain.*;
import com.sun.org.apache.xpath.internal.operations.Neg;

public interface ShopzoneServerService {


    Utente findUtenteByUsername(String username) throws BusinessException;

    Utente updateProfilo(Utente utente) throws BusinessException;

    Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException;

    List<Notizia> findAllNotizie() throws BusinessException;

    List<Notizia> findAllNotizieNegozio(Long id) throws BusinessException;

    Notizia findNotiziaById(Long id) throws BusinessException;

    Negozio findNegozioById(Long id) throws BusinessException;

    List<Negozio> findAllNegozioByLuogo(String luogo) throws BusinessException;

    Notizia nuovaNotizia(NotiziaRequest notizia, Negozio negozio) throws BusinessException;

    List<Negozio> findAllNegoziPreferiti(Utente utente) throws BusinessException;

    Negozio nuovoNegozio(NegozioRequest nuovoNegozio, Utente utente) throws BusinessException;

    void eliminaNegozio(long idNegozio, Utente utente) throws BusinessException;

    void modificaNegozio(Negozio negozio) throws BusinessException;

    void eliminaNotizia(long idNotizia, Negozio negozio) throws BusinessException;

    void modificaNotizia(Notizia notizia) throws BusinessException;

    void miPiace(Long idNotizia, int Piace, Utente utente) throws BusinessException;
}
