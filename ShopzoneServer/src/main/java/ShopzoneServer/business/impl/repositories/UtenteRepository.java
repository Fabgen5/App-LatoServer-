package ShopzoneServer.business.impl.repositories;

import ShopzoneServer.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);
}
