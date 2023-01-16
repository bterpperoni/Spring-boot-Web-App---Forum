package mvc.mc.dh.adaptater.out;

import mvc.mc.dh.model.Story;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StoryMapper {

    /*
        Allow to transform a JPA Entity into a core entity and vice-versa
     */
    List<Story> mapStoryJpaToModel(List<StoryJpaEntity> storyEntities){
        List<Story> storiesList = new ArrayList<>();
        for (StoryJpaEntity entity: storyEntities){
            storiesList.add(new Story(entity.getId(), entity.getTitle(), entity.getContent(), entity.getCreationDate(), entity.getLastEditDate(), entity.isVisible()));
        }
        return storiesList;
    }
    Story mapStoryJpaToModel(StoryJpaEntity storyEntity){
        if (storyEntity == null){ return null; }
        Story story = new Story(storyEntity.getId(), storyEntity.getTitle(), storyEntity.getContent(), storyEntity.getCreationDate(), storyEntity.getLastEditDate(), storyEntity.isVisible());
        return story;
    }
    StoryJpaEntity mapStoryModelToJpa(Story story, boolean createNewId){
        /*
            Return a JPA Entity from a model
            Boolean createNewId used to specify if it's a new entry or an update
         */
        StoryJpaEntity storyJpaEntity;
        if (createNewId){
            storyJpaEntity = new StoryJpaEntity(story.ID(),story.TITLE(), story.CONTENT(), LocalDateTime.now(), LocalDateTime.now(), story.visible());
        }
        else{
            storyJpaEntity = new StoryJpaEntity(story.ID(), story.TITLE(), story.CONTENT(), story.CREATIONDATE(), LocalDateTime.now(), story.visible());
        }
        return storyJpaEntity;
    }


}
