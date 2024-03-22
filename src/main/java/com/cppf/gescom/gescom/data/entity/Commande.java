package com.cppf.gescom.gescom.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "commandes")
public class Commande extends AbstractEntity {
    private LocalDate dateCmd;
    @Column(length =25,unique = true)
    private String numero;
    @Transient
    private  Double montant;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "commande")
    private List<DetailCommande> detailCommandes;
    @OneToOne(mappedBy = "commande")
    private  Facture facture;
}
