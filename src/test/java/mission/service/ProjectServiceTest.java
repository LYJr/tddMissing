package mission.service;

import mission.common.CommonState;
import mission.controller.ProjectControllerTest;
import mission.domain.Project;
import mission.domain.repository.ProjectRepository;
import mission.dto.ProjectListDto;
import mission.template.ProjectTemplateTest;
import org.junit.After;
import org.junit.Before;
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
public class ProjectServiceTest extends ProjectTemplateTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    private static final Logger log = getLogger(ProjectControllerTest.class);

    @After
    public void cleanup() {
        projectRepository.deleteAll();
    }

    @Before
    public void 저장() {
        projectService.save(projectDto);
        projectService.save(projectDto1);
        projectService.save(projectDto2);
        projectService.save(projectDto3);
        projectService.save(projectDto4);
        projectService.save(projectDto5);
        projectService.save(projectDto6);
    }

    @Test
    public void 저장_호출() {
        List<Project> projectList = projectService.findAll();

        Project project = projectList.get(0);
        System.out.println(project);

        assertThat(project.getTitle()).isEqualTo(projectDto.getTitle());
//        assertThat(project.getExplanation()).isEqualTo(projectDto.getExplanation());
    }

//    @Test
//    public void 단일테스트 () {
//        List<ProjectListDto> projectList = projectRepository.getProjectList(CommonState.PERMIT);
//
//        for (ProjectListDto projectListDto : projectList) {
//            System.out.println(projectListDto);
//        }
//    }

}