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
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    private static final Logger log = getLogger(ProjectController.class);

    @PostMapping("/create")
    public CommonResponse create(@RequestBody @Valid ProjectDto projectDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return CommonResponse.failure(bindingResult);
        }

        projectService.save(projectDto);
        return CommonResponse.success(projectDto.toString());
    }

    @GetMapping("/update-form/{id}")
    public CommonResponse updateData(@PathVariable UUID id) {
        return CommonResponse.success(projectService.findByIdAndToDelete(id));
    }

    @PutMapping("/update/{id}")
    public CommonResponse update(@PathVariable UUID id, @Valid @RequestBody ProjectDto projectDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return CommonResponse.failure(bindingResult);
        }
        projectService.update(id, projectDto);
        return CommonResponse.success(projectDto);
    }

    @GetMapping("/show/{id}")
    public CommonResponse projectShow (@PathVariable UUID id) {
        projectService.findByIdAndToDelete(id);
        return CommonResponse.success(projectService.findByIdAndToDelete(id).toProjectDto());
    }

    @GetMapping("/projectList")
    public CommonResponse projectList(@RequestBody Pageable pageable) {
        return CommonResponse.success(projectService.availableProjectList(pageable));
    }

    @DeleteMapping("delect/{id}")
    public CommonResponse delete(@PathVariable UUID id) {
        projectService.delete(id);
        return CommonResponse.delete(id);
    }

    @PostMapping("/sponsorship/{id}")
    public CommonResponse sponsorship(@PathVariable UUID id, @RequestBody long fundingAmount) {
        projectService.sponsorship(id, fundingAmount);
        return CommonResponse.success(projectService.sponsorship(id, fundingAmount));
    }
}
