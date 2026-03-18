package com.example.demo.Repositorie;

import com.example.demo.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepos extends JpaRepository<Produit,Long> {
    Optional<Produit>findProduitById(Long id);

    void deleteById(Long id);
}
