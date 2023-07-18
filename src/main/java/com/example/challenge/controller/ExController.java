package com.example.challenge.controller;

import com.example.challenge.entity.People;
import com.example.challenge.response.CommonResponse;
import com.example.challenge.service.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex")
public class ExController {

    @Autowired
    private PeopleService peopleService;
    @GetMapping("/1")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "1") int page) {
        Page<People> pagePeople;
        Pageable pageable = PageRequest.of(page - 1, 5);
        pagePeople = peopleService.getAllPeople(pageable);
        return ResponseEntity.ok(pagePeople);
    }

    public ResponseEntity<?> getWordAppearSlogan() {

        return null;
    }

    @GetMapping("/2")
    public ResponseEntity<?> mergeJson() {
        var result = peopleService.mergeJson();
        String msg = "Merge json fail!";
        if (result) {
            msg = "Merge json success!";
        }
        return ResponseEntity.ok(CommonResponse.builder()
                .data(result)
                .message(msg).build());
    }

    @PostMapping("/3")
    public ResponseEntity<?> insertJsonToDB() {
        String msg = peopleService.insertJsonDataToDb();
        return ResponseEntity.ok(CommonResponse.builder()
                .data(msg)
                .message("Success").build());
    }
}
