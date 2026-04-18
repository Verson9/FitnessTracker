package pl.wsb.fitnesstracker.training.internal;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.wsb.fitnesstracker.training.api.Training;

import java.util.List;

@Getter
@Entity
@Table(name = "activity_types")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    private String displayName;

    @OneToMany(mappedBy = "activityType")
    private List<Training> trainings;

    // Keep static instances to preserve existing references like ActivityType.RUNNING
    public static final ActivityType RUNNING = new ActivityType("RUNNING", "Running");
    public static final ActivityType CYCLING = new ActivityType("CYCLING", "Cycling");
    public static final ActivityType WALKING = new ActivityType("WALKING", "Walking");
    public static final ActivityType SWIMMING = new ActivityType("SWIMMING", "Swimming");
    public static final ActivityType TENNIS = new ActivityType("TENNIS", "Tennis");

    public ActivityType(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }
}
