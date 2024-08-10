package galgsoft.sistembancario.repositories;

import galgsoft.sistembancario.entities.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, UUID> {
}
