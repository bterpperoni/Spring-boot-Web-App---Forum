package mvc.mc.dh.service;

import java.util.List;

import mvc.mc.dh.model.Story;
import mvc.mc.dh.port.in.StoryUseCase;
import mvc.mc.dh.port.out.StoryDbUseCase;

public class StoryService implements StoryUseCase{

    StoryDbUseCase storyDbUseCase;
    @Override
    public List<Story> getStories() {
        return storyDbUseCase.getStories();
    }

    @Override
    public Story getStory(int id) {
        return storyDbUseCase.getStory(id);
    }
    
}
