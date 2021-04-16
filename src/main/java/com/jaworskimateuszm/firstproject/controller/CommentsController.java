package com.jaworskimateuszm.firstproject.controller;

import com.jaworskimateuszm.firstproject.dto.CalculationTimeDto;
import com.jaworskimateuszm.firstproject.dto.CommentDto;
import com.jaworskimateuszm.firstproject.service.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping
    public List<CommentDto> getCommentsFromApi(){
        return commentsService.findAll();
    }

    @GetMapping("/{number}")
    public List<CommentDto> generateComments(@PathVariable int number){
        return commentsService.generate(number);
    }

    @GetMapping("/stream-time")
    public CalculationTimeDto getStreamTime(){
        return commentsService.getStreamTime();
    }

    @GetMapping("/parallel-stream")
    public CalculationTimeDto getParallelStreamTime(){
        return commentsService.getParallelStreamTime();
    }
}
