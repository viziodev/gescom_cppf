package com.cppf.gescom.gescom.service.impl;

import com.cppf.gescom.gescom.data.entity.Client;
import com.cppf.gescom.gescom.data.repository.ClientRepository;
import com.cppf.gescom.gescom.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private  final ClientRepository clientRepository;
    @Override
    public List<Client> getAllClient() {
        return clientRepository.findClientByActive(true);
    }

    @Override
    public Page<Client> getAllClient(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return clientRepository.findClientByActive(pageable,true);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client CreateClient(Client client) {
          clientRepository.save(client);
          return client;
    }
}
