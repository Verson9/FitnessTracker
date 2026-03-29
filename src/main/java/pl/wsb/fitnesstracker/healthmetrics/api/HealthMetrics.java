package pl.wsb.fitnesstracker.healthmetrics.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "HEALTH_METRICS")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "measured_at", nullable = false)
    private LocalDate measuredAt;

    @Column(name = "weight_kg")
    @Nullable
    private Double weightKg;

    @Column(name = "height_cm")
    @Nullable
    private Double heightCm;

    @Column(name = "resting_heart_rate")
    @Nullable
    private Integer restingHeartRate;

    @Column(name = "blood_pressure_systolic")
    @Nullable
    private Integer bloodPressureSystolic;

    @Column(name = "blood_pressure_diastolic")
    @Nullable
    private Integer bloodPressureDiastolic;

    @Column(name = "body_fat_percent")
    @Nullable
    private Double bodyFatPercentage;

    @Column(name = "sleep_hours")
    @Nullable
    private Double sleepHours;

    @Column(name = "steps")
    @Nullable
    private Integer steps;

}
