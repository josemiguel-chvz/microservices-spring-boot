package com.example.scheduleservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scheduleservice.entity.Schedule;
import com.example.scheduleservice.service.ScheduleService;

import java.util.List;


@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping()
    public ResponseEntity<List<Schedule>> getAll() {
        try {
            List<Schedule> schedules = scheduleService.getAll();
            if (schedules.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(schedules);
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable("id") int id) {
        try {
            Schedule schedule = scheduleService.getScheduleById(id);
            if (schedule == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(schedule);
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }
    }

    @PostMapping()
    public ResponseEntity<Schedule> save(@RequestBody Schedule schedule) {
        try {
            Schedule newSchedule = scheduleService.createSchedule(schedule);
            return ResponseEntity.ok(newSchedule);
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return null;
        }
    }
}