package com.example.demo.Repositorie;

import com.example.demo.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProduitRepos extends JpaRepository<Produit,Long> {
    Optional<Produit>findProduitById(Long id);
    void deleteById(Long id);

    List<Produit> findProduitByCategorie(String categorie);

    List<Produit> findProduitByPrixLessThan(double prix);

    @Query("select p from Produit p where p.quantiteStock<2 ")
    List<Produit>findLowStock();

    @Query("select  ligne from LigneCommande ligne group by ligne.produit order by  sum (ligne.quantite)desc ")
    Produit findToProduit();
}
