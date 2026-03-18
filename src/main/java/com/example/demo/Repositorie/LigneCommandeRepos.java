package com.example.demo.Repositorie;

import com.example.demo.Model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepos extends JpaRepository<LigneCommande,Long> {
}
