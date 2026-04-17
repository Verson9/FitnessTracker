package pl.wsb.fitnesstracker.healthmetrics.api;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;


@Entity
@Table(name = "Health_Metrics")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private Double weight;

    @Column
    private Double height;

    @Column(name = "heart_rate")
    private Integer heartRate;

    public HealthMetrics(User user, LocalDate date, Double weight, Double height, Integer heartRate) {
        this.user = user;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.heartRate = heartRate;
    }
}
