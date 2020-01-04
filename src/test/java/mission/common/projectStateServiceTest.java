package mission.common;

import mission.template.ProjectTemplateTest;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class projectStateServiceTest extends ProjectTemplateTest {
    
//    @Test
//    public void 통합update_preparing() {
//        assertThat(super.projectStateCheck(new ProjectStateDto(down, endTime, super.targetAmountm, amountDown))).isEqualTo(ProjectState.PREPARING);
//        assertThat(super.projectStateCheck(new ProjectStateDto(timeDown, endTime, super.targetAmountm, amountDown))).isEqualTo(ProjectState.PREPARING);
//    }
//
//    @Test
//    public void 통합update_proceeding() {
//        assertThat(super.projectStateCheck(new ProjectStateDto(up, endTime, super.targetAmountm, amountDown))).isEqualTo(ProjectState.PROCEEDING);
//        assertThat(super.projectStateCheck(new ProjectStateDto(timeUp, endTime, super.targetAmountm, amountDown))).isEqualTo(ProjectState.PROCEEDING);
//    }
//
//    @Test
//    public void 통합update_success() {
//        assertThat(super.projectStateCheck(new ProjectStateDto(up, down, super.targetAmountm, amountUp))).isEqualTo(ProjectState.SUCCESS);
//        assertThat(super.projectStateCheck(new ProjectStateDto(up, timeDown, super.targetAmountm, amountUp))).isEqualTo(ProjectState.SUCCESS);
//        assertThat(super.projectStateCheck(new ProjectStateDto(up, timeDown, super.targetAmountm, super.targetAmountm))).isEqualTo(ProjectState.SUCCESS);
//        assertThat(super.projectStateCheck(new ProjectStateDto(up, super.now, super.targetAmountm, amountUp))).isEqualTo(ProjectState.SUCCESS);
//
//    }
//
//    @Test
//    public void 통합update_failure() {
//        assertThat(super.projectStateCheck(new ProjectStateDto(up, down, super.targetAmountm, amountDown))).isEqualTo(ProjectState.FAILURE);
//        assertThat(super.projectStateCheck(new ProjectStateDto(up, super.now, super.targetAmountm, amountDown))).isEqualTo(ProjectState.FAILURE);
//        assertThat(super.projectStateCheck(new ProjectStateDto(up, timeDown, super.targetAmountm, amountDown))).isEqualTo(ProjectState.FAILURE);
//
//    }
//
//    @Test
//    public void start_진행조건_ok() {
//        assertThat(super.startTimeCheck(timeUp)).isEqualTo(true);
//        assertThat(super.startTimeCheck(super.now)).isEqualTo(true);
//        assertThat(super.startTimeCheck(up)).isEqualTo(true);
//
//    }
//
//    @Test
//    public void start_진행조건_no() {
//        assertThat(super.startTimeCheck(down)).isEqualTo(false);
//    }
//
//    @Test
//    public void end_진행조건_ok() {
//        assertThat(super.endTimeCheck(down)).isEqualTo(true);
//        assertThat(super.endTimeCheck(timeDown)).isEqualTo(true);
//        assertThat(super.endTimeCheck(super.now)).isEqualTo(true);
//    }
//
//    @Test
//    public void end_진행조건_no() {
//        assertThat(super.endTimeCheck(up)).isEqualTo(false);
//        assertThat(super.endTimeCheck(timeUp)).isEqualTo(false);
//    }
//
//    @Test
//    public void 성공() {
//        assertThat(super.isSuccess(super.targetAmountm)).isEqualTo(ProjectState.SUCCESS);
//        assertThat(super.isSuccess(amountUp)).isEqualTo(ProjectState.SUCCESS);
//    }
//
//    @Test
//    public void 실패() {
//        assertThat(super.isSuccess(amountDown)).isEqualTo(ProjectState.FAILURE);
//    }
}