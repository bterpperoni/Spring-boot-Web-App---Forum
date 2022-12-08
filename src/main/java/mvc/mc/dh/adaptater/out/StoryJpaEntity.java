package mvc.mc.dh.adaptater.out;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "stories")
public class StoryJpaEntity {
    public StoryJpaEntity(){

    }
    public StoryJpaEntity(String title, String content, LocalDateTime creationDate, LocalDateTime lastEditDate){
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastEditDate = lastEditDate;
    }
    public StoryJpaEntity(long id, String title, String content, LocalDateTime creationDate, LocalDateTime lastEditDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.lastEditDate = lastEditDate;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "last_edit_date")
    private LocalDateTime lastEditDate;
}
