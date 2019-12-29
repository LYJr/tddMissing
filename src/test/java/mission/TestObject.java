package mission;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mission.common.Regex;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
@ToString
public class TestObject {

    @NotBlank(message = "프로젝트 이름을 작성해주세요.")
    @Size(max = 50)
    @Pattern(regexp = Regex.TITLE, message = "한글, 숫자, 영문만 사용 가능합니다.")
    private String title;

    @NotNull(message = "창작자 이름을 작성해주세요.")
    @Size(max = 20)
    @Pattern(regexp = Regex.NAME, message = "한글, 숫자, 영문, _(underbar)만 사용 가능합니다.")
    private String name;

    @NotBlank(message = "메일을 작성해주세요.")
    @Email(message = "메일의 양식을 지켜주세요.")
    private String email;

    @NotBlank(message = "전화번호를 작성해주세요.")
    @Pattern(regexp = Regex.PHONE, message = "양식이 잘못되었습니다.")
    private String phone;


}
