package com.cppf.gescom.gescom.web.controllers.impl;

import com.cppf.gescom.gescom.data.entity.Client;
import com.cppf.gescom.gescom.service.ClientService;
import com.cppf.gescom.gescom.web.controllers.ClientController;
import com.cppf.gescom.gescom.web.dto.request.ClientCreateDto;
import com.cppf.gescom.gescom.web.dto.response.ClientListeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;
    @Override
    public ResponseEntity<List<ClientListeDto>> listerClientPaginate(int page, int size) {
        Page<Client> allClient = clientService.getAllClient(page, size);
        Page<ClientListeDto> pageClientDto = allClient.map(ClientListeDto::toDto);
        return new ResponseEntity(pageClientDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClientListeDto>> listerClient() {

        List<ClientListeDto> list = clientService.getAllClient()
                .stream()
                .map(ClientListeDto::toDto).toList();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ClientListeDto> listerUnClient(Long id) {
        Client client = clientService.getClientById(id);
        return new ResponseEntity(ClientListeDto.toDto(client), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ClientListeDto> editClient(Long id, ClientCreateDto client) {
        return null;
    }

    @Override
    public ResponseEntity<ClientListeDto> deleteClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ClientCreateDto> creerClient(ClientCreateDto clientCreateDto) {
        Client entity = clientCreateDto.toEntity();
        Client client = clientService.CreateClient(entity);
        return new ResponseEntity(ClientListeDto.toDto(client), HttpStatus.CREATED);
    }
}
