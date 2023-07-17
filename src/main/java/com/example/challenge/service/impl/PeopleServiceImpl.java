package com.example.challenge.service.impl;

import com.example.challenge.entity.People;
import com.example.challenge.repository.PeopleRepository;
import com.example.challenge.response.CountryDescResponse;
import com.example.challenge.rto.CountryDesc;
import com.example.challenge.rto.CountryDescToDto;
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
    private CountryDescToDto countryDescToDto;

    @Override
    public Page<People> getAllPeople(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

//    public List<WordAppearSlogan> getWordAppearSlogan(List<People> list) {
//        String[] character = list.spliterator
//        return null;
//    }

    @Override
    public List<CountryDescResponse> getAllCountryDesc() {
        List<CountryDesc> listCountryDesc = peopleRepository.getCountryDesc();
        List<CountryDescResponse> listResponse = new ArrayList<>();
        for (CountryDesc countryDesc: listCountryDesc) {
            CountryDescResponse countryDescResponse = countryDescToDto.toDto(countryDesc);
            listResponse.add(countryDescResponse);
        }
        return listResponse;
    }
}
