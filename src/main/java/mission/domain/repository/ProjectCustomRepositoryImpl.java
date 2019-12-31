package mission.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import mission.common.CommonState;
import mission.domain.Project;

import mission.domain.QProject;
import mission.dto.ProjectListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class ProjectCustomRepositoryImpl extends QuerydslRepositorySupport implements ProjectCustomRepository{

    @Autowired
    private JPAQueryFactory queryFactory;

    public ProjectCustomRepositoryImpl() {
        super(Project.class);
    }

    @Override
    //해당 project의 isDelect에 따라 리스트를 가져온다.
    public List<ProjectListDto> availableProjectList(CommonState isDelect) {
        QProject project = QProject.project;
        return queryFactory.select(Projections.constructor(ProjectListDto.class,
                project.title,
                project.originatorName,
                project.targetAmount,
                project.fundingSponsor,
                project.fundingAmount,
                project.state,
                project.startTime,
                project.endTime))
                .from(project)
                .where(project.isDelect.eq(isDelect))
                .fetch();
    }
}
