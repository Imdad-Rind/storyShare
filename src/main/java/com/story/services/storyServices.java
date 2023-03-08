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
    public storyModel getStoryById(UUID id){
        for (storyModel s : storyStore ){
            if (id.equals(s.getStoryID())){
                return s;
            }
        }
        return null;

    }
    public void deleteStoryInFo( UUID id){storyStore.remove(getStoryById(id));}

    public void updateStory(UUID id, storyModel storyModel) {

        storyStore.set(storyStore.indexOf(getStoryById(id)),storyModel );
    }
}
