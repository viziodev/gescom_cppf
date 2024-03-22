package com.cppf.gescom.gescom.data.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client extends AbstractEntity{
    @Column(length =25)
    private String  nom;
    @Column(length =25)
    private String  prenom;
    @Column(length =25,unique = true)
    private  String telephone;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

}
