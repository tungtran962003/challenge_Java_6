package com.example.challenge.service;

import com.example.challenge.entity.People;
import com.example.challenge.response.CountryAscResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeopleService {

    Page<People> getAllPeople(Pageable pageable);

    List<CountryAscResponse> getAllCountryAsc();
}
