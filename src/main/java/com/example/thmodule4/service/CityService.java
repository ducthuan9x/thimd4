package com.example.thmodule4.service;

import com.example.thmodule4.model.City;
import com.example.thmodule4.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityService implements ICityService{
    @Autowired
    ICityRepository cityRepository;
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
}
