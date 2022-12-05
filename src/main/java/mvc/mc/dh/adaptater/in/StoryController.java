package mvc.mc.dh.adaptater.in;

import lombok.RequiredArgsConstructor;
import mvc.mc.dh.port.in.StoryUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mvc.mc.dh.model.Story;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class StoryController {

    private final StoryUseCase storyUseCase;
    private List<Story> storyList;

    @GetMapping("/")
    public String index(Model model) {
        storyList = storyUseCase.getStories();
        // The name in "" will be used by thymeleaf to provide view
        model.addAttribute("storyList",storyList);
        return "storyList";
    }

    @GetMapping("/story/{id}")
    public String viewStory(@PathVariable("id") Long ID,Model model){
        Story storyID = storyUseCase.getStory(ID);
        model.addAttribute("storyID",storyID);
        return "storyID";
    }

    @GetMapping("/create")
    public String createStory(Model model, Authentication auth){
        if (auth == null){ return "redirect:/oauth2/authorization/auth0"; }
        model.addAttribute("storyCreate", new Story(0,"","",LocalDateTime.now(),LocalDateTime.now()));
        return "storyCreate";
    }

    @PostMapping("/create")
    public RedirectView addToDb(@ModelAttribute Story story, Model model){
        model.addAttribute(story);
        Story newStory = storyUseCase.addStory(story);
        return new RedirectView("/story/" + newStory.getID());
    }
}