package mission.domain.repository;

import mission.common.CommonState;
import mission.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID>, ProjectCustomRepository {
    Project findByIsDelectEquals(CommonState commonState);
}
