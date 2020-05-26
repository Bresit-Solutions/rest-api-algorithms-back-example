package com.bresit.rest.api.algorithms.back.example.fibonacci.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FibonacciResult {

    private BigInteger result;
    private Long timeInMiliseconds;
}
