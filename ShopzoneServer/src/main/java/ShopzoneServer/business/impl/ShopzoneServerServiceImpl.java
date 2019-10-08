package ShopzoneServer.business.impl;

import java.util.List;

import ShopzoneServer.business.impl.repositories.*;
import ShopzoneServer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
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


	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}

	@Override
	public List<Notizia> findAllNotizie() throws BusinessException {
		return notiziaRepository.findAll(JpaSort.unsafe(Direction.DESC, "dataPubblicazione"));
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



}
