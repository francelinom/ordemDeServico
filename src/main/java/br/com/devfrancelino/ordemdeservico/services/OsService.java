package br.com.devfrancelino.ordemdeservico.services;

import br.com.devfrancelino.ordemdeservico.domain.Cliente;
import br.com.devfrancelino.ordemdeservico.domain.OS;
import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import br.com.devfrancelino.ordemdeservico.domain.enums.Priodidade;
import br.com.devfrancelino.ordemdeservico.domain.enums.Status;
import br.com.devfrancelino.ordemdeservico.dto.OsDTO;
import br.com.devfrancelino.ordemdeservico.repositories.OSRepository;
import br.com.devfrancelino.ordemdeservico.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsService {

    @Autowired
    private OSRepository osRepository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public OS findById(Integer id) {
        Optional<OS> obj = osRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + OS.class.getName()));
    }

    public List<OS> findAll() {
        return osRepository.findAll();
    }

    public OS create(OsDTO osDTO) {
        return fromDTO(osDTO);
    }

    private OS fromDTO(OsDTO osDTO) {

        Tecnico tecnico = tecnicoService.findById(osDTO.getTecnico());
        Cliente cliente = clienteService.findById(osDTO.getCliente());

        OS newOs = new OS();
        newOs.setId(osDTO.getId());
        newOs.setObservacoes(osDTO.getObservacoes());
        newOs.setPriodidade(Priodidade.toEnum(osDTO.getPrioridade()));
        newOs.setStatus(Status.toEnum(osDTO.getStatus()));
        newOs.setTecnico(tecnico);
        newOs.setCliente(cliente);

        return osRepository.save(newOs);
    }
}
