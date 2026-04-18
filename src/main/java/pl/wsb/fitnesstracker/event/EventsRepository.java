package pl.wsb.fitnesstracker.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EventsRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.startTime > :now ORDER BY e.startTime")
    List<Event> findUpcoming(@Param("now") LocalDate now);

    @Query("SELECT e.name AS name, COUNT(ue) AS participants " +
            "FROM Event e LEFT JOIN e.userEvents ue " +
            "GROUP BY e.name " +
            "ORDER BY e.name")
    Map<String, Long> findEventNamesWithParticipantCountProjection();

}