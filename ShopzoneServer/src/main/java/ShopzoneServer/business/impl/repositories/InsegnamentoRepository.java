package ShopzoneServer.business.impl.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import ShopzoneServer.domain.Insegnamento;

public interface InsegnamentoRepository extends JpaRepository<Insegnamento, Long>{

	List<Insegnamento> findInsegnamentiByDocenteId(Long idDocente, Sort sort);

}
