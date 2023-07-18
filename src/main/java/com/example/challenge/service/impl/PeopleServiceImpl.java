package com.example.challenge.service.impl;

import com.example.challenge.entity.People;
import com.example.challenge.repository.PeopleRepository;
import com.example.challenge.response.CountryAscResponse;
import com.example.challenge.response.WordAppearSloganResponse;
import com.example.challenge.rto.CountryAsc;
import com.example.challenge.rto.CountryAscToDto;
import com.example.challenge.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private CountryAscToDto countryDescToDto;

    private WordAppearSloganResponse wordAppearSloganResponse = new WordAppearSloganResponse();

    @Override
    public Page<People> getAllPeople(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

    public List<WordAppearSloganResponse> getWordAppearSlogan(String word, Integer number) {
        Map<String, Integer> wordAppear = wordAppearSloganResponse.getWordAppear();


        String[] arr;

//        int in = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getWord.equals(word)) {
//               in++;
//            }
//        }
        return null;
    }

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
