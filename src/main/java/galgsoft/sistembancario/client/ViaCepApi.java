package galgsoft.sistembancario.client;

import galgsoft.sistembancario.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "viacep.com.br/ws/", name = "viaCep")
public interface ViaCepApi {

    @GetMapping("{cep}/json/")
    EnderecoDTO getEnderecoPorCep(@PathVariable String cep);

}
