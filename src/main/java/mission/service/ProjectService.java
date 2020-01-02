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

    public Project findByIdAndToDelete(UUID id) {
        return projectRepository.findByIdAndToDelete(id, CommonState.PERMIT);
    }

    public Project save(ProjectDto projectDto) {
        return projectRepository.save(projectDto.toProject());
    }

    @Transactional
    public Project update(UUID id, ProjectDto projectDto) throws IllegalArgumentException {
        Project project = findByIdAndToDelete(id);
        project.update(projectDto);
        return project;
    }

    @Transactional
    public UUID delete(UUID id) {
        Project project = findByIdAndToDelete(id);
        project.inputDelete();
        return id;
    }

    @Transactional
    public Project sponsorship(UUID id, long fundingAmount) {
        Project project = findByIdAndToDelete(id);
        project.sponsorship(fundingAmount);
        return project;
    }
}
