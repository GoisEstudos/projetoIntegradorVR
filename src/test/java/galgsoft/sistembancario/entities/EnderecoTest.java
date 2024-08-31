package galgsoft.sistembancario.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class EnderecoTest {

    /**
     * Este teste tem como responsabilidade,
     * testar os metodos Getters e setter da entidade Endereco.
     * Verifica se os metodos Getters e setter est o funcionando corretamente,
     * setando e verificando se os valores est o corretos.
     */
    @Test
    @DisplayName("""
            Este teste tem como responsabilidade,
            testar os metodos Getters e setter da entidade Endereco.
            """)
    void testeGetterSetterEndereco() {

        Endereco newEndereco = new Endereco();

        // Teste do metodo setCep e getCep
        String newCep = "13481-447";
        newEndereco.setCep(newCep);
        Assertions.assertEquals(newCep, newEndereco.getCep());

        // Teste do metodo setLocalidade e getLocalidade

        String newLocalidade = "Limeira";
        newEndereco.setLocalidade(newLocalidade);
        Assertions.assertEquals(newLocalidade, newEndereco.getLocalidade());

        // Teste do metodo setLogradouro e getLogradouro

        String newLogradouro = "Rua Sebastião Silveira Franco";
        newEndereco.setLogradouro(newLogradouro);
        Assertions.assertEquals(newLogradouro, newEndereco.getLogradouro());

        // Teste do metodo setUf e getUf

        String newUf = "SP";
        newEndereco.setUf(newUf);
        Assertions.assertEquals(newUf, newEndereco.getUf());
    }

    /**
     * Este teste tem como responsabilidade,
     * testar o construtor vazio.
     * Verifica se os metodos get est o retornando null.
     */
    @Test
    @DisplayName("""
            Este metodo tem como responsabilidade,
            testar o construtor vazio.
            """)
    void testeConstrutorVazioEndereco() {

        Endereco newEndereco = new Endereco();

        // Verifica se os metodos get est o retornando null
        Assertions.assertNull(newEndereco.getCep());
        Assertions.assertNull(newEndereco.getLocalidade());
        Assertions.assertNull(newEndereco.getLogradouro());
        Assertions.assertNull(newEndereco.getUf());
    }

    /**
     * Este metodo tem como responsabilidade,
     * testar o construtor com parametros.
     */
    @Test
    @DisplayName("""
            Este metodo tem como responsabilidade,
            testar o construtor com parametros.
            """)
    void testeConstrutorComParametrosEndereco() {
        // Cria um objeto Endereco com os dados especificados

        String newCep = "13481-447";
        String newLogradouro = "Rua Sebastião Silveira Franco";
        String newLocalidade = "Limeira";
        String newUf = "SP";

        Endereco newEndereco = new Endereco(
                UUID.randomUUID(), newCep,
                newLogradouro, newLocalidade, newUf);

        // Verifica se os dados estao corretos
        Assertions.assertEquals(newCep, newEndereco.getCep());
        Assertions.assertEquals(newLogradouro, newEndereco.getLogradouro());
        Assertions.assertEquals(newLocalidade, newEndereco.getLocalidade());
        Assertions.assertEquals(newUf, newEndereco.getUf());
    }
}
