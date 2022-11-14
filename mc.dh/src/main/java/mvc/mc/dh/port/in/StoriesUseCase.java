package mvc.mc.dh.port.in;

import java.util.List;
import mvc.mc.dh.model.Story;

public interface StoriesUseCase {
    List<Story> getStories();
    Story getStory(int id);
}
