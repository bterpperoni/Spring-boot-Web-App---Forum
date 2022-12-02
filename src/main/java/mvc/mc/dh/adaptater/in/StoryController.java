package mvc.mc.dh.adaptater.in;

import lombok.RequiredArgsConstructor;
import mvc.mc.dh.port.in.StoryUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import mvc.mc.dh.model.Story;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class StoryController {

    private final StoryUseCase storyUseCase;
    private List<Story> storyList;

    //--------------------------------------View Story--------------------------------------------

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OidcUser principal, Authentication auth, Model model) {
        storyList = storyUseCase.getStories();
        model.addAttribute("storyList",storyList);
        if(auth == null || !storyUseCase.isAdmin(principal.getEmail())){
            return "storyList";
        }else{
            return "admin-templates/storyListAdmin";
        }
    }

    @GetMapping("/story/{id}")
    public String viewStory(@PathVariable("id") Long ID, Model model, @AuthenticationPrincipal OidcUser principal, Authentication auth, RedirectAttributes redirectAttributes) {
        Story storyID = storyUseCase.getStory(ID);
        model.addAttribute("storyID",storyID);
        if(auth == null){
                redirectAttributes.addFlashAttribute("error", "Please log in to see complete post");
            return "redirect:/oauth2/authorization/auth0";
        }else if(!storyUseCase.isAdmin(principal.getEmail())){
            return "storyID";
        }else{
            return "admin-templates/storyIDAdmin";
        }
    }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------Create Story--------------------------------------------
    @GetMapping("/create")
    public String createStory(@AuthenticationPrincipal OidcUser principal, Authentication auth, Model model){
        if (auth == null || !storyUseCase.isAdmin(principal.getEmail())){ return "redirect:/oauth2/authorization/auth0"; }
        else{
            model.addAttribute("storyCreate", new Story(0,"","", LocalDateTime.now(),LocalDateTime.now(), true));
            return "storyCreate";
        }
    }

    @PostMapping("/create")
    public RedirectView createStory(@ModelAttribute Story story, Model model, RedirectAttributes redirectAttributes) {
            model.addAttribute(story);
            Story newStory = storyUseCase.addStory(story);
            if(story.getTITLE().equals(newStory.getTITLE())){
                redirectAttributes.addAttribute("success", "You have successfully added a story !");
                return new RedirectView("/story/" + newStory.getID());
            }else{
                redirectAttributes.addAttribute("error", "Please try again later !");
                return new RedirectView("/storyCreate");
            }
        }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------Update Story--------------------------------------------

    @GetMapping("/update/{id}")
    public String updateStory(@PathVariable("id") long id, @AuthenticationPrincipal OidcUser principal, Authentication auth, Model model){
        if(auth == null || !storyUseCase.isAdmin(principal.getEmail())){ return "redirect:/oauth2/authorization/auth0"; }
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
    // todo : visible or not with VISIBLE attribute & implement it in thymeleaf

}