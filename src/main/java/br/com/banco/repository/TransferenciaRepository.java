package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.entity.TransfereciaEntity;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransfereciaEntity, Long>{
	@Query(value = "SELECT t FROM br.com.banco.dto.TransferenciaDTO t "
			+ "INNER JOIN t.contaEntity c "
			+ "WHERE t.id_conta = 1")
	List<TransferenciaDTO> searchTransferOfAccountByName(@Param("nomeResponsavel") String nomeResponsavel);
	//+ "WHERE c.nomeResponsavel LIKE CONCAT('%',:nomeResponsavel,'%')")
}
