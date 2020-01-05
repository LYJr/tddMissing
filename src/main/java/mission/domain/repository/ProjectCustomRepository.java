package mission.domain.repository;

import mission.common.CommonState;
import mission.dto.ProjectListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectCustomRepository<T> {
    Page<ProjectListDto> availablePageProjectList(Pageable pageable, CommonState isDelect);
}
