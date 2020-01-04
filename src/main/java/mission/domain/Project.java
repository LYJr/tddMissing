package mission.domain;

import lombok.*;
import mission.common.CommonState;
import mission.dto.ProjecCreateDto;
import mission.dto.ProjectFindDto;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private CommonState toDelete;

    public Project(String title, String explanation, String originatorName, String originatorEmail, String originatorPhone, LocalDateTime startTime, LocalDateTime endTime, Long targetAmount, Long fundingSponsor, Long fundingAmount, CommonState show) {
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
        this.show = inputShow(show);
        this.state = stateUpdate(startTime, endTime, targetAmount, fundingAmount);
        this.toDelete = CommonState.PERMIT;
    }

    private CommonState inputShow(CommonState show) {
        if(show == null){
            return CommonState.OPEN;
        }
        return CommonState.AIRTIGHT;
    }

    public void update(ProjecCreateDto projecCreateDto) {
        this.title = projecCreateDto.getTitle();
        this.explanation = projecCreateDto.getExplanation();
        this.originatorName = projecCreateDto.getOriginatorName();
        this.originatorEmail = projecCreateDto.getOriginatorEmail();
        this.originatorPhone = projecCreateDto.getOriginatorPhone();
        this.startTime = projecCreateDto.getStartTime();
        this.endTime = projecCreateDto.getEndTime();
        this.targetAmount = projecCreateDto.getTargetAmount();
        this.fundingSponsor = projecCreateDto.getFundingSponsor();
        this.fundingAmount = projecCreateDto.getFundingAmount();
        this.show = inputShow(show);
        this.state = stateUpdate(projecCreateDto.getStartTime(), projecCreateDto.getEndTime(), projecCreateDto.getTargetAmount(), projecCreateDto.getFundingAmount());
    }

    private ProjectState stateUpdate(LocalDateTime startTime, LocalDateTime endTime, long targetAmount, long fundingAmount) {
        if(!isStartTimeCheck(startTime)) {
            return ProjectState.PREPARING;
        }

        if(isStartTimeCheck(startTime) && isEndTimeCheck(endTime)) {
            return isSuccess(targetAmount, fundingAmount);
        }
        return ProjectState.PROCEEDING;
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

    public void sponsorship(long fundingAmount) {
        this.fundingSponsor++;
        this.fundingAmount = this.fundingAmount + fundingAmount;
    }

    public UUID inputDelete() {
        this.toDelete = CommonState.DELECT;
        return id;
    }

    public ProjectFindDto toProjectFindDto(){
        return new ProjectFindDto(id, title, explanation, originatorName, originatorEmail, originatorPhone, startTime, endTime, targetAmount, fundingSponsor, fundingAmount, show, state);
    }
}
