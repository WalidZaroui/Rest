package com.example.soapproject.repository;

import com.example.soapproject.models.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatRepository extends JpaRepository<Plat, Long> {
}