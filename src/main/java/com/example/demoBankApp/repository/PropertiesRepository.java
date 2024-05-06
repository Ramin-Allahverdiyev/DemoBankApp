package com.example.demoBankApp.repository;

import com.example.demoBankApp.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties,Integer> {
    Optional<Properties> findByKeyAndEmployee_Id(String key, Integer clientId);
    @Query(value = "SELECT p.id FROM properties p WHERE p.key = :key AND p.employee_Id = :employeeId", nativeQuery = true)
    List<Integer> getPropertyIdsByNameAndEmployeeId(@Param("key") String name, @Param("employeeId") Integer employeeId);
}
