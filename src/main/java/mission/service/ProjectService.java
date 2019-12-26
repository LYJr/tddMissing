package mission.service;

import mission.common.CommonState;
import mission.domain.Project;
import mission.domain.ProjectRepository;
import mission.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Project findById(long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 없습니다."));
        return project;
    }

    public Project save (ProjectDto projectDto) {
        return projectRepository.save(projectDto.to_project());
    }

    @Transactional
    public Project update(long id, ProjectDto projectDto) throws IllegalArgumentException {
        Project project = findById(id);
        project = projectDto.to_project();
        return project;
    }

    @Transactional
    public long delect(long id) {
        Project project = findById(id);
        project.isDelect();
        return id;
    }

    public List<Project> permitProjectList () {
        List<Project> findAll = findAll();

        List<Project> projects = new ArrayList<>();
        for (Project project : findAll) {
            if(project.get허용() == CommonState.PERMIT) {
                projects.add(project);
            }
        }
        return projects;
    }

}
