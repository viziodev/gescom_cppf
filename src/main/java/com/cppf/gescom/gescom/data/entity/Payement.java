package com.cppf.gescom.gescom.data.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payement extends AbstractEntity {
    private LocalDate datePayement;
     @ManyToOne
     private Facture facture;
}
