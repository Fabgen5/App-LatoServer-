package ShopzoneServer.business.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import ShopzoneServer.api.NuovanotiziaRequest;
import ShopzoneServer.api.NuovoNegozioRequest;
import ShopzoneServer.api.RegistrazioneRequest;
import ShopzoneServer.business.impl.repositories.*;
import ShopzoneServer.common.Utility;
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
	public List<Negozio> findAllNegozioByLuogo(String luogo) throws BusinessException {
		return negozioRepository.findByCitta(luogo);
	}

	@Override
	public List<Notizia> findAllNotizie() throws BusinessException {
		return notiziaRepository.findAll(JpaSort.unsafe(Direction.DESC, "dataPubblicazione"));
	}

	@Override
	public List<Notizia> findAllNotiziePreferite(Utente utente) throws BusinessException {

		return (List<Notizia>) utente.getNotiziepreferite();
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
	public Negozio nuovoNegozio(NuovoNegozioRequest nuovoNegozioRequest) throws BusinessException{
		Negozio nuovo = new Negozio();
		nuovo.setNome(nuovoNegozioRequest.getNome());
		nuovo.setDescrizione(nuovoNegozioRequest.getDescrizione());
		nuovo.setImmagineprofilo(nuovoNegozioRequest.getImmagine());
		//nuovo.setCitta(nuovoNegozioRequest.getCitta());
		//nuovo.setVia(nuovoNegozioRequest.setVia());

		negozioRepository.save(nuovo);
		return nuovo;
	}

	@Override
	public Notizia nuovaNotizia(NuovanotiziaRequest nuovanotiziaRequest)throws BusinessException{
		Notizia nuova = new Notizia();
		nuova.setTitolo(nuovanotiziaRequest.getTitolo());
		nuova.setDescrizione(nuovanotiziaRequest.getDescrizione());
		nuova.setDataPubblicazione(Timestamp.valueOf(LocalDateTime.now()));
		nuova.setImmagine("image1.jpg");
		//nuova.setPubblicatoDa(nuovanotiziaRequest.getId_negozio());
		notiziaRepository.save(nuova);
		return nuova;
	}



}
