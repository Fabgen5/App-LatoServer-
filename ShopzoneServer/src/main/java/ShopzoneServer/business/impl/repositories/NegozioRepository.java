package ShopzoneServer.business.impl.repositories;

import ShopzoneServer.domain.Negozio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NegozioRepository extends JpaRepository<Negozio, Long> {

    List<Negozio> findByCitta(String luogo);
}
