package tech.csm.model;

// Season.java
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Season")
@Data
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id") // Explicit column name
    private int seasonId;

    @Column(name = "season_name", nullable = false)
    private String seasonName;
}
