package br.com.devfrancelino.ordemdeservico.services;

import br.com.devfrancelino.ordemdeservico.domain.Cliente;
import br.com.devfrancelino.ordemdeservico.domain.OS;
import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import br.com.devfrancelino.ordemdeservico.domain.enums.Priodidade;
import br.com.devfrancelino.ordemdeservico.domain.enums.Status;
import br.com.devfrancelino.ordemdeservico.repositories.ClienteRepository;
import br.com.devfrancelino.ordemdeservico.repositories.OSRepository;
import br.com.devfrancelino.ordemdeservico.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OSRepository osRepository;

    public void instanciaDB() {
        Cliente c1 = new Cliente(null, "Fran", "929.596.340-71", "(84) 98888-7722");
        Tecnico t1 = new Tecnico(null, "Técnico Testes 3", "564.156.830-98", "(84) 98888-6633");
        OS os1 = new OS(null, "Testes", Priodidade.ALTA, Status.ANDAMENTO, t1, c1);

        c1.getList().add(os1);
        t1.getList().add(os1);

        tecnicoRepository.saveAll(Arrays.asList(t1));
        clienteRepository.saveAll(Arrays.asList(c1));

        osRepository.saveAll(Arrays.asList(os1));
    }
}
