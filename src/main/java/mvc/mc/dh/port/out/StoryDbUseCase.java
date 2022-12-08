package mvc.mc.dh.port.out;

import mvc.mc.dh.model.Story;

import java.util.List;

public interface StoryDbUseCase {
    List<Story> getStories();
    Story getStory(long id);
    Story addStory(Story story);
    Story updateStory(Story story);
}
