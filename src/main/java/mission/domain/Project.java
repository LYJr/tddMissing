package mission.domain;

import lombok.*;
import mission.common.CommonState;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

    @Column
    private String title;

//    @Column
//    private String explanation;
//
//    @Column
//    private String originatorName;
//
//    @Column(unique = true)
//    private String originatorEmail;
//
//    @Column(unique = true)
//    private String originatorPhone;
//
//    @Column
//    private LocalDateTime startTime;
//
//    @Column
//    private LocalDateTime endTime;
//
//    @Column
//    private Long targetAmount;
//
//    @Column
//    private Long fundingCount;
//
//    @Column
//    private Long fundingAmount;
//
//    @Column
//    private boolean show;
//
//    @Column
//    private ProjectState state;
//
//    @Column
//    private CommonState isDelect;

    public Project( String title) {
        this.title = title;
    }


//    public long isDelect() {
//        this.isDelect = CommonState.DELECT;
//        return id;
//    }
}
