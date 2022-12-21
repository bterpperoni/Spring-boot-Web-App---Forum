package mvc.mc.dh.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;

@RequiredArgsConstructor
public class Story {

    @Getter
    private final long ID;
    @Getter
    private final String TITLE;
    @Getter
    private final String CONTENT;
    @Getter
    private final LocalDateTime CREATIONDATE;
    @Getter
    private final LocalDateTime LASTEDITDATE;
}
