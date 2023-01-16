package mvc.mc.dh.adaptater.in;

import lombok.RequiredArgsConstructor;
import mvc.mc.dh.port.in.StoryUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.mc.dh.model.Story;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class StoryController {

    private final StoryUseCase storyUseCase;
    private List<Story> storyList;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Page de test
    @GetMapping("/test")
    public String test(Model model){
        Story newStory = new Story(0, "test", null, null, null);
        model.addAttribute("story", newStory);
        return "test";
    }

    // Return the story List view
    @GetMapping("/stories")
    public String viewStories(Model model){
        storyList = storyUseCase.getStories();
        // The name in "" will be used by thymeleaf to provide view
        model.addAttribute("storyList",storyList);
        return "storyList";
    }

}