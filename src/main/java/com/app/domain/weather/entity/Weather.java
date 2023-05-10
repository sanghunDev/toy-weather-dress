package com.app.domain.weather.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherId;

    private Double tmp; // 기온

    private Double rainAmount;  // 강수량

    private Double humid;   // 습도

    private LocalDateTime createdTime;  // 생성 시간

}
