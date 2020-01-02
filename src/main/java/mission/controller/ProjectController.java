package mission.controller;

import mission.common.CommonResponse;
import mission.dto.ProjectDto;
import mission.service.ProjectService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    private static final Logger log = getLogger(ProjectController.class);

    @PostMapping("/create")
    public CommonResponse create(@RequestBody @Valid ProjectDto projectDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return CommonResponse.failure(bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
        }

        projectService.save(projectDto);
        return CommonResponse.success(projectDto.toString());
    }

    @GetMapping("/update-form")
    public CommonResponse updateData (@PathVariable UUID id) {
        return CommonResponse.success(projectService.findById(id));
    }

    @PutMapping("/update/{id}")
    public CommonResponse update(@PathVariable UUID id, @Valid @RequestBody ProjectDto projectDto) {
        projectService.update(id, projectDto);
        return CommonResponse.success(projectDto);
    }

    @DeleteMapping("delect/{id}")
    public CommonResponse delect(@PathVariable UUID id) {
        projectService.delect(id);
        return CommonResponse.delect(id);
    }

    @GetMapping("/show/{id}")
    public CommonResponse projectShow (@PathVariable UUID id) {
        projectService.findById(id);
        return CommonResponse.success(projectService.findById(id).toProjectDto());
    }

    @GetMapping("/projectList")
    public CommonResponse projectList(Pageable pageable) {
        return CommonResponse.success(projectService.availableProjectList(pageable));
    }

    @PostMapping("/sponsorship")
    public CommonResponse sponsorship(@PathVariable UUID id, @PathVariable long fundingAmount) {
        projectService.sponsorship(id, fundingAmount);
        return CommonResponse.success(projectService.sponsorship(id, fundingAmount));
    }

}
