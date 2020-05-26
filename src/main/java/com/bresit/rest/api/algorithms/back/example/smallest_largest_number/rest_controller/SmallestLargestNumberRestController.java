package com.bresit.rest.api.algorithms.back.example.smallest_largest_number.rest_controller;

import com.bresit.rest.api.algorithms.back.example.smallest_largest_number.dto.SmallestLargestNumberResult;
import com.bresit.rest.api.algorithms.back.example.smallest_largest_number.service.SmallestLargestNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/smallestLargestNumber")
@RequiredArgsConstructor
public class SmallestLargestNumberRestController {

    private final SmallestLargestNumberService smallestLargestNumberService;

    @GetMapping
    public ResponseEntity<?> smallestLargestNumber(@RequestParam("numbers") List<Integer> numbers) {
        SmallestLargestNumberResult result = smallestLargestNumberService.smallestLargestNumber(numbers);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
