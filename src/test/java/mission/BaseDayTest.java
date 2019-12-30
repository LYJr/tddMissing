package mission;

import mission.domain.ProjectState;
import mission.dto.ProjectStateDto;

import java.time.LocalDateTime;

/**
 * 현재 시간 고정을 위한 Test Code class
 */
public class BaseDayTest {

    protected LocalDateTime now = LocalDateTime.of(2020, 1, 1, 12, 0, 0, 0);
    protected long targetAmountm = 1000;

    public ProjectState preparing(LocalDateTime start) {
        return now.isAfter(start) ? ProjectState.PREPARING: ProjectState.PROCEEDING;
    }

    public boolean startTimeCheck(LocalDateTime start) {
        return start.isEqual(now) || start.isAfter(now);
    }

    public boolean endTimeCheck(LocalDateTime end) {
        return end.isBefore(now) || end.isEqual(now);
    }

    public ProjectState isSuccess(long fundingAmount) {
        return targetAmountm <= fundingAmount ? ProjectState.SUCCESS : ProjectState.FAILURE;
    }

    public ProjectState projectStateCheck(ProjectStateDto projectStateDto) {
        ProjectState projectState = ProjectState.FAILURE;

        if(!startTimeCheck(projectStateDto.getStartTime())) {
            projectState = ProjectState.PREPARING;
        }

        if(startTimeCheck(projectStateDto.getStartTime()) && !endTimeCheck(projectStateDto.getEndTime())) {
            projectState = ProjectState.PROCEEDING;
        }

        if(startTimeCheck(projectStateDto.getStartTime()) && endTimeCheck(projectStateDto.getEndTime())) {
            projectState = isSuccess(projectStateDto.getFundingAmount());
        }

        return projectState;
    }
}
