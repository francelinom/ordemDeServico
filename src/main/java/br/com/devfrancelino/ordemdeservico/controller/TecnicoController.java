package br.com.devfrancelino.ordemdeservico.controller;

import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import br.com.devfrancelino.ordemdeservico.dto.TecnicoDTO;
import br.com.devfrancelino.ordemdeservico.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        Tecnico obj = tecnicoService.findById(id);
        TecnicoDTO tecnicoDTO = new TecnicoDTO(obj);
        return ResponseEntity.ok().body(tecnicoDTO);
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        List<TecnicoDTO> listDTO = tecnicoService.findAll()
                .stream()
                .map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@RequestBody TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = tecnicoService.create(tecnicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
