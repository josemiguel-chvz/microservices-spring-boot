package com.example.reportservice.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.reportservice.model.Employee;
import com.example.reportservice.model.Report;
import com.example.reportservice.model.Schedule;
import com.example.reportservice.model.WorkDay;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReportService {

    @Autowired
    RestTemplate restTemplate;

    public List<Report> getAll() {
        List<Employee> employees = getEmployees();
        List<Report> reports = new ArrayList<>();
        for (Employee employee : employees) {
            Report report = new Report();
            List<Schedule> schedules = getSchedulesByEmployee(employee.getId());
            List<WorkDay> workDays = getWorkDays(schedules);
            report.setEmployeeId(employee.getId());
            report.setEmployeeName(employee.getName());
            report.setEmployeeCategory(employee.getCategory());
            report.setWorkDays(workDays);
            reports.add(report);
        }
        return reports;
    }

    public List<Employee> getEmployees() {
        ResponseEntity<Object[]> response = restTemplate.getForEntity(
            "http://employee-service/employee",
            Object[].class
        );
        Object[] records = response.getBody();
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(records)
                .map(employee -> mapper.convertValue(employee, Employee.class))
                .collect(Collectors.toList());
    }

    public List<Schedule> getSchedulesByEmployee(Integer employee_id) {
        ResponseEntity<Object[]> response = restTemplate.getForEntity(
            String.format("http://schedule-service/schedule?employee_id=%d",employee_id),
            Object[].class
        );
        Object[] records = response.getBody();
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(records)
                .map(schedule -> mapper.convertValue(schedule, Schedule.class))
                .collect(Collectors.toList());
    }

    public List<WorkDay> getWorkDays(List<Schedule> schedules) {
        List<WorkDay> workDays = new ArrayList<>();
        for (Schedule schedule : schedules) {
            WorkDay workDay = new WorkDay();
            Double hours = getHours(schedule.getIn_hour(), schedule.getOut_hour());
            workDay.setDate(schedule.getDate());
            workDay.setHours(hours);
            workDays.add(workDay);
        }
        return workDays;
}

    Double getHours(String in_hour, String out_hour) {
        String in_hour_d = in_hour.replace(":", ".");
        String out_hour_d = out_hour.replace(":", ".");
        Double hours = (Double.parseDouble(out_hour_d)) - (Double.parseDouble(in_hour_d));
        DecimalFormat df = new DecimalFormat("#.##");
        hours = Double.valueOf(df.format(hours));
        return hours;
    }
}
