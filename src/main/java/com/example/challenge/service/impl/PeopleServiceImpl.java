package com.example.challenge.service.impl;

import com.example.challenge.entity.People;
import com.example.challenge.repository.PeopleRepository;
import com.example.challenge.response.CountryAscResponse;
import com.example.challenge.response.WordAppearSloganResponse;
import com.example.challenge.rto.CountryAsc;
import com.example.challenge.rto.CountryAscToDto;
import com.example.challenge.rto.JsonToPeople;
import com.example.challenge.service.PeopleService;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final String inputPath = "jsonData";
    private final String outputFile = "data.json";
    private final String seperator = "/";

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private CountryAscToDto countryDescToDto;

    // private WordAppearSloganResponse wordAppearSloganResponse = new WordAppearSloganResponse();

    @Override
    public Page<People> getAllPeople(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }

    public List<WordAppearSloganResponse> getWordAppearSlogan(String word, Integer number) {
        // Map<String, Integer> wordAppear = wordAppearSloganResponse.getWordAppear();


        // String[] arr;

//        int in = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getWord.equals(word)) {
//               in++;
//            }
//        }
        return null;
    }

    @Override
    public List<CountryAscResponse> getAllCountryAsc() {
        List<CountryAsc> listCountryAsc = peopleRepository.getCountryAsc();
        List<CountryAscResponse> listResponse = new ArrayList<>();
        for (CountryAsc countryAsc: listCountryAsc) {
            CountryAscResponse countryAscResponse = countryDescToDto.toDto(countryAsc);
            listResponse.add(countryAscResponse);
        }
        return listResponse;
    }
    public Boolean mergeJson() {
        var fileNameList = getAllJsonFileNameInFolderData();
        var summary = new ArrayList<String>();
        for (int i = 0; i < fileNameList.size(); i++) {
            var lines = readJsonFile(fileNameList.get(i), true);
            if (i == 0) {
                var newLine = lines.get(lines.size() - 1).replace("]", ",");
                lines.set(lines.size() - 1, newLine);
            } else if (i == fileNameList.size() - 1) {
                var newLine = lines.get(0).replace("[", "");
                lines.set(0, newLine);
            } else {
                var newLine1 = lines.get(0).replace("[", "");
                var newLine2 = lines.get(lines.size() - 1).replace("]", ",");
                lines.set(0, newLine1);
                lines.set(lines.size() - 1, newLine2);
            }
            summary.addAll(lines);
        }
        try {
            writeToFile(summary, outputFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ex2 start

    private void writeToFile(List<String> contents, String path) throws IOException {
        File f = new File(path);
        if(f.exists() && !f.isDirectory()) {
            f.delete();
        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outputFile);
            for (int i = 0; i < contents.size(); i++) {
                outputStream.write((contents.get(i) + "\n").getBytes());
            }
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private List<String> getAllJsonFileNameInFolderData() {
        File folder = new File(inputPath);
        File[] listOfFiles = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file: listOfFiles) {
            if (file.getName().endsWith(".json")) {
                fileNames.add(file.getName());
            }
        }
        Collections.sort(fileNames);
        return fileNames;
    }

    public List<String> readJsonFile(String name, boolean hasPath) {
        String folderPath = hasPath ? inputPath + seperator : "";
        String file =  folderPath + name;
        Path path = Paths.get(file);
        try {
            List<String> lines = Files.readAllLines(path);
            return lines;
        } catch (IOException e) {
            return null;
        }
    }
    // ex2 end

    // ex3 start
    @Override
    public String insertJsonDataToDb() {
        File f = new File(outputFile);
        if (f.exists() && f.isFile()) {
            var msg = addJsonToDB();
            return msg;
        }
        return null;
    }

    private String addJsonToDB() {
        var lines = readJsonFile(outputFile, false);
        var jsonData = String.join("\n", lines);
        int count  = 0;
        int total = 0;

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            total = jsonArray.length();
            for (int i = 0; i < jsonArray.length(); i++) {
                var p = JsonToPeople.toPeople(jsonArray.get(i));
                if (p != null) {
                    peopleRepository.save(p);
                    count++;
                }
            }
            return "Insert " + count + "/" + jsonArray.length() + " records!";
        } catch (Exception e) {
            return "Insert " + count + "/" + total + " records!";
        }
    }

    // ex3 end

}
