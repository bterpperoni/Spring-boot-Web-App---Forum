package mvc.mc.dh.adaptater.out;

import lombok.RequiredArgsConstructor;
import mvc.mc.dh.model.Story;
import mvc.mc.dh.port.out.StoryDbUseCase;

import java.util.List;
@RequiredArgsConstructor
public class StoryPersistenceAdapter implements StoryDbUseCase {
    private final StoryRepository storyRepository;
    private final StoryMapper storyMapper;

    @Override
    public List<Story> getStories() {
        /*
            Return a list containing all the stories in the database
         */
        List<StoryJpaEntity> storiesEntity = storyRepository.findAll();
        return storyMapper.mapStoryJpaToModel(storiesEntity);
    }

    @Override
    public Story getStory(long id) {
        /*
            Return a specific story by providing an id
         */
        StoryJpaEntity storyEntity = storyRepository.findById(id).stream().findFirst().orElse(null);
        return storyMapper.mapStoryJpaToModel(storyEntity);
    }

    @Override
    public Story addStory(Story story) {
        /*
            Map the model to a JPA entity, save and then return the JPA Entity freshly saved as a model
         */
        StoryJpaEntity storyJpaEntity = storyRepository.save(storyMapper.mapStoryModelToJpa(story, true));
        return storyMapper.mapStoryJpaToModel(storyJpaEntity);
    }

    @Override
    public Story updateStory(Story story) {
        /*
            Map the existing model to a JPA entity, save it and return the JPA Entity as a model
         */
        StoryJpaEntity storyJpaEntity = storyRepository.save(storyMapper.mapStoryModelToJpa(story, false));
        return storyMapper.mapStoryJpaToModel(storyJpaEntity);
    }
    @Override
    public boolean removeStory(long id) {
        /*
            Check if the story exists, then try to delete it
            Return True only if the story was existing and has been deleted
            Return False if the story does not exist or has not been deleted
         */
        if (getStory(id) == null){ return false; }
        storyRepository.deleteById(id);
        if(getStory(id) == null){ return true; }
        return false;
    }
}
