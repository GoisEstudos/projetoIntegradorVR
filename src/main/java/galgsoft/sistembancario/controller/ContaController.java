package galgsoft.sistembancario.controller;

import galgsoft.sistembancario.dto.ContaDTO;
import galgsoft.sistembancario.entities.Conta;
import galgsoft.sistembancario.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/conta")
@RequiredArgsConstructor
public class ContaController {

    public final ContaService service;

    @GetMapping("/list")
    public ResponseEntity<List<Conta>> getContas(){
        List<Conta> newContas = service.getContas();
        return ResponseEntity.ok(newContas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable String id){
        return ResponseEntity.ok(service.getContaById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Conta> createConta(@RequestBody ContaDTO dto){
        return ResponseEntity.ok(service.createConta(dto));
    }

    @PatchMapping("/update")
    public ResponseEntity<Conta> updateConta(@RequestBody ContaDTO dto){
        return ResponseEntity.ok(service.updateConta(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteConta(@PathVariable String id){
        service.deleteConta(id);
        return ResponseEntity.ok("Conta Deletada Com Sucesso!");
    }

}
