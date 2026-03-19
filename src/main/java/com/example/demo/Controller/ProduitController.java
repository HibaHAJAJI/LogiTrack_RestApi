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

    @GetMapping("/{id}")
    public Optional<Produit>afficherUneProduit(@PathVariable Long id){
        return produitService.ConsulterParId(id);
    }

    @PostMapping
    public Produit save(@RequestBody Produit produit){
        return produitService.ajouterProduit(produit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         produitService.SupprimerParId(id);
    }

    @GetMapping("/category/{category}")
    public List<Produit>findProduitParCategorie(@PathVariable String category){
        return produitService.RechercheProduitParCategorie(category);
    }
    @GetMapping("/price/{prix}")
    public List<Produit>findProduitinfirieur(@PathVariable double prix){
     return produitService.getProduitsByPrixInferieur(prix);
    }
    @GetMapping("/api/statistics/top-product")
    public Produit TopProduit(){
        return produitService.getTopProduit();
    }
    @GetMapping("/api/products/low-stock")
    public List<Produit> afficherProduitParStockFaible(@RequestParam double prix){
        return produitService.getProduitsByPrixInferieur(prix);
    }
}
