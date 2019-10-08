package ShopzoneServer.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ShopzoneServer.domain.Appello;

public interface AppelloRepository extends JpaRepository<Appello, Long>{

	List<Appello> findAppelliByInsegnamentoId(long idInsegnamento);

}
