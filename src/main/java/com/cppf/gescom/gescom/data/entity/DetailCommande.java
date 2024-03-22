package com.cppf.gescom.gescom.data.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DetailCommande extends AbstractEntity {
    private Double prix;
    private Double qteComd;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Commande commande;
}
