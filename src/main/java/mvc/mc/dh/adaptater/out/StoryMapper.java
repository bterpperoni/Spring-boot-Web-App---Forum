package mvc.mc.dh.adaptater.out;

import mvc.mc.dh.model.Story;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class StoryMapper {
    /*
        Allow to transform a JPA Entity into a core entity
        Contains only one method overloaded
     */
    List<Story> mapToDomainEntity(List<StoryJpaEntity> storyEntities){
        List<Story> storiesList = new ArrayList<>();
        for (StoryJpaEntity entity: storyEntities){
            storiesList.add(new Story(entity.getId(), entity.getTitle(), entity.getContent(), entity.getCreationDate(), entity.getLastEditDate()));
        }
        return storiesList;
    }
    Story mapToDomainEntity(StoryJpaEntity storyEntity){
        Story story = new Story(storyEntity.getId(), storyEntity.getTitle(), storyEntity.getContent(), storyEntity.getCreationDate(), storyEntity.getLastEditDate());
        return story;
    }
}
