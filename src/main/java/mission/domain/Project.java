package mission.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
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
    @Email
    private String originatorEmail;

    @Column(unique = true)
    private String originatorPhone;

//    @Column
//    //24시간 단위
//    private Data startTime;
//
//    @Column
//    //24시간 단위
//    private Data EndTime;

    @Column
    private Long targetAmount;

    @Column
    private Long fundingCount;

    @Column
    private Long fundingAmount;

    @Column
    private boolean show;

    @Column
    private State state;

    public Project(String title, String explanation, String originatorName, @Email String originatorEmail, String originatorPhone, Long targetAmount, Long fundingCount, Long fundingAmount, Boolean show,State state) {
        this.title = title;
        this.explanation = explanation;
        this.originatorName = originatorName;
        this.originatorEmail = originatorEmail;
        this.originatorPhone = originatorPhone;
        this.targetAmount = targetAmount;
        this.fundingCount = fundingCount;
        this.fundingAmount = fundingAmount;
        this.show = show;
        this.state = state;
    }
}
