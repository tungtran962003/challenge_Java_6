package com.example.challenge.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryAscResponse {

    private String country;

    private Integer number;
}
