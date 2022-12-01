package mvc.mc.dh.adaptater.out;

import mvc.mc.dh.model.Story;

import java.util.ArrayList;
import java.util.List;

public class StoryMapper {
    /*
        Allow to transform a JPA Entity into a core entity and vice-versa
     */
    List<Story> mapStoryJpaToModel(List<StoryJpaEntity> storyEntities){
        List<Story> storiesList = new ArrayList<>();
        for (StoryJpaEntity entity: storyEntities){
            storiesList.add(new Story(entity.getId(), entity.getTitle(), entity.getContent(), entity.getCreationDate(), entity.getLastEditDate()));
        }
        return storiesList;
    }
    Story mapStoryJpaToModel(StoryJpaEntity storyEntity){
        Story story = new Story(storyEntity.getId(), storyEntity.getTitle(), storyEntity.getContent(), storyEntity.getCreationDate(), storyEntity.getLastEditDate());
        return story;
    }
    StoryJpaEntity mapStoryModelToJpa(Story story){
        StoryJpaEntity storyJpaEntity = new StoryJpaEntity(story.getTITLE(), story.getCONTENT(), story.getCREATIONDATE(), story.getLASTEDITDATE());
        return storyJpaEntity;
    }
}
