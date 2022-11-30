package mvc.mc.dh.service;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mvc.mc.dh.model.Story;
import mvc.mc.dh.port.in.StoryUseCase;
import mvc.mc.dh.port.out.StoryDbUseCase;

@RequiredArgsConstructor
public class StoryService implements StoryUseCase{

    @Getter
    private final StoryDbUseCase storyDbUseCase;
    @Override
    public List<Story> getStories() {
        return getStoryDbUseCase().getStories();
    }
    @Override
    public Story getStory(long id) {
        return getStoryDbUseCase().getStory(id);
    }
}
