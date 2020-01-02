package mission.service;

import mission.common.CommonState;
import mission.controller.ProjectControllerTest;
import mission.domain.Project;
import mission.domain.repository.ProjectRepository;
import mission.dto.ProjectDto;
import mission.dto.ProjectListDto;
import mission.template.ProjectTemplateTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

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
        List<ProjectDto> projectDtos = createDto();

        long i = 1000;
        long j = 0;
        for (ProjectDto dto : projectDtos) {
            dto.setFundingSponsor(j);
            dto.setFundingAmount(i);
            projectService.save(dto);
            i = i*2;
            j++;
        }
    }

    @Test
    public void 저장_호출() {
        List<Project> projectList = projectService.findAll();
        Project project = projectList.get(0);
        assertThat(project.getTitle()).isEqualTo(projectDto.getTitle());
    }

    @Test
    public void oneSelect() {
        List<Project> all = projectService.findAll();

        Project project = projectService.findByIdAndToDelete(all.get(0).getId());
        System.out.println(project);
    }

    @Test
    public void pageTest() {
        String sort = "endTime";
        Pageable pageable = PageRequest.of(2, 10, Sort.Direction.DESC, sort);

        Page<ProjectListDto> projectList = projectService.availableProjectList(pageable);
        for (ProjectListDto projectListDto : projectList) {
            System.out.println(projectListDto);
            System.out.println();
        }
    }

    @Test
    public void 삭제() {
        projectService.save(projectDto);
        List<Project> find = projectService.findAll();
        projectService.delete(find.get(0).getId());

        Project p = projectRepository.findById(find.get(0).getId()).get();
        assertThat(p.getToDelete()).isEqualTo(CommonState.DELECT);
    }

    @Test
    public void 펀딩() {
        List<Project> find = projectService.findAll();
        Project project =projectService.sponsorship(find.get(0).getId(), 3000);

       assertThat(project.getFundingAmount()).isEqualTo(4000);
    }

}