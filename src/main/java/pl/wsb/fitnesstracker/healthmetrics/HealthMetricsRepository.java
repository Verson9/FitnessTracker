package pl.wsb.fitnesstracker.healthmetrics;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthMetricsRepository extends JpaRepository<HealthMetrics, Long> {
}
