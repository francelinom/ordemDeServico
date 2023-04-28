package br.com.devfrancelino.ordemdeservico.services;

import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import br.com.devfrancelino.ordemdeservico.dto.TecnicoDTO;
import br.com.devfrancelino.ordemdeservico.repositories.TecnicoRepository;
import br.com.devfrancelino.ordemdeservico.services.exceptions.DataIntegratyViolationException;
import br.com.devfrancelino.ordemdeservico.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = tecnicoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo: " + Tecnico.class.getName()));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO tecnicoDTO) {
        if (findByCPF(tecnicoDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        return tecnicoRepository.save(
                new Tecnico(null, tecnicoDTO.getNome(), tecnicoDTO.getCpf(), tecnicoDTO.getTelefone()));
    }

    private Tecnico findByCPF(TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = tecnicoRepository.findByCPF(tecnicoDTO.getCpf());

        if (tecnico != null) {
            return tecnico;
        }

        return null;
    }
}
