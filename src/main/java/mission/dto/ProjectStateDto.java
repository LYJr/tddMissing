package mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mission.domain.ProjectState;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectStateDto {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long targetAmount;
    private Long fundingAmount;

    public ProjectStateDto(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ProjectState progressCheck() {

    }
}
