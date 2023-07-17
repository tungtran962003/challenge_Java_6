package com.example.challenge.service.impl;

import com.example.challenge.entity.People;
import com.example.challenge.repository.PeopleRepository;
import com.example.challenge.response.WordAppearSlogan;
import com.example.challenge.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public Page<People> getAllPeople(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

    public List<WordAppearSlogan> getWordAppearSlogan(String slogan) {

        return null;
    }
}
