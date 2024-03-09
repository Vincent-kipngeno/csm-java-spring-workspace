package tech.csm.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Garage {
    private int garageId;
    private String garageName;
    private String address;
}
