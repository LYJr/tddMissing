package mission.controller;

import mission.BaseTest;
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

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerTest extends BaseTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    private static final Logger log = getLogger(ProjectControllerTest.class);

    private LocalDateTime start = LocalDateTime.of(2019, 1,12,0,0,0);
    private LocalDateTime end = LocalDateTime.of(2019, 2,12,1,3,8);
    private ProjectDto projectDto =
            new ProjectDto("Testing");


    @After
    public void tearDown() throws Exception {
        projectRepository.deleteAll();
    }

    @Test
    public void 정상테스트 (){
        ProjectDto projectDto = new ProjectDto("dㅇㄻㄹㅇ!!!!!!");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/create", projectDto, String.class);

        System.out.println(projectDto.toString());
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void saveTest() throws Exception {
        String url = "http://localhost:" + port + "/create";

        ResponseEntity<CommonResponse> responseEntity = restTemplate
                .postForEntity(url, projectDto, CommonResponse.class);

        log.debug("responsEntity : {} ", responseEntity.toString());

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Project> all = projectRepository.findAll();

        assertThat(all.get(0).getTitle()).isEqualTo(projectDto.getTitle());
//        assertThat(all.get(0).getOriginatorEmail()).isEqualTo(projectDto.getOriginatorEmail());
    }

}