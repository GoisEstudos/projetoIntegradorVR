package galgsoft.sistembancario.service;

import galgsoft.sistembancario.dto.EnderecoDTO;
import galgsoft.sistembancario.entities.Endereco;
import galgsoft.sistembancario.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<Endereco> getEndereco(){
        return repository.findAll();
    }

    public Endereco getEnderecoById(String id){
        return repository.findById(UUID.fromString(id))
                .orElseThrow(RuntimeException::new);
    }

    public Endereco createEndereco(EnderecoDTO dto){
        Endereco newEndereco = new Endereco(dto);

        return repository.save(newEndereco);
    }
}
