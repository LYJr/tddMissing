package mission.service;

import mission.common.CommonState;
import mission.domain.Project;
import mission.domain.repository.ProjectRepository;
import mission.dto.ProjecCreateDto;
import mission.dto.ProjectFindDto;
import mission.dto.ProjectListDto;
import mission.template.ProjectTemplateTest;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest extends ProjectTemplateTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @After
    public void cleanup() {
        projectRepository.deleteAll();
    }

    public void listSave() {
        List<ProjecCreateDto> projecCreateDtos = createDto();

        long i = 1000;
        long j = 0;
        for (ProjecCreateDto dto : projecCreateDtos) {
            dto.setFundingSponsor(j);
            dto.setFundingAmount(i);
            projectService.save(dto);
            i = i * 2;
            j++;
        }
    }

    public ProjectFindDto saveOne() {
        return projectService.save(projecCreateDto);
    }

    @Test
    public void save_findAll_test() {
        ProjectFindDto projectFindDto = saveOne();
        List<Project> projectList = projectService.findAll();
        Project project = projectList.get(0);

        assertThat(project.getTitle()).isEqualTo(projectFindDto.getTitle());
    }

    @Test
    public void findOne() {
        ProjectFindDto projectFindDto = saveOne();
        Project project = projectService.findByIdAndToDelete(projectFindDto.getId());

        assertThat(project.getTitle()).isEqualTo(projectFindDto.getTitle());
    }

    /**
     * Sort condition : startTime, endTime, targetAmount, fundingAmount
     */
    @Test
    public void pageFind() {
        listSave();

        String sort = "endTime";
        Pageable pageable = PageRequest.of(2, 10, Sort.Direction.DESC, sort);
        Page<ProjectListDto> projectList = projectService.availableProjectList(pageable);

        assertThat(projectList.getSize()).isEqualTo(10);
    }

    @Test
    public void deleteInput() {
        ProjectFindDto projectFindDto = saveOne();
        projectService.delete(projectFindDto.getId());
        Project project = projectRepository.findById(projectFindDto.getId()).get();

        assertThat(project.getToDelete()).isEqualTo(CommonState.DELECT);
    }

    @Test
    public void sponsorshipInput() {
        ProjectFindDto projectFindDto = saveOne();
        ProjectFindDto sponsorship = projectService.sponsorship(projectFindDto.getId(), 3000);

        assertThat(sponsorship.getFundingAmount()).isEqualTo(3000);
    }
}