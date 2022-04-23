package com.furama.dto.employee;

import com.furama.models.employee.Division;
import com.furama.models.employee.EducationDegree;
import com.furama.models.employee.Position;

import javax.validation.constraints.*;

public class EmployeeDto {
    private Integer employeeId;

    @NotBlank
    @Pattern(regexp = "^[^\\d]+$", message = "The name Employee cannot contain number characters !")
    private String employeeName;

    @NotBlank(message = "Employee birthday cannot blank !")
    private String employeeBirthday;

    @NotBlank(message = "Employee id card cannot blank !")
    @Pattern(regexp = "[\\d]{9}", message = "The employee id card must contain number characters !")
    private String employeeIdCard;

    @NotNull
    @Min(value = 0, message = "salary must be positive numbers !")
    private Double employeeSalary;

    @NotBlank(message = "customer phone cannot blank !")
    @Pattern(regexp = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",
            message = "The phone number incorect format !")
    private String employeePhone;

    @NotBlank(message = "Email cannot blank !")
    @Email(message = "Incorrect email format !")
    private String employeeEmail;

    @NotBlank(message = "Address cannot blank !")
    private String employeeAddress;
    private Division division;
    private Position position;
    private EducationDegree educationDegree;

    public EmployeeDto() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }
}
