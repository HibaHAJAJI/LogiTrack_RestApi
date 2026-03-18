package com.example.demo.Repositorie;

import com.example.demo.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepos extends JpaRepository<Client,Long> {
    Optional<Client> findClientById(Long id) ;

    void deleteById(Long id);
}
