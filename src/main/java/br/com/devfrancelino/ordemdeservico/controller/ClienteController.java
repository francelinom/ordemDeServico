package br.com.devfrancelino.ordemdeservico.controller;

import br.com.devfrancelino.ordemdeservico.domain.Cliente;
import br.com.devfrancelino.ordemdeservico.dto.ClienteDTO;
import br.com.devfrancelino.ordemdeservico.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
