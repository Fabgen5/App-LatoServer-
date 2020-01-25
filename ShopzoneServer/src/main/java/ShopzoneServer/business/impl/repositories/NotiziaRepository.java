package ShopzoneServer.business.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ShopzoneServer.domain.Notizia;

import java.util.List;

public interface NotiziaRepository extends JpaRepository<Notizia, Long>{

    List<Notizia> findByNegozioId(Long id);

}
