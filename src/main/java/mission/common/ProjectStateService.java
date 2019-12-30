package mission.common;

import mission.domain.ProjectState;
import mission.dto.ProjectStateDto;
import java.time.LocalDateTime;

public class ProjectStateService {

    public static ProjectState projectStateCheck(ProjectStateDto projectStateDto) {
        ProjectState projectState = ProjectState.FAILURE;

        if (!startTimeCheck(projectStateDto.getStartTime())) {
            projectState = ProjectState.PREPARING;
        }

        if (startTimeCheck(projectStateDto.getStartTime()) && !endTimeCheck(projectStateDto.getEndTime())) {
            projectState = ProjectState.PROCEEDING;
        }

        if (startTimeCheck(projectStateDto.getStartTime()) && endTimeCheck(projectStateDto.getEndTime())) {
            projectState = isSuccess(projectStateDto.getTargetAmount(), projectStateDto.getFundingAmount());
        }

        return projectState;
    }

    private static ProjectState isSuccess(long targetAmountm, long fundingAmount) {
        return targetAmountm <= fundingAmount ? ProjectState.SUCCESS : ProjectState.FAILURE;
    }

    private static boolean startTimeCheck(LocalDateTime start) {
        return start.isEqual(LocalDateTime.now()) || start.isAfter(LocalDateTime.now());
    }

    private static boolean endTimeCheck(LocalDateTime end) {
        return end.isBefore(LocalDateTime.now()) || end.isEqual(LocalDateTime.now());

    }
}

