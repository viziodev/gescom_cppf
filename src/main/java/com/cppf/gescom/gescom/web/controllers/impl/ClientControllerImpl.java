package com.cppf.gescom.gescom.web.controllers.impl;

import com.cppf.gescom.gescom.data.entity.Client;
import com.cppf.gescom.gescom.service.ClientService;
import com.cppf.gescom.gescom.web.controllers.ClientController;
import com.cppf.gescom.gescom.web.dto.RestReponseDto;
import com.cppf.gescom.gescom.web.dto.request.ClientCreateDto;
import com.cppf.gescom.gescom.web.dto.response.ClientListeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200" )
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;
    @Override
    public ResponseEntity<Map<Object, Object>> listerClientPaginate(int page, int size) {
        Page<Client> allClient = clientService.getAllClient(page, size);
        Page<ClientListeDto> pageClientDto = allClient.map(ClientListeDto::toDto);
        Map<Object, Object> response = RestReponseDto.responsePaginate(pageClientDto.getContent(),
                pageClientDto.isLast(),
                pageClientDto.getTotalPages(),
                pageClientDto.getTotalElements(),
                pageClientDto.getNumber(),
                pageClientDto.isFirst(),
                HttpStatus.OK);
           return new ResponseEntity(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerClient() {

        List<ClientListeDto> list = clientService.getAllClient()
                .stream()
                .map(ClientListeDto::toDto).toList();
        Map<Object, Object> response = RestReponseDto.response(list, HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Map<Object, Object>> listerUnClient(Long id) {
        Client client = clientService.getClientById(id);
        Map<Object, Object> response = RestReponseDto.response(ClientListeDto.toDto(client), HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Map<Object, Object>> editClient(Long id, ClientCreateDto client) {
        return null;
    }

    @Override
    public ResponseEntity<Map<Object, Object>> deleteClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Map<Object, Object>> creerClient(ClientCreateDto clientCreateDto) {
        Client entity = clientCreateDto.toEntity();
        Client client = clientService.CreateClient(entity);
        Map<Object, Object> response = RestReponseDto.response(ClientListeDto.toDto(client), HttpStatus.CREATED);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
