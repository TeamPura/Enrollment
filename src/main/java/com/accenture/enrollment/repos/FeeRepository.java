package com.accenture.enrollment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.enrollment.model.Fee;

public interface FeeRepository extends JpaRepository<Fee, Integer> {

}
