package galgsoft.sistembancario.controller;

import galgsoft.sistembancario.dto.EnderecoDTO;
import galgsoft.sistembancario.entities.Endereco;
import galgsoft.sistembancario.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> getEndereco(){
        List<Endereco> newEndereco = service.getEndereco();
        return ResponseEntity.ok(newEndereco);
    }

    @GetMapping("{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable String id){
        return ResponseEntity.ok(service.getEnderecoById(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody EnderecoDTO dto){
        Endereco newEndereco = service.createEndereco(dto);
        return ResponseEntity.ok(newEndereco);
    }
}
