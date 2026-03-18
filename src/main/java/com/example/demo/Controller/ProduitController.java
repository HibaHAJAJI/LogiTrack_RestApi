package com.example.demo.Controller;

import com.example.demo.Model.Produit;
import com.example.demo.Service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> afficherTous(){
        return produitService.afficherProduits();
    }
    @GetMapping("{id}")
    public Optional<Produit>afficherUneProduit(@PathVariable Long id){
        return produitService.ConsulterParId(id);
    }
    @PostMapping
    public Produit save(Produit produit){
        return produitService.ajouterProduit(produit);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
         produitService.SupprimerParId(id);
    }
}
