package com.example.scheduleservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scheduleservice.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByEmployeeId(Integer employee_id);
}
