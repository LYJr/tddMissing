package mission.common;

import mission.domain.ProjectState;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DayCheckUtilTest {

    @Test
    public void 준비중 () {

        LocalDateTime start = LocalDateTime.of(2020, 1,12,3,7,13, 16);
        LocalDateTime end = LocalDateTime.of(2020, 2,12,1,3,8, 16);

        assertThat(DayCheckUtil.proceedingCheck(start, end)).isEqualTo(ProjectState.PREPARING);
    }

    @Test
    public void 진행중 () {
        LocalDateTime start = LocalDateTime.of(2019, 12,12,3,7,13, 16);
        LocalDateTime end = LocalDateTime.of(2020, 2,12,1,3,8, 16);

        assertThat(DayCheckUtil.proceedingCheck(start, end)).isEqualTo(ProjectState.PROCEEDING);
    }

    @Test
    public void 종료 () {

    }

    @Test
    public void 성공 () {
        LocalDateTime start = LocalDateTime.of(2020, 1,12,3,7,13, 16);
        LocalDateTime end = LocalDateTime.of(2020, 2,12,1,3,8, 16);


        assertThat(DayCheckUtil.proceedingCheck(start, end)).isEqualTo(ProjectState.PROCEEDING);
    }

    @Test
    public void 실패 () {
        LocalDateTime start = LocalDateTime.of(2020, 1,12,3,7,13, 16);
        LocalDateTime end = LocalDateTime.of(2020, 2,12,1,3,8, 16);

        assertThat(DayCheckUtil.proceedingCheck(start, end)).isEqualTo(ProjectState.PROCEEDING);
    }
}