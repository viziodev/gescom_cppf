package com.cppf.gescom.gescom.data.fixtures;

import com.cppf.gescom.gescom.data.entity.Produit;
import com.cppf.gescom.gescom.data.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Component
public class ProduitFixtures implements CommandLineRunner {
    private final ProduitRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Produit> produitList=new ArrayList<Produit>();
        for (int i = 0; i < 10; i++) {
            produitList.add(
                    Produit.builder()
                    .prix(10000L)
                    .libelle("Produit "+i)
                    .qteStock(1000.0*i)
                    .build()) ;
        }

        productRepository.saveAll(produitList);



    }
}
