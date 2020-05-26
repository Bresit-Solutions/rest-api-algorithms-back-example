package com.bresit.rest.api.algorithms.back.example.smallest_largest_number.service;

import com.bresit.rest.api.algorithms.back.example.smallest_largest_number.dto.SmallestLargestNumberResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmallestLargestNumberServiceImpl implements SmallestLargestNumberService {

    @Override
    public SmallestLargestNumberResult smallestLargestNumber(@NotEmpty List<Integer> numbers) {
        SmallestLargestNumberResult result = SmallestLargestNumberResult.builder()
                .largest(Integer.MIN_VALUE)
                .smallest(Integer.MAX_VALUE)
                .build();

        for (Integer number : numbers) {
            if (number > result.getLargest())
                result.setLargest(number);
            if (number < result.getSmallest())
                result.setSmallest(number);
        }

        return result;
    }
}
