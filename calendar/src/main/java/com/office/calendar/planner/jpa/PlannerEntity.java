package com.office.calendar.planner.jpa;

import com.office.calendar.planner.PlannerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PLAN")
public class PlannerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private int planNo;

    @Column(name = "ori_no")
    private int planOriNo;

    @Column(name = "owner_id")
    private String planOwnerId;

    @Column(name = "ori_owner_id")
    private String planOriOwnerId;

    @Column(name = "year")
    private int planYear;

    @Column(name = "month")
    private int planMonth;

    @Column(name = "date")
    private int planDate;

    @Column(name = "title")
    private String planTitle;

    @Column(name = "body")
    private String planBody;

    @Column(name = "img_name")
    private String planImgName;

    @Column(name = "reg_date")
    private LocalDateTime planRegDate;

    @Column(name = "mod_date")
    private LocalDateTime planModDate;

    @PrePersist
    private void prePersist() {
        planRegDate = LocalDateTime.now();
        planModDate = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        planModDate = LocalDateTime.now();
    }

    public PlannerDto toDto() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH-mm-ss");

        return PlannerDto.builder()
                .no(planNo)
                .ori_no(planOriNo)
                .owner_id(planOwnerId)
                .ori_owner_id(planOriOwnerId)
                .year(planYear)
                .month(planMonth)
                .date(planDate)
                .title(planTitle)
                .body(planBody)
                .img_name(planImgName)
                .reg_date(planRegDate != null ? LocalDateTime.parse(planRegDate, formatter) : null)
                .mod_date(planModDate != null ? LocalDateTime.parse(planModDate, formatter) : null)
                .build();

    }

}
