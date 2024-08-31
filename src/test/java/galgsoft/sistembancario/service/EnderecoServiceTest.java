package galgsoft.sistembancario.service;

import galgsoft.sistembancario.client.ViaCepApi;
import galgsoft.sistembancario.dto.EnderecoDTO;
import galgsoft.sistembancario.entities.Endereco;
import galgsoft.sistembancario.repositories.EnderecoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

class EnderecoServiceTest {

    private final EnderecoRepository repository = Mockito.mock(EnderecoRepository.class);
    private final ViaCepApi viaCepApi = Mockito.mock(ViaCepApi.class);

    private final EnderecoService service = new EnderecoService(repository, viaCepApi);

    /**
     * Teste para o metodo getEndereco da classe EnderecoService.
     * Verifica se o metodo esta retornando os dados corretos da API ViaCep.
     */
    @Test
    @DisplayName("""
            Dado com o parametro CEP
            Quando consultado a api ViaCep
            Deve ser retornado CEP, LOGRADOURO, LOCALIDADE E UF do CEP especifico.
            """)
    void testeGetEnderecoViaCep(){
        // Cria um objeto EnderecoDTO com os dados do CEP
        EnderecoDTO newEnderecoDTO = new EnderecoDTO("13481-447", "Rua Sebastião Silveira Franco",
                "Limeira", "SP");

        // Simula o retorno da API ViaCep
        Mockito.when(viaCepApi.getEnderecoPorCep(newEnderecoDTO.cep())).thenReturn(newEnderecoDTO);

        // Simula o retorno do metodo save do repository
        Mockito.when(repository.save(Mockito.any())).thenReturn(new Endereco(UUID.randomUUID(),newEnderecoDTO.cep(), newEnderecoDTO.logradouro(), newEnderecoDTO.localidade(),  newEnderecoDTO.uf()));

        // Chama o metodo getEndereco da classe EnderecoService
        Endereco newEndereco = service.getEndereco(newEnderecoDTO.cep());

        // Verifica se os dados estao corretos
        Assertions.assertNotNull(newEnderecoDTO);
        Assertions.assertEquals(newEnderecoDTO.cep(), newEndereco.getCep());
        Assertions.assertEquals(newEnderecoDTO.logradouro(), newEndereco.getLogradouro());
        Assertions.assertEquals(newEnderecoDTO.localidade(), newEndereco.getLocalidade());
        Assertions.assertEquals(newEnderecoDTO.uf(), newEndereco.getUf());
    }

    /**
     * Teste para o metodo cepIgual da classe EnderecoService.
     * Verifica se o metodo esta retornando os dados corretos da API ViaCep,
     * quando o CEP ja existe no banco de dados.
     */
    @Test
    @DisplayName("""
            Dado com o parametro CEP
            Quando consultado a api ViaCep
            Deve ser retornado que o cep ja existe.
            """)
    void testeCepIgual(){
        // Cria um objeto EnderecoDTO com os dados do CEP
        EnderecoDTO newEnderecoDTO = new EnderecoDTO("13481-447", "Rua Sebastião Silveira Franco",
                "Limeira", "SP");

        // Simula o retorno do metodo save do repository
        Mockito.when(repository.findByCepIgnoreCase(newEnderecoDTO.cep())).thenReturn(Optional.of(new Endereco(UUID.randomUUID(),newEnderecoDTO.cep(), newEnderecoDTO.logradouro(), newEnderecoDTO.localidade(),  newEnderecoDTO.uf())));

        Assertions.assertEquals(newEnderecoDTO.cep(), service.cepIgual(newEnderecoDTO.cep()).getCep());
    }

    /**
     * Teste para o metodo cepIgual da classe EnderecoService.
     * Verifica se o metodo esta retornando os dados corretos da API ViaCep,
     * quando o CEP nao existe no banco de dados.
     */
    @Test
    @DisplayName("""
            Dado com o parametro CEP
            Quando consultado a api ViaCep
            Deve ser retornado que o cep nao existe
            e ser salvo no banco de dados.
            """)
    void testeCepNaoIgual()      {
        // Cria um objeto EnderecoDTO com os dados do CEP
        EnderecoDTO newEnderecoDTO = new EnderecoDTO("13481-447", "Rua Sebastião Silveira Franco",
                "Limeira", "SP");

        // Simula o retorno da API ViaCep
        Mockito.when(viaCepApi.getEnderecoPorCep(newEnderecoDTO.cep())).thenReturn(newEnderecoDTO);

        // Simula o retorno do metodo save do repository
        Mockito.when(repository.findByCepIgnoreCase(newEnderecoDTO.cep())).thenReturn(Optional.of(new Endereco(UUID.randomUUID(), "13487-264", newEnderecoDTO.logradouro(), newEnderecoDTO.localidade(),  newEnderecoDTO.uf())));

        // Simula o retorno do metodo save do repository
        Mockito.when(repository.save(Mockito.any())).thenReturn(new Endereco(UUID.randomUUID(),newEnderecoDTO.cep(), newEnderecoDTO.logradouro(), newEnderecoDTO.localidade(),  newEnderecoDTO.uf()));

        // Verifica se os dados estao corretos
        Assertions.assertNotEquals(newEnderecoDTO.cep(), service.cepIgual(newEnderecoDTO.cep()).getCep());
    }
}
