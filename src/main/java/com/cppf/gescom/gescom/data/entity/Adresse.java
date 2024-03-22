package com.cppf.gescom.gescom.data.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Adresse {
    private String quartier;
    private String ville;
    private String numVilla;

}
