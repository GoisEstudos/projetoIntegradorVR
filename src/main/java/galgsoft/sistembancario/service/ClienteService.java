package galgsoft.sistembancario.service;

import galgsoft.sistembancario.dto.ClienteDTO;
import galgsoft.sistembancario.entities.Cliente;
import galgsoft.sistembancario.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    public Cliente getClienteById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow(RuntimeException::new);
    }

    public Cliente createCliente(ClienteDTO dto) {
        Cliente newCliente = new Cliente(dto);

        return repository.save(newCliente);
    }

}
