package mvc.mc.dh.adaptater.in;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }

}