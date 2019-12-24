package mission.controller;

import mission.common.CommonResponse;
import mission.common.CommonState;
import mission.dto.ProjectDto;
import mission.service.ProjectService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    private static final Logger log = getLogger(ProjectController.class);

    @PostMapping("create")
    public CommonResponse create(@RequestBody ProjectDto projectDto) {
        projectService.save(projectDto);
        return CommonResponse.builder()
                .project(projectDto.to_project())
                .message("ok?")
                .state(CommonState.SUCCESS).build();
    }
}
