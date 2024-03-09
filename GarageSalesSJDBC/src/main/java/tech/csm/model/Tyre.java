package tech.csm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tyre {
    private int tyreId;
    private String tyreName;
    private int quantity;
    private double unitPrice;
}

