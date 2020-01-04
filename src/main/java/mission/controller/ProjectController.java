package mission.controller;

import mission.common.CommonResponse;
import mission.dto.ProjecCreateDto;
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
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    private static final Logger log = getLogger(ProjectController.class);

    @PostMapping("/create")
    public CommonResponse create(@RequestBody @Valid ProjecCreateDto projecCreateDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return CommonResponse.failure(bindingResult);
        }
        return CommonResponse.success(projectService.save(projecCreateDto));
    }

    @GetMapping("/update-form/{id}")
    public CommonResponse updateData(@PathVariable UUID id) {
        return CommonResponse.success(projectService.findByIdAndToDelete(id).toProjectFindDto());
    }

    @PutMapping("/update/{id}")
    public CommonResponse update(@PathVariable UUID id, @Valid @RequestBody ProjecCreateDto projecCreateDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return CommonResponse.failure(bindingResult);
        }
        return CommonResponse.success(projectService.update(id, projecCreateDto));
    }

    @GetMapping("/show/{id}")
    public CommonResponse projectShow (@PathVariable UUID id) {
        projectService.findByIdAndToDelete(id);
        return CommonResponse.success(projectService.findByIdAndToDelete(id).toProjectFindDto());
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

    @PutMapping("/sponsorship/{id}")
    public CommonResponse sponsorship(@PathVariable UUID id, @RequestBody Long fundingAmount) {
        return CommonResponse.success(projectService.sponsorship(id, fundingAmount));
    }
}
