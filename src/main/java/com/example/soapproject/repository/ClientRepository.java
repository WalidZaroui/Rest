package com.example.soapproject.repository;


import com.example.soapproject.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>, ClientRepositoryCostum {

}