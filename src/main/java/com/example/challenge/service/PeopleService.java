package com.example.challenge.service;

import com.example.challenge.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PeopleService {

    Page<People> getAllPeople(Pageable pageable);

    Boolean mergeJson();
}
