package ShopzoneServer.business.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	public Negozio nuovoNegozio(Negozio nuovoNegozio, Utente utente) throws BusinessException{
		utente.setNegozio(nuovoNegozio);
		negozioRepository.save(nuovoNegozio);
		utenteRepository.save(utente);
		return nuovoNegozio;
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
	public Notizia nuovaNotizia(Notizia notizia, Negozio negozio)throws BusinessException{
		notizia.setDataPubblicazione(Timestamp.valueOf(LocalDateTime.now()));
		notizia.setNegozio(negozio);
		notiziaRepository.save(notizia);
		return notizia;
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
}
