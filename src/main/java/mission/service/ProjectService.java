package mission.service;

import mission.domain.Project;
import mission.domain.ProjectRepository;
import mission.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    public Project save (ProjectDto projectDto) {
        return projectDto.to_project();
    }



}
