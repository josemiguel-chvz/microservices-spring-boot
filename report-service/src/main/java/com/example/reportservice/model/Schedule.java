package com.example.reportservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Integer id;
    private String date;
    private String in_hour;
    private String out_hour;
    private Integer employeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIn_hour() {
        return in_hour;
    }

    public void setIn_hour(String in_hour) {
        this.in_hour = in_hour;
    }

    public String getOut_hour() {
        return out_hour;
    }

    public void setOut_hour(String out_hour) {
        this.out_hour = out_hour;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
