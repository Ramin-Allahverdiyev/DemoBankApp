package com.example.demoBankApp.repository;

import com.example.demoBankApp.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties,Integer> {
    Optional<Properties> findByKeyAndClient_Id(String key, Integer clientId);
}
