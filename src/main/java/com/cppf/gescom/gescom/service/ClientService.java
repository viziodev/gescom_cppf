package com.cppf.gescom.gescom.service;

import com.cppf.gescom.gescom.data.entity.Client;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientService {
    List<Client> getAllClient();
    Page<Client> getAllClient(int page,int size);
    Client getClientById(Long id);
    Client CreateClient(Client client);
}
