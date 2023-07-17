package com.example.challenge.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDescResponse {

    private String country;

    private Integer number;
}
