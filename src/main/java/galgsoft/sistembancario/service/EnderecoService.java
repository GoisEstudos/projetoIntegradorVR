package galgsoft.sistembancario.service;

import galgsoft.sistembancario.client.ViaCepApi;
import galgsoft.sistembancario.dto.EnderecoDTO;
import galgsoft.sistembancario.entities.Endereco;
import galgsoft.sistembancario.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;


@Service
public class EnderecoService {

    private final EnderecoRepository repository;
    private final ViaCepApi viaCepApi;

    public EnderecoService(EnderecoRepository repository, ViaCepApi viaCepApi) {
        this.repository = repository;
        this.viaCepApi = viaCepApi;
    }

    public Endereco getEndereco(String cep){
        EnderecoDTO enderecoDTO = viaCepApi.getEnderecoPorCep(cep);
        Endereco endereco = new Endereco();

        endereco.setCep(enderecoDTO.cep());
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setLocalidade(enderecoDTO.localidade());
        endereco.setUf(enderecoDTO.uf());

        return repository.save(endereco);
    }

}
