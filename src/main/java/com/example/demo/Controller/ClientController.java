package com.example.demo.Controller;



import com.example.demo.Model.Client;
import com.example.demo.Service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAll(){
        return clientService.afficherClient();
    }
    @GetMapping("{id}")
    public Optional<Client> afficherParID(@PathVariable Long id){
        return clientService.consulterParId(id);
    }
    @PostMapping
    public Client save(@RequestBody Client client){
        return clientService.ajouterClient(client);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        clientService.supprimerParID(id);
    }
}
