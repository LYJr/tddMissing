package mission.domain;

import lombok.*;
import mission.common.CommonState;
import mission.dto.ProjectDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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
    private Long fundingCount;

    @Column
    private Long fundingAmount;

    @Column
    private boolean show;

    @Column
    private ProjectState state;

    @Column
    private CommonState 허용;

    public Project(String title, String explanation, String originatorName, String originatorEmail, String originatorPhone, LocalDateTime startTime, LocalDateTime endTime, Long targetAmount, boolean show, ProjectState state, CommonState 허용) {
        this.title = title;
        this.explanation = explanation;
        this.originatorName = originatorName;
        this.originatorEmail = originatorEmail;
        this.originatorPhone = originatorPhone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.targetAmount = targetAmount;
        this.show = show;
        this.state = state;
        this.허용 = 허용;
    }

    public long isDelect() {
        this.허용 = CommonState.DELECT;
        return id;
    }
}
