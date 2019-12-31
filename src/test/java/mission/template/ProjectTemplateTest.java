package mission.template;

import mission.common.CommonState;
import mission.dto.ProjectDto;

import java.time.LocalDateTime;

public class ProjectTemplateTest {
    protected LocalDateTime start = LocalDateTime.of(2019, 10, 11, 3, 7, 13);
    protected LocalDateTime end = LocalDateTime.of(2020, 12, 12, 1, 3, 8);
    protected ProjectDto projectDto =
            new ProjectDto("Testing", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_1", "test@gmail.com", "01012341234", start, end,
                    (long) 50000);
    protected ProjectDto projectDto1 =
            new ProjectDto("Testing", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_2", "test2@gmail.com", "0101213884", start, end,
                    (long) 50000, CommonState.DELECT);
    protected ProjectDto projectDto2 =
            new ProjectDto("Testing", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_3", "test3@gmail.com", "01012341233", start, end,
                    (long) 50000, CommonState.PERMIT);
    protected ProjectDto projectDto3 =
            new ProjectDto("Testing", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_4", "test4@gmail.com", "01012341231", start, end,
                    (long) 50000, CommonState.DELECT);
    protected ProjectDto projectDto4 =
            new ProjectDto("Testing", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_5", "test5@gmail.com", "01012341239", start, end,
                    (long) 50000, CommonState.PERMIT);
    protected ProjectDto projectDto5 =
            new ProjectDto("Testing", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_6", "test6@gmail.com", "01012341230", start, end,
                    (long) 50000, CommonState.DELECT);
    protected ProjectDto projectDto6 =
            new ProjectDto("Testing8", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_7", "test8@gmail.com", "01012341238", start, end,
                    (long) 50000, CommonState.PERMIT);


    protected LocalDateTime up = LocalDateTime.of(2020, 5, 1, 12, 0, 0, 0);
    protected LocalDateTime timeUp = LocalDateTime.of(2020, 1, 1, 18, 0, 0, 0);

    protected LocalDateTime down = LocalDateTime.of(2019, 12, 1, 12, 3, 17, 40);
    protected LocalDateTime timeDown = LocalDateTime.of(2020, 1, 1, 7, 0, 0, 0);

    protected LocalDateTime endTime = LocalDateTime.of(2020, 4, 1, 12, 3, 17, 40);

    protected long amountUp = 9000;
    protected long amountDown = 800;
}
