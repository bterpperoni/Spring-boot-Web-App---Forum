package mvc.mc.dh.adaptater.in;

import mvc.mc.dh.model.LogModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LogController {

    @GetMapping("/get")
    public Iterable<LogModel> listLog(){
        final List<LogModel> list = new ArrayList();
        final LogModel lgm = new LogModel("test1","test2", LocalDateTime.now());
        list.add(lgm);
        return list;
    }
}
