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
import ShopzoneServer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
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
		Negozio negozio = negozioRepository.findById(id).get();
		return negozio.getNotizie();
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
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
		return utente;
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
		Negozio nuovo = new Negozio();
		nuovo.setNome(nuovoNegozio.getNome());
		nuovo.setDescrizione(nuovoNegozio.getDescrizione());
		nuovo.setCitta(nuovoNegozio.getCitta());
		nuovo.setVia(nuovoNegozio.getVia());
		nuovo.setImmagineprofilo(Base64.getDecoder().decode(nuovoNegozio.getImmagineprofilo()));
		negozioRepository.save(nuovo);
		utente.setNegozio(nuovo);
		utenteRepository.save(utente);
		return nuovo;
	}

	@Override
	public void modificaNegozio(Negozio negozio) throws BusinessException {
		negozioRepository.save(negozio);
	}

	@Override
	public void eliminaNegozio(long idNegozio, Utente utente) throws BusinessException {
		utente.setNegozio(null);
		utenteRepository.save(utente);
		negozioRepository.deleteById(idNegozio);

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
	public void modificaNotizia(Notizia notizia) throws BusinessException {
		notiziaRepository.save(notizia);
	}

	@Override
	public void eliminaNotizia(long idNotizia, Negozio negozio) throws BusinessException {
		Notizia notizia = notiziaRepository.findById(idNotizia).get();
		negozio.getNotizie().remove(notizia);
		negozioRepository.save(negozio);
		notiziaRepository.deleteById(idNotizia);
	}

	@Override
	public void miPiace(Long idNotizia , int piace, Utente utente) throws BusinessException{
		if (piace == 0) {
			Notizia notizia = notiziaRepository.findById(idNotizia).get();
			System.out.println(notizia.getPiace());
			utente.removeNotiziaPiaciuta(notizia);
			System.out.println(notizia.getPiace());
			utenteRepository.save(utente);
		}
		else{
			Notizia notizia = notiziaRepository.findById(idNotizia).get();
			utente.addNotiziaPiaciuta(notizia);
			utenteRepository.save(utente);
			notiziaRepository.save(notizia);
		}
	}
}
