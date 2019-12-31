package mission.domain.repository;

import mission.common.CommonState;
import mission.dto.ProjectListDto;

import java.util.List;

public interface ProjectCustomRepository<T> {
    List<ProjectListDto> findAvailableProjectList(CommonState isDelect);

}
