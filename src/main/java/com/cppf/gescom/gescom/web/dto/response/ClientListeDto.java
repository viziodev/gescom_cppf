package com.cppf.gescom.gescom.web.dto.response;

import com.cppf.gescom.gescom.data.entity.Client;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientListeDto {
    private Long id;
    private String  nomComplet;
    private String  addresse;

    public static ClientListeDto toDto(Client client) {
        return ClientListeDto
                .builder()
                .id(client.getId())
                .nomComplet(client.getPrenom() + " " + client.getNom())
                .addresse(client.getAdresse().getNumVilla()+ "/" +client.getAdresse().getQuartier())
                .build();
      }
   }
