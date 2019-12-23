package mission.dto;

import lombok.*;
import mission.domain.Project;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private String title;

    private String explanation;

    //특수문자 불허. 단 '_'는 허용
    private String originatorName;

    private String originatorEmail;

    //휴대폰 양식????
    private String originatorPhone;

//    @Column
//    //24시간 단위
//    private Data startTime;
//
//    @Column
//    //24시간 단위
//    private Data EndTime;

    private Long targetAmount;

    private Long fundingCount;

    private Long fundingAmount;

    private String state;


    public ProjectDto(String title, String originatorName, Long targetAmount, Long fundingCount, Long fundingAmount, String state) {
        this.title = title;
        this.originatorName = originatorName;
        this.targetAmount = targetAmount;
        this.fundingCount = fundingCount;
        this.fundingAmount = fundingAmount;
        this.state = state;
    }

    public Project to_project () {
        return new Project();
    }
}
