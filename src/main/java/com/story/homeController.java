package com.story;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class homeController {

    storyModel stories;
    homeController(storyModel _stories){
        this.stories = _stories;
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
        List<storyModel> allStories = new ArrayList<storyModel>();

        stories.setAuthorName(_storyModel.getAuthorName());
        stories.setAuthorAge(_storyModel.getAuthorAge());
        stories.setAuthorStory(_storyModel.getAuthorStory());
        return "redirect:/allStories";
    }

    @GetMapping("/allStories")
    String allStories(Model model) {
        model.addAttribute("storyList",stories);
        return "allStories";
    }


}
