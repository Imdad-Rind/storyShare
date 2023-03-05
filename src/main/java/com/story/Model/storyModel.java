package com.story.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class storyModel {
    private UUID storyID;
    private String authorName;
    private int authorAge;
    private String authorStory;

}
