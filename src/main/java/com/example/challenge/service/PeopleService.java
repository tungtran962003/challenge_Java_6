package com.example.challenge.service;

import com.example.challenge.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeopleService {

    Page<People> getAllPeople(Pageable pageable);
}
