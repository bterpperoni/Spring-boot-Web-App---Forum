package mvc.mc.dh.model;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Story {
    @Getter
    private final int id;
    @Getter
    private final String title;
    @Getter
    private final String content;
    @Getter
    private final Date creationDate;
    @Getter
    private final Date lastEditDate;

}
