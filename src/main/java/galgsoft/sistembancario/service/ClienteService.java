package galgsoft.sistembancario.service;

import galgsoft.sistembancario.dto.ClienteDTO;
import galgsoft.sistembancario.entities.Cliente;
import galgsoft.sistembancario.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public List<Cliente> getClientes(){
       return repository.findAll();
    }

    public Cliente getClienteById(String id){
       return repository.findById(Long.valueOf(id))
               .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));
    }

    @Transactional
    public Cliente createCliente(ClienteDTO dto){
        Cliente newCliente = new Cliente(dto);

        return repository.save(newCliente);
    }

}
