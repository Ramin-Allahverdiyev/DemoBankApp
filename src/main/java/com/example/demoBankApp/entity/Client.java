package com.example.demoBankApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;
    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Account> accounts=new HashSet<>();
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clients_auth",
            joinColumns = {@JoinColumn(name = "client_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "auth_name",referencedColumnName = "name")}
    )
    private Set<Authority> authorities=new HashSet<>();

    private Integer status;

    @PrePersist
    private void defaultSet(){
        status= 1;
    }

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}