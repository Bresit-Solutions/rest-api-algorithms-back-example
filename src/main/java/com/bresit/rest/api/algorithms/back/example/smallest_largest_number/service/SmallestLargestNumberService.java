package com.bresit.rest.api.algorithms.back.example.smallest_largest_number.service;

import com.bresit.rest.api.algorithms.back.example.smallest_largest_number.dto.SmallestLargestNumberResult;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
public interface SmallestLargestNumberService {

    SmallestLargestNumberResult smallestLargestNumber(@NotEmpty List<Integer> numbers);
}
