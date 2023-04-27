package br.com.devfrancelino.ordemdeservico.controller;

import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import br.com.devfrancelino.ordemdeservico.dto.TecnicoDTO;
import br.com.devfrancelino.ordemdeservico.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById (@PathVariable Integer id) {
        Tecnico obj = tecnicoService.findById(id);
        TecnicoDTO tecnicoDTO = new TecnicoDTO(obj);
        return ResponseEntity.ok().body(tecnicoDTO);
    }
}
