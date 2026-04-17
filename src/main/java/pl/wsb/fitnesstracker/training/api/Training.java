package pl.wsb.fitnesstracker.training.api;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.training.internal.ActivityType;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.workoutsession.WorkoutSession;

import java.util.Date;

@Getter
@Entity
@Table(name = "Trainings")
@NoArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Date startTime;

    @Setter
    private Date endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_type", referencedColumnName = "activity_type")
    private ActivityType activityType;

    @Column
    private Double distance;

    @Column(name = "average_speed")
    private Double averageSpeed;

    @OneToOne(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private WorkoutSession workoutSession;

    public Training(User user, Date startTime, Date endTime, ActivityType activityType, double distance, double averageSpeed) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }
}