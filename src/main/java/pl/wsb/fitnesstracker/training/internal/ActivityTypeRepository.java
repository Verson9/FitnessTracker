package pl.wsb.fitnesstracker.training.internal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    default void saveDefaultActivityTypes() {
        save(ActivityType.RUNNING);
        save(ActivityType.WALKING);
        save(ActivityType.CYCLING);
        save(ActivityType.SWIMMING);
        save(ActivityType.TENNIS);
    }
}
