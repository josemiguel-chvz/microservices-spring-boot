package com.example.reportservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reportservice.model.Report;
import com.example.reportservice.service.ReportService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping
    public ResponseEntity<List<Report>> getAll() {
        try {
            List<Report> reports = reportService.getAll();
            if (reports.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
}