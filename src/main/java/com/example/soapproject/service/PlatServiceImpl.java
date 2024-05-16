package com.example.soapproject.service;

import com.example.soapproject.models.Plat;
import com.example.soapproject.repository.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlatServiceImpl implements PlatService {

    @Autowired
    private PlatRepository platRepository;

    @Override
    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    @Override
    public Plat getPlatById(Long id) {
        return platRepository.findById(id).orElse(null);
    }

    @Override
    public Plat createPlat(Plat plat) {
        return platRepository.save(plat);
    }

    @Override
    public Plat updatePlat(Plat plat) {
        return platRepository.save(plat);
    }

    @Override
    public void deletePlat(Long id) {
        platRepository.deleteById(id);
    }
}