package mvc.mc.dh.adaptater.in;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mvc.mc.dh.model.Story;

@Controller
@RequestMapping("/")
public class StoryController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/test")
    public String test(Model model){
        Story newStory = new Story(0, "test", null, null, null);
        model.addAttribute("story", newStory);
        return "test";
    }

}