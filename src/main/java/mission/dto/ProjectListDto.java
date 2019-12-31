package mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mission.domain.ProjectState;
import java.time.LocalDateTime;

//프로젝트 List로 보여줄 경우
//프로젝트 제목, 창작자 이름, 목표액, 후원수, 후원액, 프로젝트 상태, 시작일, 마감일
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectListDto {
    private String titlel;
    private String originatorName;
    private Long targetAmount;
    private Long fundingSponsor;
    private Long fundingAmount;
    private ProjectState state;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
