package mvc.mc.dh.ApplicationTest;

import mvc.mc.dh.adaptater.out.StoryMapper;
import mvc.mc.dh.adaptater.out.StoryPersistenceAdapter;
import mvc.mc.dh.adaptater.out.StoryRepository;
import mvc.mc.dh.model.Story;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class JpaAdapterTest {
    @Autowired
    private StoryRepository storyRepository;
    private StoryMapper storyMapper;
    private StoryPersistenceAdapter storyPersistenceAdapter;

    @Test
    void getStoriesList(){
        storyMapper = new StoryMapper();
        storyPersistenceAdapter = new StoryPersistenceAdapter(storyRepository, storyMapper);
        List<Story> stories;
        stories = storyPersistenceAdapter.getStories();

        // Values to be compared
        String firstLineTitle = "Test";
        String firstLineContent = "test";
        String secondLineTitle = "Test2";

        assertEquals(firstLineTitle, stories.get(0).TITLE());
        assertEquals(firstLineContent, stories.get(0).CONTENT());
        assertEquals(secondLineTitle, stories.get(1).TITLE());
    }
}
