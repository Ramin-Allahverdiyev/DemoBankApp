package com.example.demoBankApp.repository;

import com.example.demoBankApp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    Optional<Client> findByUsername(String username);
    Optional<Client> findByIdAndStatus(Integer id, Integer status);
    List<Client> findAllByStatus(Integer status);
}
