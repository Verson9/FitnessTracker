package pl.wsb.fitnesstracker.workoutsession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutSessionsRepository extends JpaRepository<WorkoutSession, Long> {
}
