package tech.csm.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "crop_insurance")
@Data
public class CropInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private int insuranceId;

    @ManyToOne
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

    @Column(name = "FarmerName", nullable = false, length = 50)
    private String farmerName;

    @Column(name = "AadhaarNo", nullable = false, length = 12)
    private String aadhaarNo;

    @Column(name = "Fathername", nullable = false, length = 12)
    private String fatherName;

    @Column(name = "CompleteAddress", nullable = false, length = 250)
    private String completeAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "FarmerCategory", nullable = false)
    private FarmerCategory farmerCategory;
}