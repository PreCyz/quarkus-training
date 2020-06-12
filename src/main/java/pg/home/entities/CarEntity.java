package pg.home.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
public class CarEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean active;

    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime created;

    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime firstRegistrationDate;

    private String description;

    public CarEntity() { }

    public CarEntity(boolean active, LocalDateTime created, LocalDateTime firstRegistrationDate) {
        this(null, active, created, firstRegistrationDate);
    }

    public CarEntity(Long id, boolean active, LocalDateTime created, LocalDateTime firstRegistrationDate) {
        this.id = id;
        this.active = active;
        this.created = created;
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(LocalDateTime firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", active=" + active +
                ", created=" + created +
                ", firstRegistrationDate=" + firstRegistrationDate +
                '}';
    }
}
