package com.example.challenge.service;

import com.example.challenge.entity.People;
import com.example.challenge.response.CountryAscResponse;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PeopleService {

    Page<People> getAllPeople(Pageable pageable);

    List<CountryAscResponse> getAllCountryAsc();
    Boolean mergeJson();

    String insertJsonDataToDb();

    Page<People> getDataOrderBySalary(Pageable pageable);
}
