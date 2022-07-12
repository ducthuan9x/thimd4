package com.example.thmodule4.repository;

import com.example.thmodule4.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City,Long> {

}
