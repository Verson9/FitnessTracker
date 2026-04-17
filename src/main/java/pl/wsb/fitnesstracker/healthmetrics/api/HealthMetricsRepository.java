package pl.wsb.fitnesstracker.healthmetrics.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthMetricsRepository extends JpaRepository<HealthMetrics, Long> {
}
