package mission.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //uuid 타입
    private Long id;

    @Column
    @Size(max = 50)
    //특수문자 불허
    private String title;

    @Column
    @Size(max =  255)
    private String explanation;

    @Column
    @Size(max = 20)
    //특수문자 불허. 단 '_'는 허용
    private String originatorName;

    @Column(unique = true)
    @Email
    private String originatorEmail;

    @Column(unique = true)
    //휴대폰 양식????
    private String originatorPhone;

    @Column
    //24시간 단위
    private Data startTime;

    @Column
    //24시간 단위
    private Data EndTime;

    @Column
    @Size(max = 100000000)
    private Long targetAmount;

    @Column
    @Size(max = 100000)
    private Long fundingCount;

    @Column
    private Long fundingAmount;

    @Column
    private boolean show = true;

    @Column
    private String state;

}
