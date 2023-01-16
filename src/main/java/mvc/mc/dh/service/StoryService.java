package mvc.mc.dh.service;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mvc.mc.dh.model.Story;
import mvc.mc.dh.port.in.StoryUseCase;
import mvc.mc.dh.port.out.StoryDbUseCase;

@RequiredArgsConstructor
public class StoryService implements StoryUseCase{

    // By convention, we declare the getter for storyDbUseCase Interface
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
    @Override
    public Story addStory(Story story) {
        return getStoryDbUseCase().addStory(story);
    }
    @Override
    public Story updateStory(Story story) { return getStoryDbUseCase().updateStory(story); }
    @Override
    public boolean isAdmin(String email) {
        final List<String> admins = List.of("administrator@gmail.com","m.curon@outlook.com");
        if(admins.contains(email)){
            return true;
        }
        return false;
    }
}
