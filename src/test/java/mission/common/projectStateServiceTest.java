package mission.common;

import mission.BaseDayTest;
import mission.domain.ProjectState;
import mission.dto.ProjectStateDto;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class projectStateServiceTest extends BaseDayTest {

    private LocalDateTime up = LocalDateTime.of(2020, 5, 1, 12, 0, 0, 0);
    private LocalDateTime timeUp = LocalDateTime.of(2020, 1, 1, 18, 0, 0, 0);

    private LocalDateTime down = LocalDateTime.of(2019, 12, 1, 12, 3, 17, 40);
    private LocalDateTime timeDown = LocalDateTime.of(2020, 1, 1, 7, 0, 0, 0);

    private LocalDateTime endTime = LocalDateTime.of(2020, 4, 1, 12, 3, 17, 40);

    private long amountUp = 9000;
    private long amountDown = 800;

    @Test
    public void 통합update_preparing() {
        assertThat(super.projectStateCheck(new ProjectStateDto(down, endTime, super.targetAmountm, amountDown))).isEqualTo(ProjectState.PREPARING);
        assertThat(super.projectStateCheck(new ProjectStateDto(timeDown, endTime, super.targetAmountm, amountDown))).isEqualTo(ProjectState.PREPARING);
    }

    @Test
    public void 통합update_proceeding() {
        assertThat(super.projectStateCheck(new ProjectStateDto(up, endTime, super.targetAmountm, amountDown))).isEqualTo(ProjectState.PROCEEDING);
        assertThat(super.projectStateCheck(new ProjectStateDto(timeUp, endTime, super.targetAmountm, amountDown))).isEqualTo(ProjectState.PROCEEDING);
    }

    @Test
    public void 통합update_success() {
        assertThat(super.projectStateCheck(new ProjectStateDto(up, down, super.targetAmountm, amountUp))).isEqualTo(ProjectState.SUCCESS);
        assertThat(super.projectStateCheck(new ProjectStateDto(up, timeDown, super.targetAmountm, amountUp))).isEqualTo(ProjectState.SUCCESS);
        assertThat(super.projectStateCheck(new ProjectStateDto(up, timeDown, super.targetAmountm, super.targetAmountm))).isEqualTo(ProjectState.SUCCESS);
        assertThat(super.projectStateCheck(new ProjectStateDto(up, super.now, super.targetAmountm, amountUp))).isEqualTo(ProjectState.SUCCESS);

    }

    @Test
    public void 통합update_failure() {
        assertThat(super.projectStateCheck(new ProjectStateDto(up, down, super.targetAmountm, amountDown))).isEqualTo(ProjectState.FAILURE);
        assertThat(super.projectStateCheck(new ProjectStateDto(up, super.now, super.targetAmountm, amountDown))).isEqualTo(ProjectState.FAILURE);
        assertThat(super.projectStateCheck(new ProjectStateDto(up, timeDown, super.targetAmountm, amountDown))).isEqualTo(ProjectState.FAILURE);

    }

    @Test
    public void start_진행조건_ok() {
        assertThat(super.startTimeCheck(timeUp)).isEqualTo(true);
        assertThat(super.startTimeCheck(super.now)).isEqualTo(true);
        assertThat(super.startTimeCheck(up)).isEqualTo(true);

    }

    @Test
    public void start_진행조건_no() {
        assertThat(super.startTimeCheck(down)).isEqualTo(false);
    }

    @Test
    public void end_진행조건_ok() {
        assertThat(super.endTimeCheck(down)).isEqualTo(true);
        assertThat(super.endTimeCheck(timeDown)).isEqualTo(true);
        assertThat(super.endTimeCheck(super.now)).isEqualTo(true);
    }

    @Test
    public void end_진행조건_no() {
        assertThat(super.endTimeCheck(up)).isEqualTo(false);
        assertThat(super.endTimeCheck(timeUp)).isEqualTo(false);
    }

    @Test
    public void 준비중_ok() {
        assertThat(super.preparing(down)).isEqualTo(ProjectState.PREPARING);
    }

    @Test
    public void 진행중_no() {
        assertThat(super.preparing(super.now)).isEqualTo(ProjectState.PROCEEDING);
        assertThat(super.preparing(timeUp)).isEqualTo(ProjectState.PROCEEDING);
        assertThat(super.preparing(up)).isEqualTo(ProjectState.PROCEEDING);
    }

    @Test
    public void 성공() {
        assertThat(super.isSuccess(super.targetAmountm)).isEqualTo(ProjectState.SUCCESS);
        assertThat(super.isSuccess(amountUp)).isEqualTo(ProjectState.SUCCESS);
    }

    @Test
    public void 실패() {
        assertThat(super.isSuccess(amountDown)).isEqualTo(ProjectState.FAILURE);
    }
}