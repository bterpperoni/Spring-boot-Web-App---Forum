package mvc.mc.dh.adaptater.out;

import mvc.mc.dh.model.Story;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class StoryMapper {
    List<Story> mapToDomainEntity(List<StoryJpaEntity> stories){
        List<Story> storiesList = new ArrayList<>();

        for (StoryJpaEntity entity: stories){
            storiesList.add(new Story(entity.getId(), entity.getTitle(), entity.getContent(), entity.getCreationDate(), entity.getLastEditDate()));
        }
        return storiesList;
    }
}
