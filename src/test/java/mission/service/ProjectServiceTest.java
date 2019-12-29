package mission.service;

import mission.controller.ProjectControllerTest;
import mission.domain.Project;
import mission.domain.ProjectRepository;
import mission.dto.ProjectDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    private static final Logger log = getLogger(ProjectControllerTest.class);

    private LocalDateTime start = LocalDateTime.of(2019, 1,12,0,0,0);
    private LocalDateTime end = LocalDateTime.of(2019, 2,12,1,3,8);
    private ProjectDto projectDto =
            new ProjectDto("제목");

    @After
    public void cleanup(){
        projectRepository.deleteAll();
    }

    @Before
    public void 저장() {
        projectService.save(projectDto);
    }

    @Test
    public void 저장_호출() {
        List<Project> projectList = projectService.findAll();

        Project project = projectList.get(0);
        System.out.println(project);

        assertThat(project.getTitle()).isEqualTo(projectDto.getTitle());
//        assertThat(project.getExplanation()).isEqualTo(projectDto.getExplanation());
    }

    @Test
    public void 단일_호출() {
        Project project = projectService.findById(1);
        System.out.println(project);
    }
}