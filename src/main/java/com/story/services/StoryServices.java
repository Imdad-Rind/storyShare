package com.story.services;

import com.story.Model.StoryModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StoryServices {


    private List<StoryModel> storyStore = new ArrayList<>();

    public void addNewStoryInFo(StoryModel storyModel){
        UUID newUserID = UUID.randomUUID();
        storyModel.setStoryID(newUserID);
        storyModel.setUploadDate(LocalDate.now());
        storyStore.add(storyModel);
    }

    public List<StoryModel> getAllStoriesInFo(){
        return storyStore;
    }
    public StoryModel getStoryById(UUID id){
        for (StoryModel s : storyStore ){
            if (id.equals(s.getStoryID())){
                return s;
            }
        }
        return null;

    }
    public void deleteStoryInFo( UUID id){storyStore.remove(getStoryById(id));}

    public void updateStory(UUID id, StoryModel storyModel) {

        storyStore.set(storyStore.indexOf(getStoryById(id)),storyModel );
    }
}
