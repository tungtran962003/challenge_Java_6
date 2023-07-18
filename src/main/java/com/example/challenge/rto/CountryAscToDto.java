package com.example.challenge.rto;

import com.example.challenge.response.CountryAscResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public class CountryAscToDto {
    public CountryAscResponse toDto(CountryAsc countryAsc) {
        return CountryAscResponse.builder().country(countryAsc.getCountry())
                .number(countryAsc.getNumber()).build();
    }
}
