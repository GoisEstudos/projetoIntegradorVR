package galgsoft.sistembancario.service;

import galgsoft.sistembancario.dto.ContaDTO;
import galgsoft.sistembancario.entities.Cliente;
import galgsoft.sistembancario.entities.Conta;
import galgsoft.sistembancario.repositories.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContaService {

    private final ContaRepository repository;

    private final ClienteService service;

    public ContaService(ContaRepository repository, ClienteService service){
        this.repository = repository;
        this.service = service;
    }

    public List<Conta> getContas(){
        return repository.findAll();
    }

    public Conta getContaById(String id){
       return repository.findById(UUID.fromString(id))
               .orElseThrow(RuntimeException::new);
    }

    @Transactional
    public Conta createConta(ContaDTO dto){
        Conta newConta = new Conta(dto);

        newConta.setSaldo(dto.saldo());
        newConta.setNumero(dto.numero());
        newConta.setTipoConta(dto.tipoConta());

        Cliente newCliente = service.getClienteById(dto.idCliente());
        newConta.setCliente(newCliente);

        return repository.save(newConta);
    }

    public Conta updateConta(ContaDTO dto){
        Conta newConta = repository.findById(dto.id())
                .orElseThrow(RuntimeException::new);

        newConta.setNumero(dto.numero());


        return repository.save(newConta);
    }


    public void deleteConta(String id){
        repository.deleteById(UUID.fromString(id));
    }

}
