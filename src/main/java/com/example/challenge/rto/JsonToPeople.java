package com.example.challenge.rto;

import com.example.challenge.entity.People;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPeople {
    public static People toPeople(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            var p = mapper.readValue(obj.toString(), People.class);
            return p;
        } catch (Exception e) {
            return null;
        }
    }
}
