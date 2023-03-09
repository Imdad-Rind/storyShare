package com.story.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Component
public class StoryModel {
    private UUID storyID;
    private String StoryTitle;
    private String Story;
    private LocalDate uploadDate;

}
