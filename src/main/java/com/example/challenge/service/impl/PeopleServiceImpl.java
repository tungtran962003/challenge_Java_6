package com.example.challenge.service.impl;

import com.example.challenge.entity.People;
import com.example.challenge.repository.PeopleRepository;
import com.example.challenge.response.CountryAscResponse;
import com.example.challenge.rto.CountryAsc;
import com.example.challenge.rto.CountryAscToDto;
import com.example.challenge.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private CountryAscToDto countryDescToDto;

    @Override
    public Page<People> getAllPeople(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

//    public List<WordAppearSlogan> getWordAppearSlogan(List<People> list) {
//        String[] character = list.spliterator
//        return null;
//    }

    @Override
    public List<CountryAscResponse> getAllCountryAsc() {
        List<CountryAsc> listCountryAsc = peopleRepository.getCountryAsc();
        List<CountryAscResponse> listResponse = new ArrayList<>();
        for (CountryAsc countryAsc: listCountryAsc) {
            CountryAscResponse countryAscResponse = countryDescToDto.toDto(countryAsc);
            listResponse.add(countryAscResponse);
        }
        return listResponse;
    }
}
