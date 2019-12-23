package mission.controller;

import mission.domain.Project;
import mission.dto.ProjectDto;
import mission.service.ProjectService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    private static final Logger log = getLogger(ProjectController.class);

    @PostMapping("/create")
    public ResponseEntity<Project> create(@RequestBody ProjectDto projectDto){
        log.debug("확인용 : {}" , projectDto.toString());

        return null;
    }

}
