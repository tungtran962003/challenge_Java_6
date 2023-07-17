package com.example.challenge.rto;

import com.example.challenge.entity.People;
import com.example.challenge.response.CountryDescResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public class CountryDescToDto {
    public CountryDescResponse toDto(CountryDesc countryDesc) {
        return CountryDescResponse.builder().country(countryDesc.getCountry())
                .number(countryDesc.getNumber()).build();
    }
}
