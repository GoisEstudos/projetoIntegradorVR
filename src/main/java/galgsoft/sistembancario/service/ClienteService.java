package galgsoft.sistembancario.service;

import galgsoft.sistembancario.dto.ClienteDTO;
import galgsoft.sistembancario.entities.Cliente;
import galgsoft.sistembancario.entities.Endereco;
import galgsoft.sistembancario.repositories.ClienteRepository;
import galgsoft.sistembancario.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private final EnderecoRepository enderecoRepository;

    private final ClienteRepository repository;

    public ClienteService(EnderecoRepository enderecoRepository, ClienteRepository repository){
        this.enderecoRepository = enderecoRepository;
        this.repository = repository;
    }

    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    public Cliente getClienteById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public Cliente createCliente(ClienteDTO dto) {
        Cliente newCliente = new Cliente(dto);

        Endereco endereco = enderecoRepository.findById(dto.idEndereco())
                .orElseThrow(RuntimeException::new);

        newCliente.setEndereco(endereco);

        return repository.save(newCliente);
    }

    public Cliente updateCliente(ClienteDTO dto){
        Cliente newCliente = repository.findById(dto.id())
                .orElseThrow(RuntimeException::new);

        Endereco newEndereco = enderecoRepository.findById(dto.idEndereco())
                        .orElseThrow(RuntimeException::new);

        newCliente.setNome(dto.nome());
        newCliente.setEndereco(newEndereco);

        return repository.save(newCliente);
    }

    public void deleteCliente(String id){
        repository.deleteById(UUID.fromString(id));
    }

}
