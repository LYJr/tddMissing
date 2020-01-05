package mission.template;

import mission.dto.ProjecCreateDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectTemplateTest {

    private Random random = new Random();

    protected String title = "titleT";
    protected String explanation = "explanation";
    protected String name = "resian-";
    protected String emailId = "test";
    protected String email = "@gamil.com";
    protected String phone = "0101234123";
    protected LocalDateTime start =
            LocalDateTime.of(2019, 10, random.nextInt(12) + 1,
                    random.nextInt(23), random.nextInt(59), random.nextInt(59));
    protected LocalDateTime end =
            LocalDateTime.of(2020, 12, random.nextInt(12) + 1,
                    random.nextInt(23), random.nextInt(59), random.nextInt(59));
    protected long targetAmaont = 50000;

    protected ProjecCreateDto projecCreateDto =
            new ProjecCreateDto(title, explanation,
                    name, email, phone, start, end,
                    targetAmaont, null);

    protected List<ProjecCreateDto> createDto() {
        List<ProjecCreateDto> projecCreateDtos = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < 30; i++) {
            ProjecCreateDto p = new ProjecCreateDto(title + j, explanation + j,
                    name + j, emailId + j + email, phone + j,
                    LocalDateTime.of(2019, 10, random.nextInt(12) + 1,
                            random.nextInt(23), random.nextInt(59), random.nextInt(59)),
                    LocalDateTime.of(2020, 12, random.nextInt(12) + 1,
                            random.nextInt(23), random.nextInt(59), random.nextInt(59)),
                    targetAmaont, null);
            projecCreateDtos.add(p);
            j++;
        }
        return projecCreateDtos;
    }
}
