package galgsoft.sistembancario.repositories;

import galgsoft.sistembancario.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
    Optional<Endereco> findByCepIgnoreCase(String cep);
}
