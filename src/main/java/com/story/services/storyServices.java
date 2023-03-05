package com.story.services;

import com.story.Model.storyModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class storyServices {

    storyModel _storyModel;
    private storyServices(storyModel storyModel){
        this._storyModel = storyModel;
    }

    private List<storyModel> storyStore = new ArrayList<>();

    public void addNewStoryInFo(storyModel storyModel){
        UUID newUserID = UUID.randomUUID();
        storyModel.setStoryID(newUserID);
        storyStore.add(storyModel);

    }

    public List<storyModel> getAllStoriesInFo(){
        return storyStore;
    }
    public Optional<storyModel> getStoryById(UUID id){
        //var indexOf_ID = storyStore.indexOf(id);
        return storyStore.stream().filter(user -> _storyModel.getStoryID().equals(id) ).findFirst();
            /*if (userID.equals(id)){
                return storyStore;

            }*/
        /*return null;*/
    }

    public void deleteStoryInFo( UUID id){
        var studentToBeRemoved = getStoryById(id);
        storyStore.remove(studentToBeRemoved);
    }



}
