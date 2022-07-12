package com.example.thmodule4.service;

import com.example.thmodule4.model.Country;
import com.example.thmodule4.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryService implements ICountryService{
    @Autowired
    ICountryRepository countryRepository;
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}
