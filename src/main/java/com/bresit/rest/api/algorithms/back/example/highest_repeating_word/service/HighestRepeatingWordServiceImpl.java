package com.bresit.rest.api.algorithms.back.example.highest_repeating_word.service;

import com.bresit.rest.api.algorithms.back.example.highest_repeating_word.dto.HighestRepeatingWordResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HighestRepeatingWordServiceImpl implements HighestRepeatingWordService {

    private File saveFileToTmpDir(MultipartFile file) throws IOException {
        String tmpDir = System.getProperty("java.io.tmpdir");
        String newFileUrl = tmpDir + File.separator + UUID.randomUUID();
        File newFile = new File(newFileUrl);
        OutputStream outStream = new FileOutputStream(newFile);
        outStream.write(file.getBytes());
        outStream.close();
        return newFile;
    }

    @Override
    public HighestRepeatingWordResult findHighestRepeatingWord(@NotNull MultipartFile file) throws IOException {
        File fileDisk = saveFileToTmpDir(file);

        //This map stores the ocurrences for every word
        Map<String, Integer> mapWordsCount = new HashMap<>();

        //Read the file content
        BufferedReader br = new BufferedReader(new FileReader(fileDisk));
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.toLowerCase().split(" ");
            for (String word : words) {
                //Revome spaces at the beginning and the end of the word
                word = word.trim();
                if (!word.isEmpty()) {
                    int count = mapWordsCount.containsKey(word) ? mapWordsCount.get(word) : 0;
                    count++;
                    mapWordsCount.put(word, count);
                }
            }
        }
        br.close();

        //Delete file from disk
        fileDisk.delete();

        //Find the highest repeating word
        HighestRepeatingWordResult result = HighestRepeatingWordResult.builder()
                .timesRepeated(0)
                .build();

        for (Map.Entry<String, Integer> entry : mapWordsCount.entrySet()) {
            if (entry.getValue() > result.getTimesRepeated()) {
                result.setWord(entry.getKey());
                result.setTimesRepeated(entry.getValue());
            }
        }

        return result;
    }
}
