package mission.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.UUID;

@Getter
@Builder
public class CommonResponse<T> {
    private T projectData;
    private String message;
    private CommonState state;

    public static CommonResponse success (Object projectData) {
        return CommonResponse.builder()
                .projectData(projectData)
                .message("성공")
                .state(CommonState.SUCCESS).build();
    }

    public static CommonResponse failure(BindingResult bindingResult) {
        return CommonResponse.builder()
                .projectData(bindingField(bindingResult))
                .message(bindingMessage(bindingResult))
                .state(CommonState.FAILURE).build();
    }

    public static CommonResponse delete (UUID id) {
        return CommonResponse.builder()
                .projectData(id)
                .message("삭제 되었습니다.")
                .state(CommonState.DELECT).build();
    }

    private static String bindingField(BindingResult bindingResult) {
        return bindingResult.getFieldError().getField();
    }

    private static String bindingMessage(BindingResult bindingResult) {
        return bindingResult.getFieldError().getDefaultMessage();
    }
}
