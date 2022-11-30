package mvc.mc.dh;

import mvc.mc.dh.adaptater.out.StoryMapper;
import mvc.mc.dh.adaptater.out.StoryPersistenceAdapter;
import mvc.mc.dh.adaptater.out.StoryRepository;
import mvc.mc.dh.port.in.StoryUseCase;
import mvc.mc.dh.port.out.StoryDbUseCase;
import mvc.mc.dh.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private StoryRepository storyRepository;
    private StoryMapper storyMapper = new StoryMapper();
    private StoryPersistenceAdapter storyPersistenceAdapter;

    @Bean
    public StoryDbUseCase getStoryDbUseCase(){
        return new StoryPersistenceAdapter(storyRepository, storyMapper);
    }
    @Bean
    public StoryUseCase getStoryUseCase(){
        storyPersistenceAdapter = new StoryPersistenceAdapter(storyRepository, storyMapper);
        return new StoryService(storyPersistenceAdapter);
    }
}
