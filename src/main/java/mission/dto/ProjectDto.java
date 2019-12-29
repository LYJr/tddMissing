package mission.dto;

import lombok.*;
import mission.common.CommonState;
import mission.common.Regex;
import mission.domain.Project;
import mission.domain.ProjectState;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class ProjectDto {

    @NotBlank(message = "프로젝트 이름을 작성해주세요.")
    @Size(max = 50)
    @Pattern(regexp = Regex.TITLE, message = "한글, 숫자, 영문만 사용 가능합니다.")
    private String title;

//    @Size(max = 225)
//    private String explanation;
//
//    @NotNull(message = "창작자 이름을 작성해주세요.")
//    @Size(max = 20)
//    @Pattern(regexp = Regex.NAME, message = "한글, 숫자, 영문, _(underbar)만 사용 가능합니다.")
//    private String originatorName;
//
//    @NotBlank(message = "메일을 작성해주세요.")
//    @Email(message = "메일의 양식을 지켜주세요.")
//    private String originatorEmail;

//    @NotBlank(message = "전화번호를 작성해주세요.")
//    @Pattern(regexp = Regex.PHONE, message = "양식이 잘못되었습니다.")
//    private String originatorPhone;
//
//    @NotBlank(message = "프로젝트 시작 시간을 입력해주세요.")
//    private LocalDateTime startTime;
//
//    @NotBlank(message = "프로젝트 종료 시간을 입력해주세요.")
//    private LocalDateTime endTime;
//
//    //목표액
//    @NotBlank(message = "목표액을 입력해주세요.")
//    @Size(max = 100000000)
//    private Long targetAmount;
//
//    //후원수
//    @Size(max = 100000)
//    private Long fundingCount;
//
//    //후원액
//    @Size(max = 100000000)
//    private Long fundingAmount;
//
//    //공개 여부
//    private boolean show;
//
//    //프로젝트 상태
//    private ProjectState state;
//
//    private CommonState isDelect;


    public ProjectDto(@NotBlank(message = "프로젝트 이름을 작성해주세요.") @Size(max = 50) @Pattern(regexp = Regex.TITLE, message = "한글, 숫자, 영문만 사용 가능합니다.") String title) {
        this.title = title;
    }

    public Project to_project() {
        return new Project(title);
    }
}
