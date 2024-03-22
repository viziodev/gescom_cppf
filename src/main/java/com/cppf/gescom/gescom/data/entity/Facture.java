package com.cppf.gescom.gescom.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Facture extends AbstractEntity{
    LocalDate dateFacture;
    @OneToOne
    private  Commande commande;
    @OneToMany(mappedBy = "facture")
    private List<Payement> payements;
}
