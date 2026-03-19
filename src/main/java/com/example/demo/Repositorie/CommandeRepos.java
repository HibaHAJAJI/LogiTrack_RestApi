package com.example.demo.Repositorie;

import com.example.demo.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeRepos extends JpaRepository<Commande,Long> {
    Optional<Commande>findCommandeById(Long id);

    List<Commande> findCommandeByClientId(Long clientId);
}
