package galgsoft.sistembancario.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class EnderecoTest {

    @Test
    @DisplayName("""
            Este teste tem como responsabilidade,
            testar os metodos Getters e setter da entidade Endereco.
            """)
    void testeGetterSetterEndereco() {

        Endereco newEndereco = new Endereco();

        String newCep = "13481-447";
        newEndereco.setCep(newCep);
        Assertions.assertEquals(newCep, newEndereco.getCep());


        String newLocalidade = "Limeira";
        newEndereco.setLocalidade(newLocalidade);
        Assertions.assertEquals(newLocalidade, newEndereco.getLocalidade());


        String newLogradouro = "Rua Sebastião Silveira Franco";
        newEndereco.setLogradouro(newLogradouro);
        Assertions.assertEquals(newLogradouro, newEndereco.getLogradouro());


        String newUf = "SP";
        newEndereco.setUf(newUf);
        Assertions.assertEquals(newUf, newEndereco.getUf());
    }

    @Test
    @DisplayName("""
            Este metodo tem como responsabilidade,
            testar o construtor vazio.
            """)
    void testeConstrutorVazioEndereco() {

        Endereco newEndereco = new Endereco();

        Assertions.assertNull(newEndereco.getCep());
        Assertions.assertNull(newEndereco.getLocalidade());
        Assertions.assertNull(newEndereco.getLogradouro());
        Assertions.assertNull(newEndereco.getUf());
    }

    @Test
    @DisplayName("""
            Este metodo tem como responsabilidade,
            testar o construtor com parametros.
            """)
    void testeConstrutorComParametrosEndereco() {

        String newCep = "13481-447";
        String newLocalidade = "Limeira";
        String newLogradouro = "Rua Sebastião Silveira Franco";
        String newUf = "SP";

        Endereco newEndereco = new Endereco(
                UUID.fromString("82336ce3-811d-4cc2-a83e-0c6fbc7f3f98"), newCep,
                newLocalidade, newLogradouro, newUf);

        Assertions.assertEquals(newCep, newEndereco.getCep());
        Assertions.assertEquals(newLocalidade, newEndereco.getLocalidade());
        Assertions.assertEquals(newLogradouro, newEndereco.getLogradouro());
        Assertions.assertEquals(newUf, newEndereco.getUf());
    }
}
