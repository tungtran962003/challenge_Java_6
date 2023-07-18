package com.example.challenge.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordAppearSloganResponse {

    private String word;
    private Integer number;

    private Map<String, Integer> wordAppear = new HashMap<>();
}
