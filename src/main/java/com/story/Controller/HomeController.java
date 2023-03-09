package com.story.Controller;


import com.story.Model.StoryModel;
import com.story.services.StoryServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class HomeController {

    StoryModel stories;
    StoryServices _storyServices;
    HomeController(StoryModel _stories, StoryServices storyServices){
        this.stories = _stories;
        this._storyServices = storyServices;
    }

    @GetMapping("/")
    String index(){
        return "index";
    }

    @GetMapping("/write")
    String write(Model model) {
        model.addAttribute("write",new StoryModel());
        return "write";

    }
    @PostMapping("/submitStories")
    String submitStories(@ModelAttribute StoryModel _storyModel){
        _storyServices.addNewStoryInFo(_storyModel);
        return "redirect:/allStories";
    }



    @GetMapping("/allStories")
    String allStories(Model model) {
        model.addAttribute("storyList",_storyServices.getAllStoriesInFo());
        return "allStories";
    }


    @GetMapping("/deleteStory/{id}")
    String deleteStory(@PathVariable("id")UUID id) {
        _storyServices.deleteStoryInFo(id);
        return "redirect:/allStories";
    }

    /*@GetMapping("/deleteConfirmations/{id}")
    String deleteConfirmation(@PathVariable(name = "id")UUID id,Model model){
        var foundStory = _storyServices.getStoryById(id);
        model.addAttribute("foundStory",foundStory);
        return "redirect:/deleteConfirmations";
    }*/
    @GetMapping("/updateStoryPage/{id}")
    String updateStoryPage(Model model,@PathVariable("id") UUID id){
        model.addAttribute("newWrite",_storyServices.getStoryById(id));
        return "updateStoryPage";
    }
    @PostMapping("/updateStory")
    String updateStory(@ModelAttribute StoryModel _storyModel){
        _storyServices.updateStory(_storyModel.getStoryID(), _storyModel);
        String storyID = _storyModel.getStoryID().toString();
        return "redirect:/storyDetail/"+storyID;
    }

    @GetMapping("/storyDetail/{id}")
    String storyDetail(Model model,@PathVariable("id") UUID id){
        model.addAttribute("storyDetail",_storyServices.getStoryById(id));
        return "storyDetail";
    }

}
