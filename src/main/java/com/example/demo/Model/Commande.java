package com.example.demo.Model;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dateCommande;
    private Status type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    private List<LigneCommande > ligneCommandes;


    public enum Status{
        EN_ATTENTE,
        EXPEDIEE,
        LIVREE
    }
    public Commande() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Status getType() {
        return type;
    }

    public void setType(Status type) {
        this.type = type;
    }

    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", dateCommande=" + dateCommande +
                ", type=" + type +
                ", client=" + client +
                ", ligneCommandes=" + ligneCommandes +
                '}';
    }
}
