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
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;

    @Column(name = "lastEditDate")
    private LocalDateTime lastEditDate;
}
