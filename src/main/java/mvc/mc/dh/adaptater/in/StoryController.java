package mvc.mc.dh.adaptater.in;

import lombok.RequiredArgsConstructor;
import mvc.mc.dh.adaptater.out.StoryJpaEntity;
import mvc.mc.dh.port.in.StoryUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mvc.mc.dh.model.Story;
import org.springframework.web.servlet.ModelAndView;
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

    // Test page
    @GetMapping("/test")
    public String test(Model model){
        /*
        Story newStory = new Story(0, "test", null, null, null);
        model.addAttribute("story", newStory);
         */
        Story newStory = new Story(0, "Titre2", "Contenu2", LocalDateTime.now(), LocalDateTime.now());
        storyUseCase.addStory(newStory);
        return "test";
    }

    // Return the story list
    @GetMapping("/stories")
    public String viewStories(Model model){
        storyList = storyUseCase.getStories();
        // The name in "" will be used by thymeleaf to provide view
        model.addAttribute("storyList",storyList);
        return "storyList";
    }

    // Return story by ID
    @GetMapping("/story/{id}")
    public String viewStory(@PathVariable("id") Long ID,Model model){
        Story storyID = storyUseCase.getStory(ID);
        model.addAttribute("storyID",storyID);
        return "storyID";
    }


    // Method to see the form registration
    @GetMapping("/create")
    public String createStory(){
        //Story storyCreate = new Story(0,"","",LocalDateTime.now(),LocalDateTime.now());
        //model.addAttribute("storyCreate",storyCreate);
        return "storyCreate";
    }

    // Method to add a new story
    @PostMapping("/addStory")
    //@ResponseBody
    public RedirectView createStoryProcess(@ModelAttribute("createStory") Story story){
        Long redirectID = story.getID();
        storyUseCase.addStory(story);
        return new RedirectView("/story/"+redirectID);
     }

}