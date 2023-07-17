package com.example.challenge.java;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, IOException {
//

        List<String> jsonText = new ArrayList<>();
        List<String> fileNames = getAllJsonInFolder();
        for (int i = 0; i < fileNames.size(); i++) {
            var lines = readJsonFile(fileNames.get(i));
            if (lines != null) {
                if (i!= fileNames.size()-1) {
                    lines.set(lines.size() - 1, lines.get(lines.size() - 1).replace("]", ","));
                }
                if (i != 0){
                    lines.set(0, lines.get(lines.size() - 1).replace("[", ""));
                }
                jsonText.addAll(lines);
            }
        }


        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("data.json");
            for (int i = 0; i < jsonText.size(); i++) {
                outputStream.write(jsonText.get(i).getBytes());
            }
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static List<String> readJsonFile(String name) {
        String folderPath = "jsonData";
        String file =  folderPath + "\\" + name;
        Path path = Paths.get(file);
        try {
            List<String> lines = Files.readAllLines(path);
            return lines;
        } catch (IOException e) {
            return null;
        }
    }

    public static List<String> getAllJsonInFolder() {
        String folderPath = "jsonData";
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file: listOfFiles) {
            if (file.getName().endsWith(".json")) {
                fileNames.add(file.getName());
            }
        }
        return fileNames;
    }
}
