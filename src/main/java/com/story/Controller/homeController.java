package com.story.Controller;


import com.story.Model.storyModel;
import com.story.services.storyServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class homeController {

    storyModel stories;
    storyServices _storyServices;
    homeController(storyModel _stories, storyServices storyServices){
        this.stories = _stories;
        this._storyServices = storyServices;
    }

    @GetMapping("/")
    String index(){
        return "index";
    }

    @GetMapping("/write")
    String write(Model model) {
        model.addAttribute("write",new storyModel());
        return "write";

    }
    @PostMapping("/submitStories")
    String submitStories(@ModelAttribute storyModel _storyModel){
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
    String updateStory(@ModelAttribute storyModel _storyModel){
        _storyServices.updateStory(_storyModel.getStoryID(), _storyModel);
        return "redirect:/allStories";
    }

}
