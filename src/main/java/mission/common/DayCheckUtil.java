package mission.common;

import mission.domain.Project;
import mission.domain.ProjectState;

import java.time.LocalDateTime;

public class DayCheckUtil {
//  준비중 : 현재시간 < 프로젝트 시작일

    //        진행중 : 프로젝트 시작일 ≤ 현재시간 < 프로젝트 마감일


    public static ProjectState proceedingCheck(LocalDateTime start, LocalDateTime end) {
        ProjectState state = ProjectState.PREPARING;
        LocalDateTime toDay = LocalDateTime.now();

//        state = getProjectState(start, end, state, toDay);

        return state;
    }


    public ProjectState fundingSuccessCheck(long targetAmount, long fundingAmount) {
        return null;
    }

}

