package mission.dto;

import lombok.*;
import mission.common.CommonState;
import mission.common.Regex;
import mission.domain.Project;
import mission.domain.ProjectState;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private UUID id;

    @NotBlank(message = "프로젝트 이름을 작성해주세요.")
    @Size(max = 50)
    @Pattern(regexp = Regex.TITLE, message = "한글, 숫자, 영문만 사용 가능합니다.")
    private String title;

    @Size(max = 225)
    private String explanation;

    @NotNull(message = "창작자 이름을 작성해주세요.")
    @Size(max = 20)
    @Pattern(regexp = Regex.NAME, message = "한글, 숫자, 영문, _(underbar)만 사용 가능합니다.")
    private String originatorName;

    @NotBlank(message = "메일을 작성해주세요.")
    @Email(message = "메일의 양식을 지켜주세요.")
    private String originatorEmail;

    @NotBlank(message = "전화번호를 작성해주세요.")
    @Pattern(regexp = Regex.PHONE, message = "번호가 잘못되었습니다.")
    private String originatorPhone;

    @NotNull(message = "프로젝트 시작 시간을 입력해주세요.")
    private LocalDateTime startTime;

    @NotNull(message = "프로젝트 종료 시간을 입력해주세요.")
    private LocalDateTime endTime;

    @NotNull(message = "목표액을 입력해주세요.")
    @Range(max = Regex.AMOUNT, message = "금액이 맞지 않습니다.")
    private Long targetAmount;

    //프로젝트 생성시 초기 값 0
    @Range(max = Regex.SPONSOR, message = "후원자수가 맞지 않습니다.")
    private Long fundingSponsor;

    //프로젝트 생성시 초기 값 0
    @Range(max = Regex.AMOUNT, message = "금액이 맞지 않습니다.")
    private Long fundingAmount;

    //프로젝트 공개 여부
    private CommonState show;

    private ProjectState state;

    public ProjectDto(@NotBlank(message = "프로젝트 이름을 작성해주세요.") @Size(max = 50) @Pattern(regexp = Regex.TITLE, message = "한글, 숫자, 영문만 사용 가능합니다.") String title, @Size(max = 225) String explanation, @NotNull(message = "창작자 이름을 작성해주세요.") @Size(max = 20) @Pattern(regexp = Regex.NAME, message = "한글, 숫자, 영문, _(underbar)만 사용 가능합니다.") String originatorName, @NotBlank(message = "메일을 작성해주세요.") @Email(message = "메일의 양식을 지켜주세요.") String originatorEmail, @NotBlank(message = "전화번호를 작성해주세요.") @Pattern(regexp = Regex.PHONE, message = "번호가 잘못되었습니다.") String originatorPhone, @NotNull(message = "프로젝트 시작 시간을 입력해주세요.") LocalDateTime startTime, @NotNull(message = "프로젝트 종료 시간을 입력해주세요.") LocalDateTime endTime, @NotNull(message = "목표액을 입력해주세요.") @Range(max = 100000000) Long targetAmount, CommonState show) {
        this.title = title;
        this.explanation = explanation;
        this.originatorName = originatorName;
        this.originatorEmail = originatorEmail;
        this.originatorPhone = originatorPhone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.targetAmount = targetAmount;
        this.fundingSponsor = Regex.START_PROJECT;
        this.fundingAmount = Regex.START_PROJECT;
        this.show = show;
    }

    public Project toProject() {
        return new Project(title, explanation, originatorName, originatorEmail, originatorPhone,
                startTime, endTime, targetAmount, fundingSponsor, fundingAmount, show);
    }
}