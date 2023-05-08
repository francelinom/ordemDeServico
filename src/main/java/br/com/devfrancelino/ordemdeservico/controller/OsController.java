package br.com.devfrancelino.ordemdeservico.controller;

import br.com.devfrancelino.ordemdeservico.dto.OsDTO;
import br.com.devfrancelino.ordemdeservico.services.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/os")
public class OsController {

    @Autowired
    private OsService osService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OsDTO> findById(@PathVariable Integer id) {
        OsDTO osDTO = new OsDTO(osService.findById(id));
        return ResponseEntity.ok().body(osDTO);
    }

    @GetMapping
    public ResponseEntity<List<OsDTO>> findAll() {
        List<OsDTO> osDTOList = osService.findAll().stream().map(obj -> new OsDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(osDTOList);
    }

}
