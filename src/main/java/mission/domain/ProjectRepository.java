package mission.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    //프로젝트 List로 보여줄 경우
    //프로젝트 제목, 창작자 이름, 목표액, 후원수, 후원액, 프로젝트 상태, 시작일, 마감일


}
