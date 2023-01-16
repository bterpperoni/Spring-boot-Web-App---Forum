package mvc.mc.dh.adaptater.in;

import lombok.RequiredArgsConstructor;
import mvc.mc.dh.port.in.StoryUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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

    //--------------------------------------View Story--------------------------------------------

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OidcUser principal, Authentication auth, Model model) {
        storyList = storyUseCase.getStories();
        model.addAttribute("storyList",storyList);
        if(auth == null || !storyUseCase.isAdmin(principal.getEmail())){
            // Return stories with VISIBLE = true
            return "user-templates/storyList";
        }else{
            // Return all stories
            return "admin-templates/storyListAdmin";
        }
    }

    @GetMapping("/story/{id}")
    public String viewStory(@PathVariable("id") Long ID, Model model, @AuthenticationPrincipal OidcUser principal, Authentication auth) {
        Story storyID = storyUseCase.getStory(ID);
        model.addAttribute("storyID",storyID);
        if(auth == null){ return "redirect:/oauth2/authorization/auth0"; }
        else if(!storyUseCase.isAdmin(principal.getEmail())){
            return "user-templates/storyID";
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
            return "/admin-templates/storyCreate";
        }
    }

    @PostMapping("/create")
    public RedirectView createStory(@ModelAttribute("createStory") Story story, Model model) {
        model.addAttribute(story);
        Story newStory = storyUseCase.addStory(story);
        return new RedirectView("/story/" + newStory.ID());
    }

    //----------------------------------------------------------------------------------------------
    //--------------------------------------Update Story--------------------------------------------

    @GetMapping("/update/{id}")
    public String updateStory(@PathVariable("id") long id, @AuthenticationPrincipal OidcUser principal, Authentication auth, Model model){
        if(auth == null || !storyUseCase.isAdmin(principal.getEmail())){ return "redirect:/oauth2/authorization/auth0"; }
        Story storyID = storyUseCase.getStory(id);
        model.addAttribute("storyUpdate", storyID);
        return "/admin-templates/storyUpdate";
    }

    @PostMapping("/update")
    public RedirectView updateStory(@ModelAttribute Story story, Model model){
        model.addAttribute(story);
        Story updateStory = storyUseCase.updateStory(story);
        return new RedirectView("/story/" + updateStory.ID());
    }
}