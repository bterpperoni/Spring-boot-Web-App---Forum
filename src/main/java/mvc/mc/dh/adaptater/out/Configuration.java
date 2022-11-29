package mvc.mc.dh.adaptater.out;

import mvc.mc.dh.port.out.StoryDbUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private StoryRepository storyRepository;
    private final StoryMapper storyMapper = new StoryMapper();

    @Bean
    StoryDbUseCase getStories(){
        return new StoryPersistenceAdapter(storyRepository, storyMapper);
    }
}
