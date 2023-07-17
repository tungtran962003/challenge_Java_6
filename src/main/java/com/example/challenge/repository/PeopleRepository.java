package com.example.challenge.repository;

import com.example.challenge.entity.People;
import com.example.challenge.response.CountryDescResponse;
import com.example.challenge.rto.CountryDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PeopleRepository extends JpaRepository<People, UUID> {

//    @Query(value = "SELECT slogan FROM People ")
//    List<People> getAllSlogan();

    @Query(value = "SELECT country as country," +
            " COUNT(country) as number FROM People " +
            " GROUP BY country " +
            " ORDER BY COUNT(country) DESC ")
    List<CountryDesc> getCountryDesc();
}
