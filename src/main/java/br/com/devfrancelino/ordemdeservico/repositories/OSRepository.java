package br.com.devfrancelino.ordemdeservico.repositories;

import br.com.devfrancelino.ordemdeservico.domain.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer> {
}
