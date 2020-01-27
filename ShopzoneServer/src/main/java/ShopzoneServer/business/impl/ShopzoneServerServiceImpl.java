package ShopzoneServer.business.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import ShopzoneServer.api.NegozioRequest;
import ShopzoneServer.api.NotiziaRequest;
import ShopzoneServer.api.NotiziaResponse;
import ShopzoneServer.api.RegistrazioneRequest;
import ShopzoneServer.business.impl.repositories.*;
import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.*;
import jdk.management.resource.ResourceRequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShopzoneServer.business.BusinessException;
import ShopzoneServer.business.ShopzoneServerService;

@Service
@Transactional
public class ShopzoneServerServiceImpl implements ShopzoneServerService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private NotiziaRepository notiziaRepository;

	@Autowired
	private NegozioRepository negozioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}
	@Override
	public List<Negozio> findAllNegozioByLuogo(String citta) throws BusinessException {
		return negozioRepository.findByCitta(citta);
	}

	@Override
	public List<Notizia> findAllNotizieNegozio(Long id) throws BusinessException {
		return notiziaRepository.findByNegozioId(id);
	}

	@Override
	public List<Notizia> findAllNotizie() throws BusinessException {
		return notiziaRepository.findAll(JpaSort.unsafe(Direction.DESC, "dataPubblicazione"));
	}




	@Override
	public List<Negozio> findAllNegoziPreferiti(Utente utente) throws BusinessException {
		Set<Negozio> set = utente.getNegoziPreferiti();
		ArrayList<Negozio> negozi = new ArrayList<>(set);
		return negozi;
	}


	@Override
	public Notizia findNotiziaById(Long id) throws BusinessException {
		return notiziaRepository.findById(id).get();
	}
	@Override
	public Negozio findNegozioById(Long id) throws BusinessException {
		return negozioRepository.findById(id).get();
	}


	@Override
	public Utente nuovoUtente(RegistrazioneRequest registrazioneRequest) throws BusinessException{
		Utente nuovo = new Utente();
		nuovo.setNome(registrazioneRequest.getNome());
		nuovo.setCognome(registrazioneRequest.getCognome());
		nuovo.setEmail(registrazioneRequest.getEmail());
		nuovo.setUsername(registrazioneRequest.getUsername());
		nuovo.setPassword((passwordEncoder.encode(registrazioneRequest.getPassword())));
		utenteRepository.save(nuovo);
		return nuovo;
	}

	@Override
	public Negozio nuovoNegozio(NegozioRequest nuovoNegozio, Utente utente) throws BusinessException{
		Negozio nuovo = new Negozio(nuovoNegozio);
		negozioRepository.save(nuovo);
		utente.setNegozio(nuovo);
		utenteRepository.save(utente);
		return nuovo;
	}

	@Override
	public Negozio modificaNegozio(NegozioRequest negozioModificato, Long negozioId) throws BusinessException {
		System.out.println("amleto=" + negozioId);
		Negozio negozio = new Negozio();
		negozio.setId(negozioId);
		negozio.setNome(negozioModificato.getNome());
		negozio.setDescrizione(negozioModificato.getDescrizione());
		negozio.setCitta(negozioModificato.getCitta());
		negozio.setVia(negozioModificato.getVia());
		negozio.setImmagineprofilo(Base64.getDecoder().decode(negozioModificato.getImmagineprofilo()));
		Negozio result =  negozioRepository.save(negozio);
		System.out.println("strunz=" + result.getId());
		return result;

	}

	@Override
	public void eliminaNegozio(long idNegozio, String username) throws BusinessException {
		Utente u = utenteRepository.findByUsername(username);
		u.setNegozio(null);
		Negozio negozio = negozioRepository.findById(idNegozio).get();
		negozioRepository.delete(negozio);
	}


	@Override
	public Notizia nuovaNotizia(NotiziaRequest notizia, Negozio negozio)throws BusinessException{
		Notizia nuova = new Notizia();
		nuova.setDataPubblicazione(Timestamp.valueOf(LocalDateTime.now()));
		nuova.setNegozio(negozio);
		nuova.setImmagine(Base64.getDecoder().decode(notizia.getImmagine()));
		nuova.setTitolo(notizia.getTitolo());
		nuova.setDescrizione(notizia.getDescrizione());
		notiziaRepository.save(nuova);
		return nuova;
	}

	@Override
	public Notizia modificaNotizia(NotiziaRequest notiziaModificata, Long notiziaId) throws BusinessException {
		Notizia notizia = notiziaRepository.findById(notiziaId).get();
		notizia.setTitolo(notiziaModificata.getTitolo());
		notizia.setDescrizione(notiziaModificata.getDescrizione());
		notizia.setImmagine(Base64.getDecoder().decode(notiziaModificata.getImmagine()));

		return notizia;
	}

	@Override
	public void eliminaNotizia(long idNotizia) throws BusinessException {
		notiziaRepository.deleteById(idNotizia);
	}

	@Override
	public Notizia miPiace(long idNotizia, long idUtente){
		Utente utente = utenteRepository.findById(idUtente).get();
		Notizia notizia = notiziaRepository.findById(idNotizia).get();
		utente.getNotiziePiaciute().add(notizia);
		return notizia;

	}

	@Override
	public Notizia rimuoviPiace(long idNotizia, long idUtente){
		Utente utente = utenteRepository.findById(idUtente).get();
		Notizia notizia = notiziaRepository.findById(idNotizia).get();
		utente.getNotiziePiaciute().remove(notizia);
		return notizia;

	}

	@Override
	public Negozio rimuoviPreferito(long idNegozio, long idUtente) throws BusinessException {
		Utente utente = utenteRepository.findById(idUtente).get();
		Negozio negozio = negozioRepository.findById(idNegozio).get();
		negozio.getPreferiti().remove(utente);
		return negozio;
	}

	@Override
	public Negozio aggiungiPreferito(long idNegozio, long idUtente) throws BusinessException {
		Utente utente = utenteRepository.findById(idUtente).get();
		Negozio negozio = negozioRepository.findById(idNegozio).get();
		negozio.getPreferiti().add(utente);
		return negozio;
	}
}
