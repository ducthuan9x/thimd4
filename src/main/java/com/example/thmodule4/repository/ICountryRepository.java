package com.example.thmodule4.repository;

import com.example.thmodule4.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country,Long> {
}
