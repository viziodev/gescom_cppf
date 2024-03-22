package com.cppf.gescom.gescom.data.repository;

import com.cppf.gescom.gescom.data.entity.Client;
import com.cppf.gescom.gescom.data.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
