package tech.csm.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Crop")
@Data
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crop_id")
    private int cropId;

    @Column(name = "crop_name", nullable = false)
    private String cropName;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
}