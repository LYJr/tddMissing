package mission.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mission.common.Regex;
import mission.domain.ProjectState;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectListDto {
    private UUID id;
    private String title;
    private String originatorName;
    private Long targetAmount;
    private Long fundingSponsor;
    private Long fundingAmount;
    private ProjectState state;

    @JsonFormat(pattern = Regex.DATE_FORMAT)
    private LocalDateTime startTime;

    @JsonFormat(pattern = Regex.DATE_FORMAT)
    private LocalDateTime endTime;
}
