package galgsoft.sistembancario.service;

import galgsoft.sistembancario.client.ViaCepApi;
import galgsoft.sistembancario.dto.EnderecoDTO;
import galgsoft.sistembancario.entities.Endereco;
import galgsoft.sistembancario.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;
    private final ViaCepApi viaCepApi;

    public EnderecoService(EnderecoRepository repository, ViaCepApi viaCepApi) {
        this.repository = repository;
        this.viaCepApi = viaCepApi;
    }

    public Endereco getEndereco(String cep){
        EnderecoDTO newEnderecoDTO = viaCepApi.getEnderecoPorCep(cep);
        Endereco newEndereco = new Endereco();

        newEndereco.setCep(newEnderecoDTO.cep());
        newEndereco.setLogradouro(newEnderecoDTO.logradouro());
        newEndereco.setLocalidade(newEnderecoDTO.localidade());
        newEndereco.setUf(newEnderecoDTO.uf());

        return repository.save(newEndereco);
    }

    public Endereco cepIgual(String cep){
        Optional<Endereco> enderecoExiste = repository.findByCepIgnoreCase(cep);

        return enderecoExiste.orElseGet(() -> getEndereco(cep));
    }

}
