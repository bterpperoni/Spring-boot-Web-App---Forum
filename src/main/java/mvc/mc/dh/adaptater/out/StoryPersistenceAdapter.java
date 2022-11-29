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
        List<StoryJpaEntity> storiesEntity = storyRepository.findAll();
        return storyMapper.mapToDomainEntity(storiesEntity);
    }

    @Override
    public Story getStory(int id) {
        return null;
    }
}
