package mission.service;

import mission.common.CommonState;
import mission.domain.Project;
import mission.domain.repository.ProjectRepository;
import mission.dto.ProjecCreateDto;
import mission.dto.ProjectFindDto;
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

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Page<ProjectListDto> availableProjectList(Pageable pageable) {
        return projectRepository.availablePageProjectList(pageable, CommonState.PERMIT);
    }

    public Project findByIdAndToDelete(UUID id) throws IllegalArgumentException {
        try {
            return projectRepository.findByIdAndToDelete(id, CommonState.PERMIT);
        } catch (Exception e) {
            throw new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다." + id);
        }
    }

    public ProjectFindDto save(ProjecCreateDto projecCreateDto) {
        return projectRepository.save(projecCreateDto.toProject()).toProjectFindDto();
    }

    @Transactional
    public ProjectFindDto update(UUID id, ProjecCreateDto projecCreateDto) {
        Project project = findByIdAndToDelete(id);
        project.update(projecCreateDto);
        return project.toProjectFindDto();
    }

    @Transactional
    public UUID delete(UUID id) {
        Project project = findByIdAndToDelete(id);
        project.inputDelete();
        return id;
    }

    @Transactional
    public ProjectFindDto sponsorship(UUID id, long fundingAmount) {
        Project project = findByIdAndToDelete(id);
        project.sponsorship(fundingAmount);
        return project.toProjectFindDto();
    }
}
