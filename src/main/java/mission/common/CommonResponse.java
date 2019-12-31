package mission.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    public static CommonResponse failure (Object projectData, String message) {
        return CommonResponse.builder()
                .projectData(projectData)
                .message(message)
                .state(CommonState.FAILURE).build();
    }

    public static CommonResponse delect (Long id) {
        return CommonResponse.builder()
                .projectData(id)
                .message("삭제 되었습니다.")
                .state(CommonState.DELECT).build();
    }
}
