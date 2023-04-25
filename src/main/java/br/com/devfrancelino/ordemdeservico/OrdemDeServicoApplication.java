package br.com.devfrancelino.ordemdeservico;

import br.com.devfrancelino.ordemdeservico.domain.Cliente;
import br.com.devfrancelino.ordemdeservico.domain.OS;
import br.com.devfrancelino.ordemdeservico.domain.Tecnico;
import br.com.devfrancelino.ordemdeservico.domain.enums.Priodidade;
import br.com.devfrancelino.ordemdeservico.domain.enums.Status;
import br.com.devfrancelino.ordemdeservico.repositories.ClienteRepository;
import br.com.devfrancelino.ordemdeservico.repositories.OSRepository;
import br.com.devfrancelino.ordemdeservico.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OrdemDeServicoApplication implements CommandLineRunner {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OSRepository osRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrdemDeServicoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente(null, "Francelino Marcilio", "929.596.340-71", "(84) 98888-7755");
        Tecnico t1 = new Tecnico(null, "Técnico Testes 2", "564.156.830-98", "(84) 98888-6644");
        OS os1 = new OS(null, "Testes", Priodidade.ALTA, Status.ANDAMENTO, t1, c1);

        c1.getList().add(os1);
        t1.getList().add(os1);

        tecnicoRepository.saveAll(Arrays.asList(t1));
        clienteRepository.saveAll(Arrays.asList(c1));

        osRepository.saveAll(Arrays.asList(os1));
    }
}
