package tech.csm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Sales {
    private int salesId;
    private Date salesDate;
    private Garage garage;
    private Tyre tyre;
    private int salesQuantity;
}