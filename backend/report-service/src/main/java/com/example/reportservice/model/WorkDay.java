package com.example.reportservice.model;

public class WorkDay {
    private Integer scheduleId;
    private String date;
    private String inHour;
    private String outHour;
    private Double hours;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInHour() {
        return inHour;
    }

    public void setInHour(String inHour) {
        this.inHour = inHour;
    }

    public String getOutHour() {
        return outHour;
    }

    public void setOutHour(String outHour) {
        this.outHour = outHour;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }
}
