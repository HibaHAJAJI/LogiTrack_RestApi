package com.example.demo.Controller;

import com.example.demo.Enum.Statut;
import com.example.demo.Model.Commande;
import com.example.demo.Service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }


    @GetMapping
    public List<Commande>afficherTous(){
        return commandeService.afficherCommandes();
    }
    
    @GetMapping("{id}")
    public Optional<Commande>consulterId(@PathVariable Long id){
        return commandeService.consulterParId(id);
    }

    @GetMapping("client/{clientId}")
    private List<Commande>findByClientId(@PathVariable Long clientId){
       return commandeService.rechercheParClientId(clientId);
    }

    @GetMapping("/count")
    public long NumbreCommandes(){
        return commandeService.countCommandes();
    }
    @PostMapping
    public Commande addCommandeClient(@RequestParam Long clientId) throws Exception {
        return commandeService.creerCommande(clientId);
    }
    @PostMapping("/{orderId}/products")
    public Commande addProduit(@PathVariable Long orderId,@PathVariable Long produitId,@PathVariable int quantite)throws Exception{
        return commandeService.ajouterProduit(orderId,produitId,quantite);
    }
    @PutMapping("/{id}/status")
    public Commande modiferStatus(@PathVariable Long id,@RequestBody Statut statut) throws Exception {
        return commandeService.updateStatus(id, statut);
    }
}
