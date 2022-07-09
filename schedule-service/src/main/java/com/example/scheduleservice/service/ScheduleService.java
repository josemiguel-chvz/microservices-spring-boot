package com.example.scheduleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scheduleservice.entity.Schedule;
import com.example.scheduleservice.repository.ScheduleRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getAllByEmployeeId(Integer employeeId) {
        return scheduleRepository.findByEmployeeId(employeeId);
    }

    public Schedule getScheduleById(int id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public List<Schedule> getSchedulesByEmployeeId(int id) {
        return scheduleRepository.findByEmployeeId(id);
    }

    public Schedule createSchedule(Schedule schedule) {
        Schedule newSchedule = scheduleRepository.save(schedule);
        return newSchedule;
    }

}
