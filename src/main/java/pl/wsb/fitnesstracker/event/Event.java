package pl.wsb.fitnesstracker.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.wsb.fitnesstracker.userevent.UserEvent;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Events")
@NoArgsConstructor
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Setter
    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column
    private String country;

    @Column
    private String city;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEvent> userEvents;

    public Event(String name, String description, LocalDateTime startTime, String country, String city) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.country = country;
        this.city = city;
    }
}
