package com.jaworskimateuszm.firstproject.config;

import com.jaworskimateuszm.firstproject.dto.CommentDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommentsGenerator {

    public static List<CommentDto> generate(int size) {
        List<CommentDto> comments = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            comments.add(new CommentDto(i ,i,"Name" + i, "Mail" + i, UUID.randomUUID().toString()));
        }

        return comments;
    }


}
