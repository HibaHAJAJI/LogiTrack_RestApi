package com.example.demo.Controller;

import com.example.demo.Model.Produit;
import com.example.demo.Service.ProduitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class StatistiqueController {
    private final ProduitService produitService;

    public StatistiqueController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/api/products/low-stock")
    public List<Produit> afficherProduitParStockFaible(@RequestParam double prix){
        return produitService.getProduitsByPrixInferieur(prix);
    }
    @GetMapping("/api/statistics/top-product")
    public Produit TopProduit(){
        return produitService.getTopProduit();
    }
}
