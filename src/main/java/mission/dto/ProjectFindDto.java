package mission.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import mission.common.CommonState;
import mission.common.Regex;
import mission.domain.ProjectState;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFindDto {
    private UUID id;
    private String title;
    private String explanation;
    private String originatorName;
    private String originatorEmail;
    private String originatorPhone;

    @JsonFormat(pattern = Regex.DATE_FORMAT)
    private LocalDateTime startTime;

    @JsonFormat(pattern = Regex.DATE_FORMAT)
    private LocalDateTime endTime;

    private Long targetAmount;
    private Long fundingSponsor;
    private Long fundingAmount;
    private CommonState show;
    private ProjectState state;
}
