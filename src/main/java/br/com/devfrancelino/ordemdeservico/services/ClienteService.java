package br.com.devfrancelino.ordemdeservico.services;

import br.com.devfrancelino.ordemdeservico.domain.Cliente;
import br.com.devfrancelino.ordemdeservico.domain.Pessoa;
import br.com.devfrancelino.ordemdeservico.dto.ClienteDTO;
import br.com.devfrancelino.ordemdeservico.repositories.ClienteRepository;
import br.com.devfrancelino.ordemdeservico.repositories.PessoaRepository;
import br.com.devfrancelino.ordemdeservico.services.exceptions.DataIntegratyViolationException;
import br.com.devfrancelino.ordemdeservico.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO clienteDTO) {
        if (findCPF(clienteDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        return clienteRepository.save(new Cliente(null, clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getTelefone()));
    }

    private Pessoa findCPF(ClienteDTO clienteDTO) {
        Pessoa pessoa = pessoaRepository.findByCPF(clienteDTO.getCpf());

        if (pessoa != null) {
            return pessoa;
        }

        return null;
    }
}
