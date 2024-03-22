package com.cppf.gescom.gescom.data.fixtures;

import com.cppf.gescom.gescom.data.entity.Adresse;
import com.cppf.gescom.gescom.data.entity.Client;
import com.cppf.gescom.gescom.data.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClientFixtures implements CommandLineRunner {
    private  final ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
         Client client=   Client.builder()
                    .nom("Nom "+i)
                    .prenom("Prenom "+i)
                    .telephone("77 100 10 1"+i)
                    .adresse(Adresse.builder()
                            .ville("Ville "+i)
                            .quartier("quartier "+i)
                            .numVilla("NumVilla"+i)
                            .build())
                    .build();
         client.setActive(i%2 == 0);
         clientRepository.save(client);
        }
    }
}
