package com.bresit.rest.api.algorithms.back.example.fibonacci.service;

import com.bresit.rest.api.algorithms.back.example.fibonacci.dto.FibonacciResult;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface FibonacciService {

    FibonacciResult fibonacci(int number, @NotNull FibonacciCalculationMethod method);
}
