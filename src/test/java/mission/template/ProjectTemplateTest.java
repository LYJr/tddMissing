package mission.template;

import mission.dto.ProjecCreateDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectTemplateTest {

    protected LocalDateTime start = LocalDateTime.of(2019, 10, 11, 3, 7, 13);
    protected LocalDateTime end = LocalDateTime.of(2020, 12, 12, 1, 3, 8);

    protected LocalDateTime up = LocalDateTime.of(2020, 5, 1, 12, 0, 0, 0);
    protected LocalDateTime timeUp = LocalDateTime.of(2020, 1, 1, 18, 0, 0, 0);

    protected LocalDateTime down = LocalDateTime.of(2019, 12, 1, 12, 3, 17, 40);
    protected LocalDateTime timeDown = LocalDateTime.of(2020, 1, 1, 7, 0, 0, 0);

    protected LocalDateTime endTime = LocalDateTime.of(2020, 4, 1, 12, 3, 17, 40);

    protected long amountUp = 9000;
    protected long amountDown = 800;

    protected ProjecCreateDto projecCreateDto =
            new ProjecCreateDto("Testing", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_1", "test@gmail.com", "01012341234", start, end,
                    (long) 50000, null);

    protected List<ProjecCreateDto> createDto() {
        Random random = new Random();
        List<ProjecCreateDto> projecCreateDtos = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < 30; i++) {
            ProjecCreateDto p = new ProjecCreateDto("Testing", "설명은 특문포함 ㅇㅈㅇ!" + j,
                    "resian_" + j, "test" + j + "@gmail.com", "0101234111" + j, start,
                    LocalDateTime.of(2020, 1, random.nextInt(12)+1, random.nextInt(23), 0, 30),
                    (long) 50000, null);
            projecCreateDtos.add(p);
            j++;
        }
        return projecCreateDtos;
    }
}
