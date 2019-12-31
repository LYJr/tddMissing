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
    @Enumerated(EnumType.STRING)
    private CommonState show;

    @Column
    @Enumerated(EnumType.STRING)
    private ProjectState state;

    @Column
    @Enumerated(EnumType.STRING)
    private CommonState isDelect;

    public Project(String title, String originatorName, LocalDateTime startTime, LocalDateTime endTime, Long targetAmount, Long fundingSponsor, Long fundingAmount, ProjectState state) {
        this.title = title;
        this.originatorName = originatorName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.targetAmount = targetAmount;
        this.fundingSponsor = fundingSponsor;
        this.fundingAmount = fundingAmount;
        this.state = state;
    }

    public Project(String title, String explanation, String originatorName, String originatorEmail, String originatorPhone, LocalDateTime startTime, LocalDateTime endTime, Long targetAmount, Long fundingSponsor, Long fundingAmount, CommonState show, CommonState isDelect) {
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
        this.state = stateUpdate(startTime, endTime, targetAmount, fundingAmount);
        this.isDelect = isDelect;
    }

    public UUID isDelect() {
        this.isDelect = CommonState.DELECT;
        return id;
    }

    public ProjectDto toProjectDto () {
        return new ProjectDto(
                title, explanation, originatorName, originatorEmail, originatorPhone,
                startTime, endTime, targetAmount, fundingSponsor, fundingAmount, show, state, isDelect);
    }

    private ProjectState stateUpdate(LocalDateTime startTime, LocalDateTime endTime, long targetAmount, long fundingAmount) {
        ProjectState projectState = ProjectState.PROCEEDING;

        if(!isStartTimeCheck(startTime)) {
            projectState = ProjectState.PREPARING;
        }

        if(isStartTimeCheck(startTime) && isEndTimeCheck(endTime)) {
            return isSuccess(targetAmount, fundingAmount);
        }

        return projectState;
    }

    private ProjectState isSuccess(long targetAmountm, long fundingAmount) {
        return targetAmountm <= fundingAmount ? ProjectState.SUCCESS : ProjectState.FAILURE;
    }

    private boolean isStartTimeCheck(LocalDateTime start) {
        return start.isEqual(LocalDateTime.now()) || start.isBefore(LocalDateTime.now());
    }

    private boolean isEndTimeCheck(LocalDateTime end) {
        return end.isBefore(LocalDateTime.now()) || end.isEqual(LocalDateTime.now());
    }
}
