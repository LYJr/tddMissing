package mission.service;

import mission.common.CommonState;
import mission.domain.Project;
import mission.domain.repository.ProjectRepository;
import mission.dto.ProjectDto;
import mission.dto.ProjectListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Page<ProjectListDto> availableProjectList(Pageable pageable) {
        return projectRepository.availablePageProjectList(pageable, CommonState.PERMIT);
    }

    public Project findById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 없습니다."));
    }

    public Project save (ProjectDto projectDto) {
        return projectRepository.save(projectDto.toProject());
    }

    @Transactional
    public Project update(UUID id, ProjectDto projectDto) throws IllegalArgumentException {
        Project project = findById(id);
        project = projectDto.toProject();
        return project;
    }

    @Transactional
    public UUID delect(UUID id) {
        Project project = findById(id);
        project.isDelect();
        return id;
    }

    @Transactional
    public Project sponsorship(UUID id, long fundingAmount) {
        Project project = findById(id);
        project.sponsorship(fundingAmount);
        return project;
    }
}
