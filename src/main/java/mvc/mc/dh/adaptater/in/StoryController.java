package mvc.mc.dh.adaptater.in;

import lombok.RequiredArgsConstructor;
import mvc.mc.dh.adaptater.out.StoryJpaEntity;
import mvc.mc.dh.port.in.StoryUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mvc.mc.dh.model.Story;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class StoryController {

    private final StoryUseCase storyUseCase;
    private List<Story> storyList;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    //--------------------------------------View Story--------------------------------------------

    @GetMapping("/")
    public String index(Model model) {
        storyList = storyUseCase.getStories();
        model.addAttribute("storyList",storyList);
        return "storyList";
    }

    @GetMapping("/story/{id}")
    public String viewStory(@PathVariable("id") Long ID,Model model){
        Story storyID = storyUseCase.getStory(ID);
        model.addAttribute("storyID",storyID);
        return "storyID";
    }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------Create Story--------------------------------------------
    @GetMapping("/create")
    public String createStory(Model model, Authentication auth){
        if (auth == null){ return "redirect:/oauth2/authorization/auth0"; }
        model.addAttribute("storyCreate", new Story(0,"","", LocalDateTime.now(),LocalDateTime.now()));
        return "storyCreate";
    }

    @PostMapping("/create")
    public RedirectView createStory(@ModelAttribute Story story, Model model){
        model.addAttribute(story);
        Story newStory = storyUseCase.addStory(story);
        return new RedirectView("/story/" + newStory.getID());
    }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------Update Story--------------------------------------------

    @GetMapping("/update/{id}")
    public String updateStory(@PathVariable("id") long id,Model model, Authentication auth){
        if(auth == null){ return "redirect:/oauth2/authorization/auth0"; }
        Story storyID = storyUseCase.getStory(id);
        model.addAttribute("storyUpdate", storyID);
        return "storyUpdate";
    }

    @PostMapping("/update")
    public RedirectView updateStory(@ModelAttribute Story story, Model model){
        model.addAttribute(story);
        Story updateStory = storyUseCase.updateStory(story);
        return new RedirectView("/story/" + updateStory.getID());
    }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------Delete Story--------------------------------------------

    @DeleteMapping("/delete")
    public String deleteStory(@RequestBody Story story, Model model, Authentication auth){
        if(auth == null){ return "redirect:/oauth2/authorization/auth0"; }
        model.addAttribute(story);
        boolean storyDelete = storyUseCase.removeStory(story.getID());
        if(storyDelete){ return "storyDelete"; }
        return "storyList";
    }

}