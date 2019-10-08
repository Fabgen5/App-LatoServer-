package ShopzoneServer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShopzoneServer.business.ShopzoneServerService;
import ShopzoneServer.common.Utility;
import ShopzoneServer.domain.Appello;
import ShopzoneServer.domain.Insegnamento;
import ShopzoneServer.domain.Utente;

@RestController
@RequestMapping("/api/insegnamenti")
public class RESTInsegnamentiController {

	@Autowired
	private ShopzoneServerService service;
	
	@GetMapping
	public List<Insegnamento> list() {
		Utente utente = Utility.getUtente();
		return service.findAllInsegnamenti(utente);
	}
	
	@GetMapping("/{idInsegnamento}/appelli")
	public List<Appello> list(@PathVariable long idInsegnamento) {
		return service.findAllAppelli(idInsegnamento);
	}
	
	
}
