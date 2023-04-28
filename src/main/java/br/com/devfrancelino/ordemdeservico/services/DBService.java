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
        Cliente c2 = new Cliente(null, "Francelino", "732.494.490-67", "(84) 98888-7711");

        Tecnico t1 = new Tecnico(null, "Técnico Testes 3", "902.198.070-35", "(84) 98888-6633");
        Tecnico t2 = new Tecnico(null, "Técnico Testes 4", "162.045.620-61", "(84) 98888-6600");

        OS os1 = new OS(null, "Testes", Priodidade.ALTA, Status.ANDAMENTO, t1, c1);
        OS os2 = new OS(null, "Testes 2", Priodidade.BAIXA, Status.ABERTO, t2, c2);

        c1.getList().add(os1);
        t1.getList().add(os1);

        c2.getList().add(os2);
        t2.getList().add(os2);

        tecnicoRepository.saveAll(Arrays.asList(t1, t2));
        clienteRepository.saveAll(Arrays.asList(c1, c2));

        osRepository.saveAll(Arrays.asList(os1, os2));
    }
}
