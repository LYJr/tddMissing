package mission.controller;

import mission.common.CommonResponse;
import mission.domain.Project;
import mission.domain.ProjectRepository;
import mission.dto.ProjectDto;
import mission.service.ProjectService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    private static final Logger log = getLogger(ProjectControllerTest.class);

    private LocalDateTime start = LocalDateTime.of(2019, 1, 12, 3, 7, 13, 16);
    private LocalDateTime end = LocalDateTime.of(2019, 2, 12, 1, 3, 8, 16);
    private ProjectDto projectDto =
            new ProjectDto("Testing", "설명은 특문포함 ㅇㅈㅇ!",
                    "resian_1", "test@gmail.com", "01012341234", start, end,
                    (long) 50000);

    @After
    public void tearDown() throws Exception {
        projectRepository.deleteAll();
    }

    @Test
    public void saveTest() throws Exception {
        String url = "http://localhost:" + port + "/create";

        ResponseEntity<CommonResponse> responseEntity = restTemplate
                .postForEntity(url, projectDto, CommonResponse.class);

        log.debug("responsEntity : {} ", responseEntity.toString());

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Project> all = projectService.findAll();
        System.out.println("size: " + all.size());

        System.out.println(all.get(0));

        assertThat(all.get(0).getTitle()).isEqualTo(projectDto.getTitle());
        assertThat(all.get(0).getOriginatorEmail()).isEqualTo(projectDto.getOriginatorEmail());
    }
}