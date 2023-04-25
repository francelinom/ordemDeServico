package br.com.devfrancelino.ordemdeservico.repositories;

import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
