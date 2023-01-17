package mvc.mc.dh.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

@ComponentScan
public class LogModel {

    @Getter @Setter private String logName;
    @Getter @Setter private String logPath;
    @Getter @Setter private LocalDateTime logDate;

    public LogModel(String logName, String logPath, LocalDateTime logDate) {
        logName = this.logName;
        logPath = this.logPath;
        logDate = this.logDate;
    }
}
