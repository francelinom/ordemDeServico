package br.com.devfrancelino.ordemdeservico.controller;

import br.com.devfrancelino.ordemdeservico.domain.Cliente;
import br.com.devfrancelino.ordemdeservico.dto.ClienteDTO;
import br.com.devfrancelino.ordemdeservico.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return ResponseEntity.ok().body(clienteDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> clienteDTOList = clienteService.findAll()
                .stream()
                .map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(clienteDTOList);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.create(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO newClienteDTO = new ClienteDTO(clienteService.update(id, clienteDTO));

        return ResponseEntity.ok().body(newClienteDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
