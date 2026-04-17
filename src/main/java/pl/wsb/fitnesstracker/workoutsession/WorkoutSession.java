package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.training.api.Training;

import java.time.LocalDateTime;

@Entity
@Table(name = "Workout_Sessions")
@Getter
@NoArgsConstructor
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "start_latitude")
    private Double startLatitude;

    @Column(name = "start_longitude")
    private Double startLongitude;

    @Column(name = "end_latitude")
    @Setter
    private Double endLatitude;

    @Column(name = "end_longitude")
    @Setter
    private Double endLongitude;

    @Column
    private Double altitude;

    public WorkoutSession(Training training, LocalDateTime timestamp, double startLatitude, double startLongitude, Double altitude) {
        this.training = training;
        this.timestamp = timestamp;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.altitude = altitude;
    }
}
