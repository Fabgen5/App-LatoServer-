package ShopzoneServer.business;

import java.util.List;

import ShopzoneServer.api.*;
import ShopzoneServer.domain.*;
import com.sun.org.apache.xpath.internal.operations.Neg;

public interface ShopzoneServerService {


    Utente findUtenteByUsername(String username) throws BusinessException;

    Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException;

    List<Notizia> findAllNotizie() throws BusinessException;

    List<Notizia> findAllNotizieNegozio(Long id) throws BusinessException;

    Notizia findNotiziaById(Long id) throws BusinessException;

    Negozio findNegozioById(Long id) throws BusinessException;

    List<Negozio> findAllNegozioByLuogo(String luogo) throws BusinessException;

    Notizia nuovaNotizia(NotiziaRequest notizia, Negozio negozio) throws BusinessException;

    void eliminaNotizia(Notizia notizia) throws BusinessException;

    Notizia modificaNotizia(NotiziaRequest notizia, Long notiziaId) throws BusinessException;

    List<Negozio> findAllNegoziPreferiti(Utente utente) throws BusinessException;

    Negozio nuovoNegozio(NegozioRequest nuovoNegozio, Utente utente) throws BusinessException;

    void eliminaNegozio(Negozio negozio, String username) throws BusinessException;

    Negozio modificaNegozio(NegozioRequest negozio, Long negozioId) throws BusinessException;
    //NOTIZIA PIACE

    Notizia miPiace(long idNotizia, long idUtente) throws BusinessException;

    Notizia rimuoviPiace(long idNotizia, long idUtente) throws BusinessException;

    //NEGOZIO A PREFERITI
    Negozio rimuoviPreferito(long idNegozio, long idUtente) throws BusinessException;

    Negozio aggiungiPreferito(long idNegozio, long idUtente) throws BusinessException;
}
