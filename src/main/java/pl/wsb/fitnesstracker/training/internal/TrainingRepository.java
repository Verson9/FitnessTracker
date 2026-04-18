package pl.wsb.fitnesstracker.training.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wsb.fitnesstracker.training.api.Training;
import pl.wsb.fitnesstracker.user.api.User;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    @Query("SELECT COALESCE(SUM(t.distance), 0) FROM Training t WHERE t.user = :user")
    Long getTotalUserDistance(User user);
}
