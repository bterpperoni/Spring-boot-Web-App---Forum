package mvc.mc.dh.adaptater.out;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "stories")
public class StoryJpaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "story_id")
    private int id;

    @Column(name = "story_title")
    private String title;

    @Column(name = "story_content")
    private String content;

    @Column(name = "story_creationDate")
    private LocalDateTime creationDate;

    @Column(name = "story_lastEditDate")
    private LocalDateTime lastEditDate;
}
