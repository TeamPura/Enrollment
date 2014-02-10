package com.accenture.enrollment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.enrollment.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
