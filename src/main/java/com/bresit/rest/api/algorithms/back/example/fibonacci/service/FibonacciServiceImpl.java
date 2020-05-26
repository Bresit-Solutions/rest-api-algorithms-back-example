package com.bresit.rest.api.algorithms.back.example.fibonacci.service;

import com.bresit.rest.api.algorithms.back.example.fibonacci.dto.FibonacciResult;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = {"fibonacci"})
public class FibonacciServiceImpl implements FibonacciService {

    @Override
    public FibonacciResult fibonacci(int number, FibonacciCalculationMethod method) {
        if (number < 0) {
            throw new RuntimeException("Invalid input number for fibonacci calculation");
        }
        //Abstract factory pattern implentation
        BigInteger result = null;
        long milisecondsStart = System.currentTimeMillis();
        switch (method) {
            case RECURSIVE:
                result = fibonacciRecursive(number);
                break;
            case MEMO_HASHMAP:
                result = fibonacciMemoizationHashMap(number);
                break;
            case MEMO_SPRING_CACHE:
                result = fibonacciMemoizationSpringCache(number);
                break;
        }
        long milisecondsEnd = System.currentTimeMillis();
        return FibonacciResult.builder()
                .result(result)
                .timeInMiliseconds(milisecondsEnd - milisecondsStart)
                .build();
    }

    private BigInteger fibonacciRecursive(int number) {
        if (number == 0 || number == 1) {
            return BigInteger.valueOf(number);
        }
        return fibonacciRecursive(number - 1).add(fibonacciRecursive(number - 2));
    }

    private BigInteger fibonacciHashMapAux(int number, Map<Integer, BigInteger> map) {
        if (number == 0 || number == 1) {
            return BigInteger.valueOf(number);
        }
        //If the number was calculated previously then return it from map
        if (map.containsKey(number))
            return map.get(number);
        //In other case is necessary calculate the result now and store it into the map
        BigInteger result = fibonacciHashMapAux(number - 1, map).add(fibonacciHashMapAux(number - 2, map));
        map.put(number, result);
        return result;
    }

    public BigInteger fibonacciMemoizationHashMap(int number) {
        Map<Integer, BigInteger> map = new HashMap<>();
        return fibonacciHashMapAux(number, map);
    }

    @Cacheable
    public BigInteger fibonacciMemoizationSpringCache(int number) {
        Map<Integer, BigInteger> map = new HashMap<>();
        return fibonacciHashMapAux(number, map);
    }
}
