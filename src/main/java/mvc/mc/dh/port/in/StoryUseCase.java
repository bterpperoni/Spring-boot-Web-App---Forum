package mvc.mc.dh.port.in;

import java.util.List;
import mvc.mc.dh.model.Story;

public interface StoryUseCase {
    List<Story> getStories();
    Story getStory(long id);
    Story addStory(Story story);
    Story updateStory(Story story);
    boolean isAdmin(String email);

}
