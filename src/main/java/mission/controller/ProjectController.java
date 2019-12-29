package mission.controller;

import mission.common.CommonService;
import mission.common.CommonResponse;
import mission.common.CommonState;
import mission.dto.ProjectDto;
import mission.service.ProjectService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    private static final Logger log = getLogger(ProjectController.class);

    @PostMapping("create")
    public CommonResponse create(@RequestBody @Valid ProjectDto projectDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return CommonService.failure(bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
        }

        projectService.save(projectDto);
        return CommonService.success(projectDto.toString());
    }

    @GetMapping("update/")
    public CommonResponse updateData (@PathVariable Long id) {
        return CommonService.success(projectService.findById(id));
    }

    @PutMapping("update/{id}")
    public CommonResponse update(@PathVariable Long id, @Valid @RequestBody ProjectDto projectDto) {
        projectService.update(id, projectDto);
        return CommonService.success(projectDto);
    }

//    @DeleteMapping("delect/{id}")
//    public CommonResponse delect(@PathVariable Long id) {
//        projectService.delect(id);
//        return CommonService.delect(id);
//    }

//    @GetMapping("show/")
//    public CommonResponse projectShow (@PathVariable Long id) {
//        projectService.findById(id);
//        return CommonService.success(projectService.findById(id));
//    }
//
//    @GetMapping("projectList/")
//    public CommonResponse projectList () {
//        return null;
//    }

}
