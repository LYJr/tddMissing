package mission.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import mission.domain.Project;
import mission.domain.State;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Size(max =  255)
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

//    @Column
//    //24시간 단위
//    private Data startTime;
//
//    @Column
//    //24시간 단위
//    private Data EndTime;

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
    private boolean show = true;

    //프로젝트 상태
    private State state;

    private void timeCheck() {

    }

    public ProjectDto(@NotNull @Size(max = 50) String title, @NotNull @Size(max = 255) String explanation, @NotNull @Size(max = 20) String originatorName, @NotNull @Email String originatorEmail, @NotNull String originatorPhone, @NotNull @Size(max = 100000000) Long targetAmount) {
        this.title = title;
        this.explanation = explanation;
        this.originatorName = originatorName;
        this.originatorEmail = originatorEmail;
        this.originatorPhone = originatorPhone;
        this.targetAmount = targetAmount;
    }

    public Project to_project () {
        return new Project(title, explanation, originatorName, originatorEmail, originatorPhone,
                targetAmount, fundingCount, fundingAmount, show, State.PREPARING);
    }
}
