package mission.service;

import mission.common.CommonState;
import mission.domain.Project;
import mission.domain.repository.ProjectRepository;
import mission.dto.ProjectDto;
import mission.dto.ProjectListDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ProjectListDto> availableProjectList() {
        return projectRepository.availableProjectList(CommonState.PERMIT);
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

//    @Transactional
//    public long delect(long id) {
//        Project project = findById(id);
//        project.isDelect();
//        return id;
//    }
//
//    public List<Project> permitProjectList () {
//        List<Project> findAll = findAll();
//
//        List<Project> projects = new ArrayList<>();
//        for (Project project : findAll) {
//            if(project.getIsDelect() == CommonState.PERMIT) {
//                projects.add(project);
//            }
//        }
//        return projects;
//    }

}
