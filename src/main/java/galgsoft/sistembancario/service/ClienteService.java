package galgsoft.sistembancario.service;

import galgsoft.sistembancario.dto.ClienteDTO;
import galgsoft.sistembancario.entities.Cliente;
import galgsoft.sistembancario.entities.Endereco;
import galgsoft.sistembancario.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private final EnderecoService enderecoService;

    private final ClienteRepository clienteRepository;

    public ClienteService(EnderecoService enderecoService, ClienteRepository repository){
        this.enderecoService = enderecoService;
        this.clienteRepository = repository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(String id) {
        return clienteRepository.findById(UUID.fromString(id))
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public Cliente createCliente(ClienteDTO dto) {
        Cliente newCliente = new Cliente(dto);
        newCliente.setNome(dto.nome());

        Endereco endereco = enderecoService.getEndereco(dto.cep());
        newCliente.setEndereco(endereco);

        return clienteRepository.save(newCliente);
    }

    public Cliente updateCliente(ClienteDTO dto){
        Cliente newCliente = clienteRepository.findById(dto.id())
                .orElseThrow(RuntimeException::new);

        Endereco newEndereco = enderecoService.getEndereco(dto.cep());

        newCliente.setNome(dto.nome());
        newCliente.setEndereco(newEndereco);

        return clienteRepository.save(newCliente);
    }

    public void deleteCliente(String id){
        clienteRepository.deleteById(UUID.fromString(id));
    }
}
