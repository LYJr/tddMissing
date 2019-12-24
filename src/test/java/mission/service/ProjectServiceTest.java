package mission.service;

import mission.controller.ProjectControllerTest;
import mission.domain.Project;
import mission.domain.ProjectRepository;
import mission.dto.ProjectDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    private ProjectDto projectDto =
            new ProjectDto("제목", "설명", "이름", "email@a.a", "0000000", (long)3000);

    @After
    public void cleanup(){
        projectRepository.deleteAll();
    }

    @Test
    public void 저장_호출() {
        projectService.save(projectDto);
        List<Project> projectList = projectService.findAll();

        Project project = projectList.get(0);

        assertThat(project.getTitle()).isEqualTo(projectDto.getTitle());
        assertThat(project.getExplanation()).isEqualTo(projectDto.getExplanation());
    }
}