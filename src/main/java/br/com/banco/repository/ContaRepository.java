package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.dto.ContaDTO;
import br.com.banco.entity.ContaEntity;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Long>{
	
	@Query(value = "SELECT new br.com.banco.dto.ContaDTO(c.id, c.nomeResponsavel) FROM conta c WHERE c.nomeResponsavel LIKE CONCAT('%',:nomeResponsavel,'%')")
	List<ContaDTO> searchByName(@Param("nomeResponsavel") String nomeResponsavel);
}
