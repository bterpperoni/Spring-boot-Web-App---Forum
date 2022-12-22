package mvc.mc.dh.adaptater.in;

import lombok.RequiredArgsConstructor;
import mvc.mc.dh.model.Story;
import mvc.mc.dh.port.in.StoryUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final StoryUseCase storyUseCase;

    @GetMapping("/")
    public String index(Model model, Authentication auth, @AuthenticationPrincipal OidcUser principal) {
        if(auth == null || !isAdmin(principal.getClaims().get("name"))){ return "redirect:/oauth2/authorization/auth0"; }
        // The name in "" will be used by thymeleaf to provide view
        List<Story> storyList;
        storyList = storyUseCase.getStories();
        model.addAttribute("storyList", storyList);
        return "adminStoryList";
    }


    private boolean isAdmin(Object name){
        try{
            name = name.toString();
        }
        catch(Exception e){
            return false;
        }
        return getAdmins().contains(name);
    }

    private List<String> getAdmins(){
        List<String> admins = Arrays.asList("administrator@gmail.com");
        return admins;
    }
}
