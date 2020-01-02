package mission.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import mission.common.CommonState;
import mission.common.Regex;
import mission.domain.Project;
import mission.domain.QProject;
import mission.dto.ProjectListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Transactional(readOnly = true)
public class ProjectCustomRepositoryImpl extends QuerydslRepositorySupport implements ProjectCustomRepository{

    @Autowired
    private JPAQueryFactory queryFactory;

    public ProjectCustomRepositoryImpl() {
        super(Project.class);
    }

    @Override
    public Page<ProjectListDto> availablePageProjectList(Pageable pageable, CommonState isDelect) {
        QProject project = QProject.project;

        JPQLQuery<ProjectListDto> query = queryFactory
                .select(Projections.fields(ProjectListDto.class,
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
                .offset(pageable.getOffset())
                .limit(Regex.PAGE_LIMIT)
                .fetchAll();

        long total = query.fetchCount();
        JPQLQuery pagedQuery = getQuerydsl().applyPagination(pageable, query);
        List<ProjectListDto> result = total > pageable.getOffset() ? pagedQuery.fetch() : Collections.emptyList();

        return new PageImpl<ProjectListDto>(result, pageable, total);
    }
}
