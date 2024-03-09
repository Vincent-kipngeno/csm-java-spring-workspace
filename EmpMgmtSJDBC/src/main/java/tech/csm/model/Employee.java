package tech.csm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Employee {
    private int empId;
    private String name;
    private Date hireDate;
    private double salary;
    private String employmentType;
    private int deptId;
    private boolean isDeleted; // Assuming `isDelete` is a boolean now
}
