package galgsoft.sistembancario.controller;

import galgsoft.sistembancario.dto.ClienteDTO;
import galgsoft.sistembancario.entities.Cliente;
import galgsoft.sistembancario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        List<Cliente> newClientes = service.getClientes();
        return ResponseEntity.ok(newClientes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable String id){
        return ResponseEntity.ok(service.getClienteById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDTO dto){
        return ResponseEntity.ok(service.createCliente(dto));
    }

    @PatchMapping
    public ResponseEntity<Cliente> updateCliente(@RequestBody ClienteDTO dto){
        return ResponseEntity.ok(service.updateCliente(dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable String id){
        service.deleteCliente(id);
        return ResponseEntity.ok("Cliente Deletado Com Sucesso!");
    }
}
