package com.example.thmodule4.controller;

import com.example.thmodule4.model.City;
import com.example.thmodule4.model.Country;
import com.example.thmodule4.service.ICityService;
import com.example.thmodule4.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citys")
@CrossOrigin("*")

public class CityController {
    @Autowired
    ICityService cityService;
    @Autowired
    ICountryService countryService;
    @GetMapping
    public ResponseEntity<Iterable<City>> findAllCity() {
        List<City> cities = (List<City>) cityService.findAll();
        if (cities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findCitytById(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        Country country=countryService.findById(city.getCountry().getId()).get();
        countryService.save(country);

        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        Optional<City> citytaiOptional = cityService.findById(id);
        if (!citytaiOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(citytaiOptional.get(), HttpStatus.NO_CONTENT);
    }
}
