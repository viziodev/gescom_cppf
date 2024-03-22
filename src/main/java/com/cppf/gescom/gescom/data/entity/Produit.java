package com.cppf.gescom.gescom.data.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produit  extends AbstractEntity{
    private String libelle;
    private Long prix;
    private Double qteStock;
    @OneToMany(mappedBy = "produit")
    private List<DetailCommande> detailCommandes;

}
