package com.cppf.gescom.gescom.data.repository;

import com.cppf.gescom.gescom.data.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findClientByActive(boolean active);
    Page<Client> findClientByActive(Pageable pageable,boolean active);
}
