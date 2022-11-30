package mvc.mc.dh.port.out;

import mvc.mc.dh.model.Story;

import java.util.List;

public interface StoryDbUseCase {
    public List<Story> getStories();
    public Story getStory(long id);
}
