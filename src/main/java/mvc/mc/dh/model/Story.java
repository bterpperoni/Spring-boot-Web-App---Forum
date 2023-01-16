package mvc.mc.dh.model;

import java.time.LocalDateTime;
import lombok.Getter;

public record Story(@Getter long ID, @Getter String TITLE, @Getter String CONTENT, @Getter LocalDateTime CREATIONDATE, @Getter LocalDateTime LASTEDITDATE, @Getter boolean visible) {
}
