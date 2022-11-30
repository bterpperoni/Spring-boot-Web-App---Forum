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
            Get every JPA Entities from the Database, map them to models and return models list
         */
        List<StoryJpaEntity> storiesEntity = storyRepository.findAll();
        return storyMapper.mapStoryJpaToModel(storiesEntity);
    }

    @Override
    public Story getStory(long id) {
        /*
            Map the story found in database to a model, and return the model.
         */
        StoryJpaEntity storyEntity = storyRepository.findById(id).stream().findFirst().orElse(null);
        return storyMapper.mapStoryJpaToModel(storyEntity);
    }

    @Override
    public Story addStory(Story story) {
        /*
            Map the model to a JPA entity, save and then return the JPA Entity freshly saved
         */
        StoryJpaEntity storyJpaEntity = storyRepository.save(storyMapper.mapStoryModelToJpa(story));
        storyRepository.save(storyJpaEntity);
        return storyMapper.mapStoryJpaToModel(storyJpaEntity);
    }
}
