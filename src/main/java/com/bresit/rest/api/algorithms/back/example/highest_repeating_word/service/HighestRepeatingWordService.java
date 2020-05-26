package com.bresit.rest.api.algorithms.back.example.highest_repeating_word.service;

import com.bresit.rest.api.algorithms.back.example.highest_repeating_word.dto.HighestRepeatingWordResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;

@Validated
public interface HighestRepeatingWordService {

    HighestRepeatingWordResult findHighestRepeatingWord(@NotNull MultipartFile file) throws IOException;
}
