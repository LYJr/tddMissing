package mission.common;

public class CommonService {

    public static CommonResponse success (Object projectData) {
        return CommonResponse.builder()
                .projectData(projectData)
                .message("성공")
                .state(CommonState.SUCCESS).build();
    }

    public static CommonResponse failure () {
        return CommonResponse.builder()
                .message("실패")
                .state(CommonState.FAILURE).build();
    }

    public static CommonResponse delect (Long id) {
        return CommonResponse.builder()
                .projectData(id)
                .message("삭제 되었습니다.")
                .state(CommonState.DELECT).build();
    }

}
