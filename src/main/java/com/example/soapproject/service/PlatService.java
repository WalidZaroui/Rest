package com.example.soapproject.service;
import com.example.soapproject.models.Plat;
import java.util.List;

public interface PlatService {
    List<Plat> getAllPlats();
    Plat getPlatById(Long id);
    Plat createPlat(Plat plat);
    Plat updatePlat(Plat plat);
    void deletePlat(Long id);
}