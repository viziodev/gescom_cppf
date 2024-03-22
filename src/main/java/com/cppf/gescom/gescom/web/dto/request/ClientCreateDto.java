package com.cppf.gescom.gescom.web.dto.request;

import com.cppf.gescom.gescom.data.entity.Adresse;
import com.cppf.gescom.gescom.data.entity.Client;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientCreateDto {
    private String  nom;
    private String  prenom;
    private  String telephone;
    private String quartier;
    private String ville;
    private String numVilla;
    public Client toEntity(){
       return  Client.builder()
                .nom(nom)
                .prenom(prenom)
                .telephone(telephone)
                .adresse(Adresse.builder()
                        .ville(ville)
                        .quartier(quartier)
                        .numVilla(numVilla)
                        .build())
                .build();
    }
}
