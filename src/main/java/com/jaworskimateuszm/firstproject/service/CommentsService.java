package com.jaworskimateuszm.firstproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaworskimateuszm.firstproject.config.CommentsGenerator;
import com.jaworskimateuszm.firstproject.dto.CalculationTimeDto;
import com.jaworskimateuszm.firstproject.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsService {

    private static final String API_URL = "https://jsonplaceholder.typicode.com/comments/";

    private List<CommentDto> comments;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    // 500 comments
    public List<CommentDto> findAll() {
        for (int id = 1; id <= 500; id++) {
            this.comments.add(restTemplate.getForObject(API_URL + id, CommentDto.class));
        }
        return comments;
    }

    public List<CommentDto> generate(int number) {
        comments = CommentsGenerator.generate(number);
        return comments;
    }

    public CalculationTimeDto getStreamTime() {
        long start = System.currentTimeMillis();
        List<CommentDto> filteredComments = comments.stream().filter(c -> c.getBody().startsWith("2")).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        return new CalculationTimeDto("Stream", end - start);
    }

    public CalculationTimeDto getParallelStreamTime() {
        long start = System.currentTimeMillis();
        List<CommentDto> filteredComments = comments.parallelStream().filter(c -> c.getBody().startsWith("2")).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        return new CalculationTimeDto("Parallel Stream", end - start);
    }
}
