package mission.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import mission.common.CommonState;
import mission.domain.Project;
import mission.domain.ProjectState;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    //프로젝트 이름
    @NotNull
    @Size(max = 50)
    private String title;

    //설명
    @NotNull
    @Size(max = 225)
    private String explanation;

    //창작자 이름
    @NotNull
    @Size(max = 20)
    private String originatorName;

    @NotNull
    @Email
    private String originatorEmail;

    @NotNull
    private String originatorPhone;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    //목표액
    @NotNull
    @Size(max = 100000000)
    private Long targetAmount;

    //후원수
    @Size(max = 100000)
    private Long fundingCount;

    //후원액
    @Size(max = 100000000)
    private Long fundingAmount;

    //공개 여부
    private boolean show;

    //프로젝트 상태
    private ProjectState state;

    //프로젝트 허용
    private CommonState 허용;

    public ProjectDto(@NotNull @Size(max = 50) String title, @NotNull @Size(max = 225) String explanation, @NotNull @Size(max = 20) String originatorName, @NotNull @Email String originatorEmail, @NotNull String originatorPhone, @NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime, @NotNull @Size(max = 100000000) Long targetAmount) {
        this.title = title;
        this.explanation = explanation;
        this.originatorName = originatorName;
        this.originatorEmail = originatorEmail;
        this.originatorPhone = originatorPhone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.targetAmount = targetAmount;
        this.show = true;
        this.state = ProjectState.FAILURE;
        this.허용 = CommonState.PERMIT;
    }

    public ProjectDto(@NotNull @Size(max = 50) String title, @NotNull @Size(max = 225) String explanation, @NotNull @Size(max = 20) String originatorName, @NotNull @Email String originatorEmail, @NotNull String originatorPhone, @NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime, @NotNull @Size(max = 100000000) Long targetAmount, boolean show) {
        this.title = title;
        this.explanation = explanation;
        this.originatorName = originatorName;
        this.originatorEmail = originatorEmail;
        this.originatorPhone = originatorPhone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.targetAmount = targetAmount;
        this.show = show;
        this.show = true;
        this.state = ProjectState.FAILURE;
        this.허용 = CommonState.PERMIT;
    }

    public Project to_project() {
        return new Project(title, explanation, originatorName, originatorEmail, originatorPhone, startTime, endTime, targetAmount, show, state, 허용);
    }
}
