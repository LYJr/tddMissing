package mission.domain;

import lombok.*;
import mission.common.CommonState;
import mission.dto.ProjectDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column
    private String title;

    @Column
    private String explanation;

    @Column
    private String originatorName;

    @Column(unique = true)
    private String originatorEmail;

    @Column(unique = true)
    private String originatorPhone;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private Long targetAmount;

    @Column
    private Long fundingSponsor;

    @Column
    private Long fundingAmount;

    @Column
    private boolean show;

    @Column
    private ProjectState state;

    @Column
    private CommonState isDelect;

    public Project(String title, String explanation, String originatorName, String originatorEmail, String originatorPhone, LocalDateTime startTime, LocalDateTime endTime, Long targetAmount, Long fundingSponsor, Long fundingAmount, boolean show, ProjectState state, CommonState isDelect) {
        this.title = title;
        this.explanation = explanation;
        this.originatorName = originatorName;
        this.originatorEmail = originatorEmail;
        this.originatorPhone = originatorPhone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.targetAmount = targetAmount;
        this.fundingSponsor = fundingSponsor;
        this.fundingAmount = fundingAmount;
        this.show = show;
        this.state = state;
        this.isDelect = isDelect;
    }

    public UUID isDelect() {
        this.isDelect = CommonState.DELECT;
        return id;
    }

    public ProjectDto to_projectDto () {
        return new ProjectDto(
                title, explanation, originatorName, originatorEmail, originatorPhone,
                startTime, endTime, targetAmount, fundingSponsor, fundingAmount, show, state, isDelect);
    }
}
