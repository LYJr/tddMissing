package mission.domain.repository;

import mission.common.CommonState;
import mission.domain.Project;
import mission.dto.ProjectListDto;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class ProjectCustomRepositoryImpl extends QuerydslRepositorySupport implements ProjectCustomRepository{
    public ProjectCustomRepositoryImpl() {
        super(Project.class);
    }

    @Override
    //해당 project의 isDelect에 따라 리스트를 가져온다.
    public List<ProjectListDto> findAvailableProjectList(CommonState isDelect) {

        return null;
    }
}
