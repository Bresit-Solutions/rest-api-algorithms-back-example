package com.bresit.rest.api.algorithms.back.example.smallest_largest_number.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallestLargestNumberResult {

    private Integer smallest;
    private Integer largest;
}
