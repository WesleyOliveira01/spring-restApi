package com.example.apiUserDept.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiUserDept.entities.Department.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
