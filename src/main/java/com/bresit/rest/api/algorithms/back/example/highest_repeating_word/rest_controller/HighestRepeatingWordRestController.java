package com.bresit.rest.api.algorithms.back.example.highest_repeating_word.rest_controller;

import com.bresit.rest.api.algorithms.back.example.highest_repeating_word.dto.HighestRepeatingWordResult;
import com.bresit.rest.api.algorithms.back.example.highest_repeating_word.service.HighestRepeatingWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/highestRepeatingWord")
@RequiredArgsConstructor
public class HighestRepeatingWordRestController {

    private final HighestRepeatingWordService highestRepeatingWordService;

    @PostMapping
    public ResponseEntity<?> smallestLargestNumber(@RequestParam("file") MultipartFile file) throws IOException {
        HighestRepeatingWordResult result = highestRepeatingWordService.findHighestRepeatingWord(file);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
