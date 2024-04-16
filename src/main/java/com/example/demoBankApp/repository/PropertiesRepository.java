package com.example.demoBankApp.repository;

import com.example.demoBankApp.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties,Integer> {

}
