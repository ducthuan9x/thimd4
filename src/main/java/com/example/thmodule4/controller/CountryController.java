package com.example.thmodule4.controller;

import com.example.thmodule4.model.Country;
import com.example.thmodule4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countrys")
@CrossOrigin("*")

public class CountryController {
    @Autowired
    ICountryService countryService;
    @GetMapping
    public ResponseEntity<Iterable<Country>> findAllCountry() {
        List<Country> countries = (List<Country>) countryService.findAll();
        if (countries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable Long id) {
        Optional<Country> countryOptional = countryService.findById(id);
        if (!countryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(countryOptional.get(), HttpStatus.OK);
    }
}
