package com.accenture.enrollment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.enrollment.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
